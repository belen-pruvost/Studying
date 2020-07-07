package LeetCode.Easy;
/*
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:
Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

Example 2:
Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".

Example 3:
Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".

Example 4:
Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?
* */

import java.util.Stack;

public class BackspaceStringCompare {
  public boolean backspaceCompare(String S, String T) {
    return getStringWithoutBackspaces(S).equals(getStringWithoutBackspaces(T));
  }

  private String getStringWithoutBackspaces(String s) {
    Stack<Character> stack = new Stack<>();

    for(Character c: s.toCharArray()) {
      if(c.equals("#")) {
        stack.pop();
      } else if (!stack.isEmpty()) {
        stack.push(c);
      }
    }
    return String.valueOf(stack);
  }

  public boolean getStringWithoutBackspacesWithPointers(String s, String t) {
    int sPointer = s.length() - 1;
    int tPointer = t.length() - 1;

    int skipS = 0, skipT = 0;

    while (sPointer >= 0 || tPointer >= 0 ) {
      while (sPointer >= 0) {
        if (s.charAt(sPointer) == '#') {
          sPointer--;
          skipS++;
        } else if (skipS > 0) {
          sPointer--;
          skipS--;
        } else {
          break;
        }
      }

      while (tPointer >= 0) {
        if (t.charAt(tPointer) == '#') {
          tPointer--;
          skipT++;
        } else if (skipT > 0) {
          tPointer--;
          skipT--;
        } else {
          break;
        }
      }

      if (sPointer >= 0 && tPointer >= 0 && s.charAt(sPointer) != t.charAt(tPointer)) {
        return false;
      }
      if ((sPointer >= 0) != (tPointer >= 0)) {
        return false;
      }

      sPointer--;
      tPointer--;
    }

    return true;
  }
}
