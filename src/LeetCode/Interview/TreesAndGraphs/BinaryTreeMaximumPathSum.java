package LeetCode.Interview.TreesAndGraphs;

public class BinaryTreeMaximumPathSum {
  /*
   * Given a non-empty binary tree, find the maximum path sum.
   * For this problem, a path is defined as any sequence of nodes from some starting node to any node
   * in the tree along the parent-child connections.
   * The path must contain at least one node and does not need to go through the root.
   */

  int max = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {

    if (root != null) {
      int currentFull = root.val +
          ((root.left != null) ? root.left.val : 0) +
          ((root.right != null) ? root.right.val : 0);

      int currentLeft = currentFull -
          ((root.right != null) ? root.right.val : 0);

      int currentRight = currentFull -
          ((root.left != null) ? root.left.val : 0);

      this.max = Math.max(max, root.val);
      this.max = Math.max(max, currentFull);
      this.max = Math.max(max, currentLeft);
      this.max = Math.max(max, currentRight);
      maxPathSum(root.left);
      maxPathSum(root.right);
    }

    return this.max;
  }
}

class TestBinaryTreeMaximumPathSum {
  public static void main(String[] args) {
    BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
    TreeNode node = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(3);

    node.left = left;
    node.right = right;

    System.out.println(binaryTreeMaximumPathSum.maxPathSum(node));
  }

}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}
