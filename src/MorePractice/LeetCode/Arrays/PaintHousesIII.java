package MorePractice.LeetCode.Arrays;

public class PaintHousesIII {
  public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
    int[][][] dp = new int[m][m + 1][n + 1];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j <= m; j++) {
        for (int k = 0; k <= n; k++) {
          dp[i][j][k] = -1;
        }
      }
    }
    int answer = dfs(0, target, 0, 0, houses, cost, dp);
    return answer == Integer.MAX_VALUE ? -1 : answer;
  }

  private int dfs(int currGroups, int maxGroups, int preColor, int index, int[] houses, int[][] cost, int[][][] dp) {
    //If we are over the target number of neighbourhoods
    if (currGroups > maxGroups) {
      return Integer.MAX_VALUE;
    }

    //If we have already processed all the houses
    if (index == houses.length) {
      return currGroups == maxGroups ? 0 : Integer.MAX_VALUE;
    }

    //If the previous ? has already been processed
    if (dp[index][currGroups][preColor] != -1) {
      return dp[index][currGroups][preColor];
    }

    int min = Integer.MAX_VALUE;

    //If the house needs to be painted
    if (houses[index] == 0) {

      //Analyze each color possibility
      for (int i = 1; i <= cost[0].length; i++) {
        int val = dfs(preColor == i ? currGroups : currGroups + 1, maxGroups, i, index + 1, houses, cost, dp);
        min = val == Integer.MAX_VALUE ? min : Math.min(min, val + cost[index][i-1]);
      }
    }
    // When the house is already painted
    else {
      int val = dfs(preColor == houses[index] ? currGroups : currGroups + 1, maxGroups, houses[index], index + 1, houses, cost, dp);
      min = val == Integer.MAX_VALUE ? min : Math.min(min, val);
    }

    dp[index][currGroups][preColor] = min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min;

    return dp[index][currGroups][preColor];
  }
}

class TestPaintHousesIII {
  public static void main(String[] args) {
    PaintHousesIII paintHousesIII = new PaintHousesIII();
    int m = 5;
    int n = 2;
    int target = 3;
    int[] houses = new int[]{0, 2, 1, 2, 0};
    int[][] costs = new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}};

    System.out.println(paintHousesIII.minCost(houses, costs, m, n, target));
  }
}
