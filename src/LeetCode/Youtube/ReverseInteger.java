package LeetCode.Youtube;

public class ReverseInteger {
  /*
  *Given a 32-bit signed integer, reverse digits of an integer.
  *
  Example 1:
  Input: 123
  Output: 321
  *
  Example 2:
  Input: -123
  Output: -321
  *
  Example 3:
  Input: 120
  Output: 21
  *
  */
  public int reverse(int x) {
    boolean negative = false;
    if (x<0) {
      negative = true;
      x *= -1;
    }

    long reversed = 0;

    while(x > 0) {
      reversed = (reversed * 10) + (x % 10);
      x /= 10;
    }

    if(reversed > Integer.MAX_VALUE) {
      return 0;
    }

    return negative ? (int)(reversed * -1) : (int) reversed;
  }
}

class TestReverseInteger {
  public static void main(String[] args){
    ReverseInteger reverseInteger = new ReverseInteger();
    int x = -123;
    System.out.println(reverseInteger.reverse(x));
  }
}
