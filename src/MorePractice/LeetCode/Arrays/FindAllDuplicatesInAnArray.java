package MorePractice.LeetCode.Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class FindAllDuplicatesInAnArray {
  int[] result;
  public List<Integer> findDuplicates(int[] nums) {
    int n = nums.length;
    result = new int[n];

    for(int i = 0; i < n; i++) {
      if(result[nums[i]-1] == Integer.MIN_VALUE) {
        result[nums[i]-1] = nums[i];
      } else {
        result[nums[i]-1] = Integer.MIN_VALUE;
      }
    }

    return Arrays.stream(result)
        .boxed()
        .filter(num -> num != Integer.MIN_VALUE && num != 0)
        .collect(Collectors.toList());
  }
}

class TesFindAllDuplicatesInAnArray {
  public static void main(String[] args) {
    int[] array = new int[]{4,3,2,7,8,2,3,1};
    FindAllDuplicatesInAnArray findAllDuplicatesInAnArray = new FindAllDuplicatesInAnArray();
    System.out.println(findAllDuplicatesInAnArray.findDuplicates(array));
  }
}
