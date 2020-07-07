package MorePractice.LeetCode.Arrays;

public class MedianOfTwoSortedArrays {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int shortestArrayLength = nums1.length;
    int longestArrayLength = nums2.length;

    boolean isEven = (shortestArrayLength + longestArrayLength) % 2 == 0;

    if (shortestArrayLength > longestArrayLength) {
      return findMedianSortedArrays(nums2, nums1);
    }

    int low = 0;
    int high = shortestArrayLength;

    while (low <= high) {
      int partitionX = (low + high) / 2;
      int partitionY = (shortestArrayLength + longestArrayLength + 1) / 2 - partitionX;

      int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
      int minRightX = (partitionX == shortestArrayLength) ? Integer.MAX_VALUE : nums1[partitionX];

      int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
      int minRightY = (partitionY == longestArrayLength) ? Integer.MAX_VALUE : nums2[partitionY];

      if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
        if (isEven) {
          return (double)(Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) /2;
        } else {
          return Math.max(maxLeftX, maxLeftY);
        }
      } else if (maxLeftX > minRightY) {
        high = partitionX - 1;
      } else {
        low = partitionX + 1;
      }

    }

    return 0;
  }
}

class TestMedianOfTwoSortedArrays {
  public static void main(String[] args) {
    int[] nums1 = new int[]{1, 3, 8, 9, 15};
    int[] nums2 = new int[]{7, 11, 18, 19, 21, 25};
    MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
    System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));
  }
}
