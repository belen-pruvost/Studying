package TreesAndGraphs;


public class Exercise2 {
  public TreeNode createMinimalBST(int[] array) {
     return createMinimalBST(array, 0, array.length - 1);
  }

  private TreeNode createMinimalBST(int[] array, int left, int right) {
    if(right < left) {
      return null;
    }

    int mid = (left + right) / 2;
    TreeNode root = new TreeNode(array[mid]);
    root.left = createMinimalBST(array, left, mid - 1);
    root.right = createMinimalBST(array, mid + 1, right);
    return root;
  }
}

class TestExercise2 {
  public static void main(String[] args) {
    Exercise2 exercise2 = new Exercise2();
    int[] array = new int[] {1,2,3,4,5};
    TreeNode result = exercise2.createMinimalBST(array);
    String s = "";
  }
}
