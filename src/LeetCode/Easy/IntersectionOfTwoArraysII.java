package LeetCode.Easy;

import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfTwoArraysII {
  /*
  * Given two arrays, write a function to compute their intersection.

    Example 1:
    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2,2]
  *
    Example 2:
    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [4,9]
  *
  */

  public int[] intersect(int[] nums1, int[] nums2) {
    if(nums1.length > nums2.length) {
      return intersect(nums2, nums1);
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    for(int n : nums1) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }

    int k = 0;
    for(int n : nums2) {
      int cnt = map.getOrDefault(n, 0);
      if(cnt > 0) {
        nums1[k++] = n;
        map.put(n, cnt-1);
      }
    }

    return Arrays.copyOfRange(nums1, 0, k);
  }

  public int[] intersectSorted(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int i = 0;
    int j = 0;
    int k = 0;

    while(i < nums1.length && j < nums2.length) {
      if(nums1[i] < nums2[j]) {
        ++i;
      } else if (nums1[i] > nums2[j]) {
        ++j;
      } else {
        nums1[k++]=nums1[i++];
        ++j;
      }
    }

    return Arrays.copyOfRange(nums1, 0, k);
  }
}

class TestIntersectionOfArrays{
  public static void main(String[] args) {
    int[] nums1 = new int[]{4, 5, 9};
    int[] nums2 = new int[]{9, 4, 9, 8, 4};

    IntersectionOfTwoArraysII intersectionOfTwoArraysII = new IntersectionOfTwoArraysII();
//    int[] result = intersectionOfTwoArraysII.intersect(nums1, nums2);
    int[] result2 = intersectionOfTwoArraysII.intersectSorted(nums1, nums2);

    /*
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

    If nums1 fits into the memory, we can use Approach 1 to collect counts for nums1 into a hash map. Then, we can sequentially load and process nums2.

    If neither of the arrays fit into the memory, we can apply some partial processing strategies:

    Split the numeric range into subranges that fits into the memory. Modify Approach 1 to collect counts only within a given subrange, and call the method multiple times (for each subrange).

    Use an external sort for both arrays. Modify Approach 2 to load and process arrays sequentially.
    * */
  }
}
