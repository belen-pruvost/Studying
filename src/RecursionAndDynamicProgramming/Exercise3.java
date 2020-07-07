package RecursionAndDynamicProgramming;

public class Exercise3 {
  /*
  *A magic index in an array A[1.. .n-1] is defined to be an index such that A[i] = i.
  * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
  * */

  static int magicBruteForce(int[] array) {
    for (int i = 0; i < array.length; i++) {
      if(array[i] == i) {
        return i;
      }
    }
    return -1;
  }

  static int magicBinarySearch(int[] array) {
    return magicBinarySearch(array, 0, array.length - 1);
  }

  static int magicBinarySearch(int[] array, int start, int end) {
    if(end < start) {
      return -1;
    }

    int mid = (start + end) / 2;
    if(array[mid] == mid) {
      return mid;
    }

    if (array[mid] < mid) {
      return magicBinarySearch(array, mid + 1, end);
    }

    return magicBinarySearch(array, start, mid - 1);
  }

  static int magicWithRepetition(int[] array) {
    return magicWithRepetition(array, 0, array.length - 1);
  }

  static int magicWithRepetition(int[] array, int start, int end) {
    if (end<start) {
      return  -1;
    }

    int midIndex = (start + end) / 2;
    int midValue = array[midIndex];
    if(midIndex == midValue) {
      return midIndex;
    }

    int leftIndex = Math.min(midIndex - 1, midValue);
    int left = magicWithRepetition(array, start, leftIndex);
    if (left >= 0) {
      return left;
    }

    int rightIndex = Math.max(midIndex+1, midValue);
    int right = magicWithRepetition(array, rightIndex, end);

    return right;
  }

  public static void main(String[] args) {
    int[] array = new int[] {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
    System.out.println(magicBruteForce(array));
    System.out.println(magicBinarySearch(array));

    int[] arrayWithRepetitions = new int[] {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
    System.out.println(magicWithRepetition(arrayWithRepetitions));
  }
}
