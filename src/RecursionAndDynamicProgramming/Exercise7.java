package RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class Exercise7 {
  /*
  *
  * Permutations without Dupes:
  * Write a method to compute all permutations of a string of unique characters
  * */

  ArrayList<String> getPerms(String str) {
    if(str == null) {
      return null;
    }

    ArrayList<String> permutations = new ArrayList<>();
    if(str.length() == 0) {
      permutations.add("");
      return permutations;
    }

    char first = str.charAt(0);
    String remainder = str.substring(1);
    ArrayList<String> words = getPerms(remainder);
    for(String word : words) {
      for(int j=0; j<word.length(); j++) {
        String s = insertCharAt(word, first, j);
        permutations.add(s);
      }
    }
    return permutations;
  }

  String insertCharAt(String word, char c, int i) {
    String start = word.substring(0,i);
    String end = word.substring(i);
    return start + c + end;
  }

  ArrayList<String> getPermsBottomUp(String remainder) {
    int len = remainder.length();
    ArrayList<String> result = new ArrayList<>();
    if(len == 0) {
      result.add("");
      return result;
    }

    for(int i = 0; i<len; i++) {
      String before = remainder.substring(0,i);
      String after = remainder.substring(i);
      ArrayList<String> partials = getPerms(before + after);

      for(String s: partials) {
        result.add(remainder.charAt(i) + s);
      }
    }

    return result;
  }

  void main(String[] args) {

  }
}
