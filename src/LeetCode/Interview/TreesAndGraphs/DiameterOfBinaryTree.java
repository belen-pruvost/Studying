package LeetCode.Interview.TreesAndGraphs;

public class DiameterOfBinaryTree {
  /*
  * Given a binary tree, you need to compute the length of the diameter of the tree.
  * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
  * This path may or may not pass through the root.

    Example:
    Given a binary tree
              1
             / \
            2   3
           / \
          4   5
    Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

    Note: The length of path between two nodes is represented by the number of edges between them.
  */

  int ans = 1;
  public int diameterOfBinaryTree(TreeNode root) {
    depth(root);
    return ans - 1;
  }

  private int depth(TreeNode node) {
    if(node == null) {
      return 0;
    }

    int left = depth(node.left);
    int right = depth(node.right);
    ans = Math.max(ans, left + right + 1);
    return Math.max(left, right) + 1;
  }
}

class TestDiameterOfBinaryTree {
  public static void main(String[] args) {
    DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(5);

    n2.left = n4;
    n2.right = n5;
    n1.left = n2;
    n1.right = n3;
    System.out.println(diameterOfBinaryTree.diameterOfBinaryTree(n1));
  }
}
