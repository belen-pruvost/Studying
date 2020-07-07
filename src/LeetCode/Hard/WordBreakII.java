package LeetCode.Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import LinkedLists.LinkedListNode;

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:
The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.

Example 1:
Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]

Example 2:
Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.

Example 3:
Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
*/

public class WordBreakII {

  //Brute force
  public List<String> wordBreakNaive(String s, List<String> wordDict) {
    return wordBreakNaive(s, new HashSet(wordDict), 0);
  }

  public List<String> wordBreakNaive(String s, Set<String> wordDict, int start) {
    LinkedList<String> result = new LinkedList<>();
    if (s.length() == start) {
      result.add("");
    }

    for (int end = start+1; end <= s.length(); end++) {
      if (wordDict.contains(s.substring(start,end))) {
        List<String> list = wordBreakNaive(s, wordDict, end);
        for (String l: list) {
          result.add(s.substring(start, end) + (l.equals("")? "" : " ") + l);
        }
      }
    }

    return result;
  }

  //Recursion with Memoization

  public List<String> wordBreakOptimal(String s, List<String> wordDict) {
    return wordBreakOptimal(s, new HashSet(wordDict), 0);
  }

  HashMap<Integer, List<String>> map = new HashMap<>();

  private List<String> wordBreakOptimal(String s, Set<String> wordDict, int start) {
    if (map.containsKey(start)) {
      return map.get(start);
    }

    LinkedList<String> res = new LinkedList<>();
    if (start == s.length()) {
      res.add("");
    }

    for (int end = start; end <= s.length(); end ++) {
      if (wordDict.contains(s.substring(start, end))) {
        List<String> list = wordBreakOptimal(s, wordDict, end);
        for(String l: list) {
          res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
        }
      }
    }
    map.put(start, res);
    return  res;
  }

  //Dynamic Programming

  public List<String> wordBreakDP(String s, List<String> wordDict) {
    Set<String> wordDictSet=new HashSet(wordDict);
    LinkedList<String>[] dp = new LinkedList[s.length() + 1];
    LinkedList<String> initial = new LinkedList<>();
    dp[0] = initial;
    for (int i = 1; i <= s.length(); i++) {
      LinkedList<String> list = new LinkedList<>();
      for (int j = 0; j < i; j++) {
        if (dp[j].size() > 0 && wordDictSet.contains(s.substring(j, i))) {
          for (String l: dp[j]) {
            list.add(s.substring(i,j) + (l.equals("") ? "" : " ") + l);
          }
        }
      }
      dp[i] = list;
    }
    return dp[s.length()];
  }
}
