package LeetCode.Youtube;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
  /*
  Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

  For example:
  Given binary tree [3,9,20,null,null,15,7],
      3
     / \
    9  20
      /  \
     15   7
  return its level order traversal as:
  [
    [3],
    [9,20],
    [15,7]
  ]
  * */
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();

    if(root == null) {
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> currentLevel = new ArrayList<>();
      for(int i=0; i < size; i++) {
        TreeNode current = queue.remove();
        currentLevel.add(current.val);
        if (current.left != null) {
          queue.add(current.left);
        }
        if (current.right != null) {
          queue.add(current.right);
        }
      }
      result.add(currentLevel);
    }
    return result;
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

class TestBinaryTreeLevelOrderTraversal {
  public static void main (String[] args) {
    BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
    TreeNode first = new TreeNode(3);
    TreeNode left = new TreeNode(9);
    TreeNode right = new TreeNode(20);
    TreeNode rightleft = new TreeNode(15);
    TreeNode rightright = new TreeNode(7);

    right.left = rightleft;
    right.right = rightright;
    first.left = left;
    first.right = right;

    binaryTreeLevelOrderTraversal.levelOrder(first);

  }
}

