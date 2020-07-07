package LeetCode.Youtube;

import java.util.Stack;

public class BackspaceStringCompare {
  /**
   * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
   *
   * Example 1:
   *
   * Input: S = "ab#c", T = "ad#c"
   * Output: true
   * Explanation: Both S and T become "ac".
   * Example 2:
   *
   * Input: S = "ab##", T = "c#d#"
   * Output: true
   * Explanation: Both S and T become "".
   * Example 3:
   *
   * Input: S = "a##c", T = "#a#c"
   * Output: true
   * Explanation: Both S and T become "c".
   * Example 4:
   *
   * Input: S = "a#c", T = "b"
   * Output: false
   * Explanation: S becomes "c" while T becomes "b".
   * */
  public boolean backspaceCompare(String s, String t) {
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

  public boolean backspaceCompareWithStack(String s, String t) {
    Stack<Character> sStack = processStack(s);
    Stack<Character> tStack = processStack(t);
    return sStack.toString().equals(tStack.toString());
  }

  private Stack<Character> processStack(String s) {
    Stack<Character> stack = new Stack<>();
    for(char c: s.toCharArray()) {
      if (c != '#') {
        stack.push(c);
      } else if (!stack.isEmpty()) {
        stack.pop();
      }
    }
    return stack;
  }
}

class TestBackspaceStringCompare {
  public static void main(String[] args) {
    BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
    String s = "ab#c";
    String t = "ad#c";
    System.out.println(backspaceStringCompare.backspaceCompare(s, t));
    System.out.println(backspaceStringCompare.backspaceCompareWithStack(s, t));
  }
}
