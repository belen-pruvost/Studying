package LeetCode.Youtube;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
  /*
  *
  * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

    A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

    Example:
    Input: "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
    *
    Note:
    Although the above answer is in lexicographical order, your answer could be in any order you want.
  * */

  String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();

    if(digits == null || digits.length() == 0) {
      return result;
    }

    letterCombinationsRecursive(result, digits, "", 0);
    return result;
  }

  private void letterCombinationsRecursive(List<String> result, String digits, String current, int index) {
    if(index == digits.length()) {
      result.add(current);
      return;
    }

    String letters = mapping[digits.charAt(index) - '0'];
    for(int i = 0; i < letters.length(); i++) {
      letterCombinationsRecursive(result, digits, current + letters.charAt(i), index + 1);
    }
  }
}
