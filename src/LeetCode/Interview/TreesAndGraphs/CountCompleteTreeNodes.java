package LeetCode.Interview.TreesAndGraphs;

public class CountCompleteTreeNodes {
  /*
  * Given a complete binary tree, count the number of nodes.

    Note:

    Definition of a complete binary tree from Wikipedia:
    In a complete binary tree every level, except possibly the last, is completely filled,
    * and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

    Example:

    Input:
        1
       / \
      2   3
     / \  /
    4  5 6

    Output: 6
  */

  public int countNodesLinear(TreeNode root) {
    return root != null ? 1 + countNodesLinear(root.left) + countNodesLinear(root.right): 0;
  }

  private int computeDepth(TreeNode node) {
    int depth = 0;
    while(node.left != null) {
      depth++;
      node = node.left;
    }
    return depth;
  }

  public boolean exists(int index, int depth, TreeNode node) {
    int left = 0;
    int right = (int) Math.pow(2, depth) - 1;
    int pivot;
    for(int i = 0; i < depth; ++i) {
      pivot = (left + right) / 2;
      if (index <= pivot) {
        node = node.left;
        right = pivot;
      }
      else {
        node = node.right;
        left = pivot + 1;
      }
    }
    return node != null;
  }

  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int depth = computeDepth(root);
    if (depth == 0) return 1;
    int left = 1;
    int right = (int) Math.pow(2, depth) - 1;
    int pivot;
    while(left <= right) {
      pivot = (left + right) / 2;
      if(exists(pivot, depth, root)) {
        left = pivot + 1;
      } else {
        right = pivot - 1;
      }
    }

    return (int)Math.pow(2, depth) - 1 + left;
  }

}

class TestCountCompleteTreeNodes {
  public static void main(String[] args){
    TreeNode n1 = new TreeNode(1);
//    TreeNode n2 = new TreeNode(2);
//    TreeNode n3 = new TreeNode(3);
//    TreeNode n4 = new TreeNode(4);
//    TreeNode n5 = new TreeNode(5);
//    TreeNode n6 = new TreeNode(6);
//    n3.left = n6;
//    n2.left = n4;
//    n2.right = n5;
//    n1.left = n2;
//    n1.right = n3;
    CountCompleteTreeNodes countCompleteTreeNodes = new CountCompleteTreeNodes();

//    System.out.println(countCompleteTreeNodes.countNodesLinear(n1));
    System.out.println(countCompleteTreeNodes.countNodes(n1));

  }
}
