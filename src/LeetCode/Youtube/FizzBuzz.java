package LeetCode.Youtube;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
  /*
  * Write a program that outputs the string representation of numbers from 1 to n.
  But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
  * For numbers which are multiples of both three and five output “FizzBuzz”.
  Example: n = 15,

  Return:
  [
      "1",
      "2",
      "Fizz",
      "4",
      "Buzz",
      "Fizz",
      "7",
      "8",
      "Fizz",
      "Buzz",
      "11",
      "Fizz",
      "13",
      "14",
      "FizzBuzz"
  ]
  * */
  public List<String> fizzBuzz(int n) {
    List<String> result = new ArrayList<>(n);
    for(int i=1; i <= n; i++) {
      StringBuilder sb = new StringBuilder();
      if(i % 3 ==0) {
        sb.append("Fizz");
      }
      if(i % 5 == 0) {
        sb.append("Buzz");
      }
      if(i % 3 != 0 && i % 5 != 0) {
        sb.append(i);
      }
      result.add(sb.toString());
    }
    return result;
  }
}

class TestFizzBuzz {
  public static void main (String[] args) {
    FizzBuzz fizzBuzz = new FizzBuzz();
    List<String> result = fizzBuzz.fizzBuzz(15);
    for(String s: result) {
      System.out.println(s);
    }
  }
}
