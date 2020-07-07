package LeetCode.Interview.Arrays;

public class JumpGame {

  /*
  * Given an array of non-negative integers, you are initially positioned at the first index of the array.
    Each element in the array represents your maximum jump length at that position.
    Determine if you are able to reach the last index.

    Example 1:
    Input: [2,3,1,1,4]
    Output: true
    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

    Example 2:
    Input: [3,2,1,0,4]
    Output: false
    Explanation: You will always arrive at index 3 no matter what. Its maximum
                 jump length is 0, which makes it impossible to reach the last index.
  */

  enum Index {
    GOOD, BAD, UNKNOWN
  }

  public boolean canJump(int[] nums) {
    Index[] memo = new Index[nums.length];
    for (int i = 0; i < memo.length; i++) {
      memo[i] = Index.UNKNOWN;
    }
    memo[memo.length - 1] = Index.GOOD;

    for (int i = nums.length - 2; i >= 0; i--) {
      int furthestJump = Math.min(i + nums[i], nums.length - 1);
      for (int j = i + 1; j <= furthestJump; j++) {
        if (memo[j] == Index.GOOD) {
          memo[i] = Index.GOOD;
          break;
        }
      }
    }

    return memo[0] == Index.GOOD;
  }
}

class TestJumpGame {
  public static void main(String[] args) {
    int[] nums = new int[]{2,3,1,1,4};
    JumpGame jumpGame = new JumpGame();
    System.out.println(jumpGame.canJump(nums));
  }
}
