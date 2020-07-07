package MorePractice.LeetCode.Arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KStrongestValuesInAnArray {
    public int[] getStrongest(int[] arr, int k) {
      Arrays.sort(arr);

      int median = arr[(arr.length - 1)/2];
      PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> Math.abs(a - median) == Math.abs(b - median)
          ? b - a
          : Math.abs(b - median) - Math.abs(a - median));

      for(int i = 0; i < arr.length; i++) {
        heap.add(arr[i]);
      }

      int[] result = new int[k];
      for(int i = 0; i < k; i++) {
        result[i] = heap.poll();
      }
      return result;
  }
}

class TestKStrongestValuesInAnArray {
  public static void main(String[] args) {
    int[] array = new int[]{1,3,2,4,5};
    KStrongestValuesInAnArray kStrongestValuesInAnArray = new KStrongestValuesInAnArray();
    System.out.println(kStrongestValuesInAnArray.getStrongest(array, 2));
  }
}
