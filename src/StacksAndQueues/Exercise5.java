package StacksAndQueues;


import java.util.Stack;

public class Exercise5 {
  public void sort(Stack<Integer> s) {
    Stack<Integer> r = new Stack<Integer>();

    while (!s.isEmpty()) {
     int temp = s.pop();
     while (!r.isEmpty() && r.peek() > temp) {
       s.push(r.pop());
     }
     r.push(temp);
    }

    while(!r.isEmpty()) {
      s.push(r.pop());
    }

    String j = "";
  }
}
