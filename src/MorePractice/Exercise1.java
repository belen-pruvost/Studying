package MorePractice;

public class Exercise1 {
  public int solution(int[] A) {
    // write your code in Java SE 8

    int n = A.length;
    int leftMax = Integer.MIN_VALUE;
    int rightMax = Integer.MIN_VALUE;
    int result = 0;

    int [] leftToRight = new int [n];
    int [] rightToLeft = new int [n];

    for (int i = 0; i < n; i++){
      leftMax = Math.max(A[i], leftMax);
      leftToRight[i] = leftMax;
    }

    for (int i = n - 1; i > 0; i--){
      rightMax = Math.max(A[i], rightMax);
      rightToLeft[i] = rightMax;
    }

    for (int k = 0; k < n - 1; k++){
      result = Math.max(result,
          Math.abs(leftToRight[k] - rightToLeft[k + 1]));
    }

    return result;
  }
}

class TesCourseExercise1 {
  public static void main(String[] args) {
    Exercise1 exercise1 = new Exercise1();
//    int[] array = new int[] {4, 3, 2, 5, 1 ,1};
    int[] array = new int[] {1, 3, -3};
    exercise1.solution(array);
  }
}