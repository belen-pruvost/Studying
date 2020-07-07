package LeetCode.Youtube;

public class DetectCapital {
  /*
  * Given a word, you need to judge whether the usage of capitals in it is right or not.
    We define the usage of capitals in a word to be right when one of the following cases holds:
    - All letters in this word are capitals, like "USA".
    - All letters in this word are not capitals, like "leetcode".
    - Only the first letter in this word is capital, like "Google".

    * Otherwise, we define that this word doesn't use capitals in a right way.

    Example 1:
    Input: "USA"
    Output: True


    Example 2:
    Input: "FlaG"
    Output: False


    Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
  */

  public boolean detectCapitalUse(String word) {
    int countOfUpperCase = 0;
    for(int i = 0; i < word.length(); i++) {
      if(Character.isUpperCase(word.charAt(i))) {
        countOfUpperCase++;
      }
    }

    return countOfUpperCase == word.length() ||
        countOfUpperCase == 0 ||
        (countOfUpperCase == 1 && Character.isUpperCase(word.charAt(0)));
  }
}

class TestDetectCapitalUse {
  public static void main(String[] args) {
    DetectCapital detectCapital = new DetectCapital();
    System.out.println(detectCapital.detectCapitalUse("ffffffffffffffffffffF"));
  }
}