package MorePractice.LeetCode.Arrays;

import java.util.Stack;

public class MaximalRectangle {
  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0) {
      return 0;
    }

    int maxarea = 0;
    int[] dp = new int[matrix[0].length];

    for(int i = 0; i < matrix.length; i++) {
      for(int j = 0; j < matrix[0].length; j++) {

        // update the state of this row's histogram using the last row's histogram
        // by keeping track of the number of consecutive ones

        dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
      }
      // update maxarea with the maximum area from this row's histogram
      maxarea = Math.max(maxarea, getMaximumAreaInHistogram(dp));
    }
    return maxarea;
  }

  // Get the maximum area in a histogram given its heights
  private int getMaximumAreaInHistogram(int[] heights) {
    Stack< Integer > stack = new Stack < > ();
    stack.push(-1);

    int maxArea = 0;

    for (int i = 0; i < heights.length; ++i) {
      while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
        maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
      }
      stack.push(i);
    }

    while (stack.peek() != -1) {
      maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
    }
    return maxArea;
  }
}

class TestMaximalRectangle {
  public static void main(String[] args) {
    char[][] matrix = new char[][]{
        {'1', '0', '1', '0', '0'},
        {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'},
        {'1', '0', '0', '1', '0'}};
    MaximalRectangle maximalRectangle = new MaximalRectangle();
    System.out.println(maximalRectangle.maximalRectangle(matrix));
  }
}
