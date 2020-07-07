package LeetCode.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import TreesAndGraphs.TreeNode;

/*
* Given the root of a binary tree, each node in the tree has a distinct value.
After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
Return the roots of the trees in the remaining forest.  You may return the result in any order.

Example 1:
Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]
*
* */
public class DeleteNodesAndReturnForest {
  HashSet<Integer> deleteSet = new HashSet<>();
  ArrayList<TreeNode> result = new ArrayList<>();

  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    for (int i = 0; i < to_delete.length; i++) {
      deleteSet.add(to_delete[i]);
    }
    deleteHelper(root, true);
    return result;
  }

  private TreeNode deleteHelper(TreeNode node, boolean isRoot) {
    if(node == null) {
      return null;
    }

    boolean isDeleted = deleteSet.contains(node.data);

    if(isRoot && !isDeleted) {
      result.add(node);
    }
    node.left = deleteHelper(node.left, isDeleted);
    node.right = deleteHelper(node.right, isDeleted);

    return isDeleted ? null : node;

  }
}
