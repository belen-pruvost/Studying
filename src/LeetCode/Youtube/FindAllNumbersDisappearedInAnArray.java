package LeetCode.Youtube;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
  /*
  *Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

  Find all the elements of [1, n] inclusive that do not appear in this array.

  Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

  Example:

  Input:
  [4,3,2,7,8,2,3,1]

  Output:
  [5,6]
  */

  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> missingNumbers = new ArrayList<>();
    if(nums == null || nums.length == 0) {
      return missingNumbers;
    }

    for(int i = 0; i < nums.length; i ++) {
      int newIndex = Math.abs(nums[i]) - 1;

      if(nums[newIndex] > 0) {
        nums[newIndex] *= -1;
      }
    }

    for(int i = 1; i <= nums.length; i++) {
      if(nums[i-1] > 0) {
        missingNumbers.add(i);
      }
    }

    return missingNumbers;
  }
}
