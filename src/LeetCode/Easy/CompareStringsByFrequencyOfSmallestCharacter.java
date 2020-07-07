package LeetCode.Easy;

/*
* Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s.
* For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.

Now, given string arrays queries and words, return an integer array answer, where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.

Example 1:
Input: queries = ["cbd"], words = ["zaaaz"]
Output: [1]
Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").

Example 2:
Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
Output: [1,2]
Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").
* */

import java.util.ArrayList;
import java.util.Arrays;

public class CompareStringsByFrequencyOfSmallestCharacter {
  public int[] numSmallerByFrequency(String[] queries, String[] words) {
    int[] result = new int[queries.length];
    int[] wordsCount = new int[11];

    for (String w : words) {
      wordsCount[getSmallestCharacterFrequency(w)-1]++;
    }

    for(int i = wordsCount.length - 2; i >= 1; i--) {
      wordsCount[i] += wordsCount[i+1];
    }

    for(int i = 0; i < queries.length; i++) {
      int frequency = getSmallestCharacterFrequency(queries[i]);
      result[i] = wordsCount[frequency];
    }
    return result;
  }

  private int getSmallestCharacterFrequency(String s) {
    int min = 'z' - 'a';
    int frequency = 0;
    char[] letters = s.toCharArray();
    for (char c: letters) {
      int currentValue = c - 'a';
      if(currentValue < min) {
        min = currentValue;
        frequency = 1;
      } else if (currentValue == min) {
        frequency++;
      }
    }
    return frequency;
  }
}
