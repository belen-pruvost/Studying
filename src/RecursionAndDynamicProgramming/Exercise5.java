package RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class Exercise5 {
  /*
  *
  * Recursive Multiply: Write a recursive function to multiply two positive integers without using the * operator (or / operator).
  * You can use addition, subtraction and bit shifting, but you should minimize the number of those operations
  * */

  static int minProduct(int a, int b) {
    int bigger = a < b ? b : a;
    int smaller = a < b ? a : b;
    return minProductHelper(smaller, bigger);
  }

  static int minProductHelper(int smaller, int bigger) {
    if (smaller == 0) {
      return 0;
    }

    if (smaller == 1) {
      return bigger;
    }

    int s = smaller >> 1; //divide by 2
    int halfProd = minProductHelper(s, bigger);

    if(smaller % 2 == 0) {
      return halfProd + halfProd;
    }
    return halfProd + halfProd + bigger;
  }

  public static void main(String[] args) {
    System.out.println(minProduct(1,2));
    System.out.println(minProduct(1,3));
    System.out.println(minProduct(5,8));


  }
}
