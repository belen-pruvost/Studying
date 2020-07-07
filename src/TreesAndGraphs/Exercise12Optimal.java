package TreesAndGraphs;


import java.util.HashMap;

public class Exercise12Optimal {
  public int countPathsWithSum(TreeNode root, int targetSum) {
    return countPathsWithSumFromNode(root, targetSum, 0, new HashMap<Integer, Integer>());
  }

  private int countPathsWithSumFromNode(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
    if (node == null) {
      return 0;
    }
    runningSum += node.data;
    int sum = runningSum - targetSum;
    int totalPaths = pathCount.getOrDefault(sum, 0);

    if (runningSum == targetSum) {
      totalPaths++;
    }

    //Increment pathCount, recurse, then decrement pathCount
    incrementHashTable(pathCount, runningSum, 1);
    totalPaths += countPathsWithSumFromNode(node.left, targetSum, runningSum, pathCount);
    totalPaths += countPathsWithSumFromNode(node.right, targetSum, runningSum, pathCount);
    incrementHashTable(pathCount, runningSum, -1);

    return totalPaths;
  }

  private void incrementHashTable(HashMap<Integer, Integer> hashtable, int key, int delta) {
    int newCount = hashtable.getOrDefault(key, 0) + delta;
    if (newCount == 0) { //Reduce usage of space when zero
      hashtable.remove(key);
    } else {
      hashtable.put(key, newCount);
    }
  }
}
