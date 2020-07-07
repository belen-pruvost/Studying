package MorePractice.LeetCode.Arrays;

public class MaximumSubarray {
  int maxSum = Integer.MIN_VALUE;
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return maxSum;
    }

    if(nums.length == 1) {
      return nums[0];
    }

    int maxSum = nums[0];

    for(int i = 1; i < nums.length; i++) {
      if(nums[i-1] > 0) {
        nums[i] += nums[i-1];
      }

      maxSum = Math.max(maxSum, nums[i]);
    }

    return maxSum;
  }
}

class TestMaximumSubarray {
  public static void main(String[] args) {
    int[] array = new int[]{-2,1,-3,4};
    MaximumSubarray maximumSubarray = new MaximumSubarray();
    maximumSubarray.maxSubArray(array);
  }
}
