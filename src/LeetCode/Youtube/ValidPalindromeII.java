package LeetCode.Youtube;

import java.util.Arrays;
import java.util.HashMap;

public class ValidPalindromeII {
  /*
  * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

    Example 1:
    Input: "aba"
    Output: True

    Example 2:
    Input: "abca"
    Output: True
    Explanation: You could delete the character 'c'.

    Note:
    The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
  */

  public boolean validPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;
    while(i < j) {
      if(s.charAt(i) != s.charAt(j)) {
        return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
      }
      i++;
      j--;
    }
    return true;
  }

  private boolean isPalindrome(String s, int i, int j) {
    while(i < j) {
      if(s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}

class TestValidPalindromeII {
  public static void main(String[] args) {
    ValidPalindromeII testValidPalindromeII = new ValidPalindromeII();
    testValidPalindromeII.validPalindrome("abca");
  }
}
