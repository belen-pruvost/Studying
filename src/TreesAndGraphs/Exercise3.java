package TreesAndGraphs;

import java.util.*;


public class Exercise3 {
  List<LinkedList<TreeNode>> result = new ArrayList<>();

  public List<LinkedList<TreeNode>> createLevelLinkedListBFS(TreeNode root) {
    LinkedList<TreeNode> current = new LinkedList<>();

    if (root != null) {
      current.add(root);
    }

    while (current.size() > 0) {
      result.add(current);
      LinkedList<TreeNode> parents = current;
      current = new LinkedList<>();
      for (TreeNode parent : parents) {
        if (parent.left != null) {
          current.add(parent.left);
        }

        if (parent.right != null) {
          current.add(parent.right);
        }
      }
    }

    return result;
  }

  public List<LinkedList<TreeNode>> createLevelLinkedListDFS(TreeNode root) {
    dfs(root, 0, new LinkedList<>());
    return result;
  }

  private void dfs(TreeNode node, int level, LinkedList<TreeNode> current) {
    if(node == null) {
      return;
    }
    if(result.size() == level) {
      current = new LinkedList<>();
      result.add(current);
    } else {
      current = result.get(level);
    }

    current.add(node);
    dfs(node.left, level + 1, current);
    dfs(node.right, level + 1, current);
  }
}

class TestExercise3 {
  public static void main(String[] args) {
    Exercise2 exercise2 = new Exercise2();
    Exercise3 exercise3 = new Exercise3();
    int[] array = new int[]{1, 2, 3, 4, 5};
    TreeNode node = exercise2.createMinimalBST(array);
    List<LinkedList<TreeNode>> list = exercise3.createLevelLinkedListDFS(node);
    String s = "";
  }
}
