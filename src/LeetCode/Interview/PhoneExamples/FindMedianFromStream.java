package LeetCode.Interview.PhoneExamples;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromStream {
  private Queue<Long> small = new PriorityQueue();
  private Queue<Long> large = new PriorityQueue();

  public void addNum(int num) {
    large.add((long) num);
    small.add(-large.poll());
    if (large.size() < small.size()) {
      large.add(-small.poll());
    }
  }

  public double findMedian() {
    return large.size() > small.size()
        ? large.peek()
        : (large.peek() - small.peek()) / 2.0;
  }
}

class TestFindMedianFromStream {
  public static void main(String[] args) {
    FindMedianFromStream findMedianFromStream = new FindMedianFromStream();
    findMedianFromStream.addNum(1);
    findMedianFromStream.addNum(2);
    System.out.println(findMedianFromStream.findMedian());
    findMedianFromStream.addNum(3);
    System.out.println(findMedianFromStream.findMedian());
  }
}
