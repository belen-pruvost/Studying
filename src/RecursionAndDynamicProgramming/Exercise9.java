package RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class Exercise9 {

  /*
  * * Implement an algorithm to print all valid (i.e properly
   * opened and closed) combinations of n pairs of parentheses.
   * Example :
   * Input : 3
   * Output : "((()))", "(()())", "(())()", "()(())", "()()()"
  * */

  static void addParent(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index) {
    if(leftRem < 0 || rightRem < leftRem) {
      return;
    }

    if(leftRem == 0 && rightRem == 0) {
      list.add(String.copyValueOf(str));
    } else {
      str[index] = '(';
      addParent(list, leftRem - 1, rightRem, str, index + 1);

      str[index] = ')';
      addParent(list, leftRem, rightRem - 1, str, index + 1);
    }
  }

  static ArrayList<String> generateParents(int count) {
    char[] str = new char[count*2];
    ArrayList<String> list = new ArrayList<>();
    addParent(list, count, count, str, 0);
    return list;
  }

  public static void main(String[] args) {
//    System.out.println(generateParents(0));
//    System.out.println(generateParents(1));
    System.out.println(generateParents(2));
//    System.out.println(generateParents(3));
//    System.out.println(generateParents(4));
  }
}
