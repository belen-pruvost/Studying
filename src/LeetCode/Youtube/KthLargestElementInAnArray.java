package LeetCode.Youtube;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
  /*
  * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
    Example 1:

    Input: [3,2,1,5,6,4] and k = 2
    Output: 5
    *
    Example 2:
    Input: [3,2,3,1,2,4,5,5,6] and k = 4
    Output: 4
    *
    Note:
    You may assume k is always valid, 1 ≤ k ≤ array's length
  * */
  public int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length - k];
  }

  public int findKthLargestOptimal(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for(int i: nums) {
      minHeap.add(i);
      if(minHeap.size() > k) {
        minHeap.remove();
      }
    }
    return minHeap.isEmpty() ? 0 : minHeap.remove();
  }
}

class TestKthLargestElementInArray {
  public static void main(String[] args) {
    KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();
    int[] array = new int[]{5,6,4,3,2,1};
    int k = 2;
    System.out.println(kthLargestElementInAnArray.findKthLargestOptimal(array, k));
  }
}
