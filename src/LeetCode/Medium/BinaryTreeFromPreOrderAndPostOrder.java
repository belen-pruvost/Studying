package LeetCode.Medium;

import java.util.Arrays;

import TreesAndGraphs.TreeNode;

public class BinaryTreeFromPreOrderAndPostOrder {
  /*
  * Return any binary tree that matches the given preorder and postorder traversals.
  Values in the traversals pre and post are distinct positive integers.
  *
  Example 1:
  Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
  Output: [1,2,3,4,5,6,7]
  * */

  public TreeNode constructFromPrePost(int[] pre, int[] post) {
    int n = pre.length;
    if(n==0) {
      return null;
    }
    TreeNode root = new TreeNode(pre[0]);
    if (n==1) {
      return root;
    }

    int l = 0;

    for (int i =0; i < n; i ++) {
      if(post[i] == pre[1]) {
        l = i+1;
      }
    }

    root.left  = constructFromPrePost(Arrays.copyOfRange(pre, 1, l+1), Arrays.copyOfRange(post, 0, l));
    root.right = constructFromPrePost(Arrays.copyOfRange(pre, l+1, n),    Arrays.copyOfRange(post, l, n-1));

    return root;
  }

  int[] pre, post;
  public TreeNode constructFromPrePost2(int[] pre, int[] post) {
    this.pre = pre;
    this.post = post;
    return make(0, 0, pre.length);
  }

  public TreeNode make(int i0, int i1, int n) {
    if(n==0) {
      return null;
    }
    TreeNode root = new TreeNode(pre[i0]);
    if(n==1) {
      return root;
    }
    int l = 1;
    for(l = 1; l < n; l++) {
      if(post[i1 + l-1] == pre[i0 + l]) {
        break;
      }
    }

    root.left = make(i0+1, i1, l);
    root.right = make(i0+l+1, i1+l, n-1-l);
    return root;
  }
}
