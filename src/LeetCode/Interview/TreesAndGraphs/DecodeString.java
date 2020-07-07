package LeetCode.Interview.TreesAndGraphs;

import java.util.Stack;

public class DecodeString {
  /*
  * Given an encoded string, return its decoded string.

    The encoding rule is: k[encoded_string], where the encoded_string inside the square
    brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

    You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

    Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
    For example, there won't be input like 3a or 2[4].

    Examples:
    s = "3[a]2[bc]", return "aaabcbc".
    s = "3[a2[c]]", return "accaccacc".
    s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
  */

  int i = 0;

  public String decodeString(String s) {
    StringBuilder res = new StringBuilder();
    while (i < s.length() && s.charAt(i) != ']') {
      int num = 0;
      while (Character.isDigit(s.charAt(i))) {
        num = (num * 10) + (s.charAt(i++) - '0');
      }

      if (num != 0) {
        i++;
        String next = decodeString(s);
        while (num-- > 0) res.append(next);
        i++;
      } else {
        res.append(s.charAt(i++));
      }
    }

    return res.toString();
  }
}


class TestDecodeString {
  public static void main(String[] args) {
    DecodeString decodeString = new DecodeString();
    System.out.println(decodeString.decodeString("3[a2[c]]"));
//    System.out.println(decodeString.decodeString("12[ab]"));
  }
}