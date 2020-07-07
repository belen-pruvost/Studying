package LeetCode.Youtube;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
  /*
  * Given a set of distinct integers, nums, return all possible subsets (the power set).

    Note: The solution set must not contain duplicate subsets.

    Example:

    Input: nums = [1,2,3]
    Output:
    [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]
  */

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    generateSubsets(0, nums, new ArrayList<Integer>(), subsets);
    return subsets;
  }

  private void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> subsets) {
    subsets.add(new ArrayList<>(current));
    for(int i=index; i < nums.length; i++) {
      current.add(nums[i]);
      generateSubsets(i + 1, nums, current, subsets);
      current.remove(current.size() - 1);
    }
  }
}
