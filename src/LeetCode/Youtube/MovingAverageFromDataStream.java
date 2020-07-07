package LeetCode.Youtube;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream {
  /*
  Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

  Example:

  MovingAverage m = new MovingAverage(3);
  m.next(1) = 1
  m.next(10) = (1 + 10) / 2
  m.next(3) = (1 + 10 + 3) / 3
  m.next(5) = (10 + 3 + 5) / 3
  */
  /** Initialize your data structure here. */
  class MovingAverage {
    private int maxSize;
    private Queue<Integer> queue;
    private double sum;

    public MovingAverage(int size) {
      maxSize = size;
      queue = new LinkedList<>();
      sum = 0.0;
    }

    public double next(int val) {
      if(queue.size() == maxSize) {
        sum -= queue.remove();
      }
      queue.add(val);
      sum += val;
      return sum / queue.size();
    }
  }
}

class TestMovingAverageFromDataStream {
  public static void main(String[] args) {

  }
}
