package LeetCode.Youtube;

import java.util.HashMap;

public class MajorityElement {
  /*
  Given an array of size n, find the majority element.
  The majority element is the element that appears more than ⌊ n/2 ⌋ times.
  You may assume that the array is non-empty and the majority element always exist in the array.

  Example 1:
  Input: [3,2,3]
  Output: 3

  Example 2:
  Input: [2,2,1,1,1,2,2]
  Output: 2
  */

  public int majorityElement(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int majority = nums.length / 2;
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i]) && map.get(nums[i]) > majority) {
        return nums[i];
      }
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }
    return -1;
  }
}
