package MorePractice.LeetCode.Arrays;

public class TrappingRainWater {
  public int trap(int[] height) {
    int leftMax = 0;
    int rightMax = 0;
    int left = 0;
    int right = height.length-1;
    int result=0;

    while(left+1 < right){
      leftMax = Math.max(leftMax, height[left]);
      rightMax = Math.max(rightMax, height[right]);
      int current = Math.min(leftMax, rightMax);
      if(leftMax < rightMax){
        current -= height[left+1];
        left++;
      }else{
        current -= height[right-1];
        right--;
      }
      if(current > 0) {
        result += current;
      }
    }
    return result;
  }
}

class TestTrappingRainWater {
  public static void main(String[] args) {
//    int[] height = new int[]{0,1,0,2,0,0,0,3,2,0,2,1};
    int[] height = new int[]{2,	1,	0,	1,	3};
    TrappingRainWater trappingRainWater = new TrappingRainWater();
    System.out.println(trappingRainWater.trap(height));
  }
}
