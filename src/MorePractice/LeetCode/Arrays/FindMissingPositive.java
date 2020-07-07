package MorePractice.LeetCode.Arrays;

public class FindMissingPositive {
  public int firstMissingPositive(int[] nums) {
    int n = nums.length;
    boolean contains = false;

    //Check if 1 (which is the simplest answer, as it is the first positive integer) is present
    for (int i = 0; i < n; i++) {
      if (nums[i] == 1) {
        contains = true;
        break;
      }
    }

    //If it is not, return it - and that's the end
    if (!contains) {
      return 1;
    }


    // I know that numbers in the array smaller than 1 don't matter, so I can just turn them into 1
    // Also, numbers greater than my array size (n) are also redundant, so I can turn them into 1 as well
    for (int i = 0; i < n; i++) {
      if (nums[i] < 1 || nums[i] > n) {
        nums[i] = 1;
      }
    }

    // Walk through the array, get the absolute number at each position (a)
    // If at a given position, the absolute value is equal to my array length
    // use the first index in the array to denote that, turning the value in the first index to negative
    // Otherwise, change the value of the array at the index equivalent to a to be negative
    for (int i = 0; i < n; i++) {
      int a = Math.abs(nums[i]);

      if (a == n) {
        nums[0] = -Math.abs(nums[0]);
      } else {
        nums[a] = -Math.abs(nums[a]);
      }
    }

    //Walk through the array again, starting from index 1 (which is the first possible solution)
    //If at any point a number which is positive is found, then that means that the number equal to that index was not present in the original array
    //Therefore, that is the answer
    //Example: {3,	4,	-1,	-2,	1,	5,	16,	0,	2,	0} where 6 id the anwser
    for (int i = 1; i < n; i++) {
      if (nums[i] > 0) {
        return i;
      }
    }

    //If the answer hasn't been found yet, check if the value at the first index of the array is greater than 0
    //If that is the case, the answer is n
    //Example: {1, 4, 2} where 3 is the answer
    if (nums[0] > 0) {
      return n;
    }

    //Otherwise, the anser is n + 1
    //Example: {1, 3, 2} where 4 is the answer
    return n + 1;
  }
}

class TestFindMissingPositive {
  public static void main(String[] args) {
    int[] array = new int[]{1, 3, 2};
    FindMissingPositive findMissingPositive = new FindMissingPositive();
    System.out.println(findMissingPositive.firstMissingPositive(array));
  }
}
