package LeetCode.Youtube;

import java.util.Arrays;

public class CoinChange {
  /*
  * You are given coins of different denominations and a total amount of money amount.
  * Write a function to compute the fewest number of coins that you need to make up that amount.
  * If that amount of money cannot be made up by any combination of the coins, return -1.

  Example 1:
  Input: coins = [1, 2, 5], amount = 11
  Output: 3
  Explanation: 11 = 5 + 5 + 1


  Example 2:
  Input: coins = [2], amount = 3
  Output: -1
  Note:
  You may assume that you have an infinite number of each kind of coin.
  * */
  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for(int i=0; i <= amount; i++) {
      for(int j = 0; j < coins.length; j++) {
        if(coins[j] <= i) {
          dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
        }
      }
    }

    return dp[amount] > amount ? -1 : dp[amount];
  }
}

class TestCoinChange {
  public static void main(String[] args) {
    CoinChange coinChange = new CoinChange();
    int[] coins = new int[]{1,2,5};
    int amount = 11;
    System.out.println(coinChange.coinChange(coins, amount));
  }
}
