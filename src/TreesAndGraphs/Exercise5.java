package TreesAndGraphs;

public class Exercise5 {
  public TreeNode inOrderSuccessor(TreeNode node) {
    if(node == null) {
      return null;
    }

    if(node.right != null) {
      return leftMostChild(node.right);
    }

    TreeNode previous = node;
    TreeNode x = previous.parent;

    while(x != null && x.left != previous) {
      previous = x;
      x = x.parent;
    }

    return x;
  }

  private TreeNode leftMostChild(TreeNode node) {
    if(node == null) {
      return null;
    }

    while(node.left != null) {
      node = node.left;
    }
    return node;
  }
}
