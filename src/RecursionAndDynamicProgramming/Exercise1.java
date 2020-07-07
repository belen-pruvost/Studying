package RecursionAndDynamicProgramming;

import java.util.Arrays;

public class Exercise1 {
  //A child is running up a staircase with n steps and can hop either 1 step,
  // 2 steps, or 3 steps at a time.
  // Implement a method to count how many possible ways the child can run up the stairs.
  public static int countWayRecursive(int n, int[] memo) {
    if (n < 0) {
      return 0;
    }

    if (n == 0) {
      return 1;
    }

    if(memo[n] > -1) {
      return memo[n];
    }

    memo[n] = countWayRecursive(n-1, memo) + countWayRecursive(n-2, memo) + countWayRecursive(n-3, memo);

    return memo[n];
  }

  public static int countWayDP(int n) {
    int[] res = new int[n+1];
    res[0] = 1;
    res[1] = 1;
    res[2] = 2;

    for (int i =3; i <=n; i++) {
      res[i] = res[i-1] + res[i-2] + res[i-3];
    }

    return res[n];
  }

  public static void main(String[] args) {
    int n = 5;
    int[] memo = new int[n+1];
    Arrays.fill(memo, -1);
    System.out.println(Exercise1.countWayRecursive(n, memo));
    System.out.println(Exercise1.countWayDP(n));
  }
}
