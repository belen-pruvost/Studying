package LeetCode.Interview.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
  /*
  *
  * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
    Note:
    The solution set must not contain duplicate triplets.

    Example:

    Given array nums = [-1, 0, 1, 2, -1, -4],

    A solution set is:
    [
      [-1, 0, 1],
      [-1, -1, 2]
    ]
  */
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new LinkedList<>();
    for(int i = 0; i < nums.length - 2; i++) {
      if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
        int low = i+1;
        int high = nums.length - 1;
        int sum = 0 - nums[i];
        while(low < high) {
          if(nums[low] + nums[high] == sum) {
            result.add(Arrays.asList(nums[i], nums[low], nums[high]));
            while(low < high && nums[low] == nums[low+1]) {
              low++;
            }
            while(low < high && nums[high] == nums[high-1]) {
              high--;
            }
            low++;
            high--;
          } else if (nums[low] + nums[high] < sum) {
            low++;
          } else {
            high--;
          }
        }
      }
    }
    return result;
  }

  public List<List<Integer>> threeSum2(int[] nums) {
    Arrays.sort(nums);
    HashSet<List<Integer>> result = new HashSet<>();
    for(int i = 0; i < nums.length - 2; i++) {
      HashMap<Integer, List<Integer>> complements = new HashMap<>();
      for (int j = i + 1; j < nums.length; j++) {
        List<Integer> list = new ArrayList<>();
        int complement = 0 - nums[i] - nums[j];
        if (complements.containsKey(complement) && complements.get(complement).size() > 0) {
          list = complements.get(complement);
          result.add(Arrays.asList(nums[i], nums[j], nums[list.get(0)]));
          list.remove(0);
          if(list.size() == 0) {
            complements.remove(complement);
          } else {
            complements.put(complement, list);
          }
        }
        list.add(j);
        complements.put(nums[j], list);
      }

    }

    return new ArrayList<>(result);
  }
}

class TestThreeSum {
  public static void main(String[] args) {
    ThreeSum threeSum = new ThreeSum();
    int[] array = new int[]{-2,0,0,2,2};
    threeSum.threeSum2(array);
  }
}
