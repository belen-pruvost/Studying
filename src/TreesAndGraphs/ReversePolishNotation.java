package TreesAndGraphs;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReversePolishNotation {
  Set<String> operators = new HashSet<>();

  public ReversePolishNotation(){
    operators.add("+");
    operators.add("-");
    operators.add("*");
    operators.add("/");
  }

  public int evalRPN(String[] tokens) {
    Stack<String> stack = new Stack<>();
    for(String token : tokens) {
      if (!operators.contains(token)) {
        stack.push(token);
      } else {
        int second = Integer.valueOf(stack.pop());
        int first = Integer.valueOf(stack.pop());
        switch(token) {
          case "+":
            stack.push(String.valueOf(first + second));
            break;
          case "-":
            stack.push(String.valueOf(first - second));
            break;
          case "*":
            stack.push(String.valueOf(first * second));
            break;
          case "/":
            stack.push(String.valueOf(first / second));
            break;
        }
      }
    }
    return Integer.valueOf(stack.pop());
  }
}

class TestReversePolishNotation {
  public static void main(String[] args) {
    ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
    System.out.println(reversePolishNotation.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
  }
}
