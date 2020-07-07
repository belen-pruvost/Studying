package MorePractice.LeetCode.Trees;

import TreesAndGraphs.TreeNode;

public class PathSum {
  public boolean hasPathSum(TreeNode root, int sum) {
    if(root == null) {
      return false;
    }

    sum -= root.data;
    if(root.left == null && root.right == null) {
      return sum == 0;
    }

    return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
  }
}

class TestPathSum {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    TreeNode left = new TreeNode(4);
    TreeNode left2 = new TreeNode(11);
    TreeNode left3 = new TreeNode(7);
    TreeNode left2right = new TreeNode(2);
    TreeNode right = new TreeNode(8);
    TreeNode rightLeft = new TreeNode(13);
    TreeNode right2 = new TreeNode(4);
    TreeNode right3 = new TreeNode(1);

    right2.right = right3;
    right.right = right2;
    right.left = rightLeft;
    root.right = right;
    left2.left = left3;
    left2.right = left2right;
    left.left = left2;
    root.left = left;

    PathSum pathSum = new PathSum();
    System.out.println(pathSum.hasPathSum(root, 22));
  }
}
