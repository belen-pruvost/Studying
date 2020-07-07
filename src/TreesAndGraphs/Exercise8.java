package TreesAndGraphs;


import com.sun.source.tree.Tree;

public class Exercise8 {
  class Result {
    public TreeNode node;
    public boolean isAncestor;
    public Result (TreeNode n, boolean isAnc) {
      node = n;
      isAncestor = isAnc;
    }
  }

  public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    Result r = commonAncestorHelper(root, p, q);
    if (r.isAncestor) {
     return r.node;
    }
    return null;
  }

  private Result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return new Result(null, false);
    }

    if (root == p && root == q) {
      return new Result(root, true);
    }

    Result rx = commonAncestorHelper(root.left, p, q);
    if (rx.isAncestor) {
      return rx;
    }

    Result ry = commonAncestorHelper(root.right, p, q);
    if (ry.isAncestor) {
      return ry;
    }

    if (rx.node != null && ry.node != null) {
      return new Result(root, true);
    }

    if (root == p || root == q) {
      boolean isAncestor = rx.isAncestor || ry.isAncestor;
      return new Result(root, isAncestor);
    }

    return new Result(rx.node != null ? rx.node : ry.node, false);
  }
}
