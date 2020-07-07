package MorePractice;

import java.util.*;

public class NumberOfConnectedComponents {
  /*
  * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
  * write a function to find the number of connected components in an undirected graph.
  * */

  List<List<Integer>> adjacencyList = new ArrayList<>();

  public int countComponents(int n, int[][] edges) {
    if(n <= 1) {
      return n;
    }

    int count = 0;
    setAdjacencyList(n, edges);

    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      if(!visited[i]) {
        dfs(i, visited);
        count++;
      }
    }

    return count;
  }

  private void dfs(int i, boolean[] visited) {
    visited[i] = true;
    List<Integer> nodes = adjacencyList.get(i);
    for(int node : nodes) {
      if (!visited[node]) {
        dfs(node, visited);
      }
    }
  }

  private void setAdjacencyList(int n, int[][] edges) {
    for(int i = 0; i < n; i++) {
      adjacencyList.add(i, new ArrayList<>());
    }
    for(int[] edge : edges) {
      adjacencyList.get(edge[0]).add(edge[1]);
      adjacencyList.get(edge[1]).add(edge[0]);
    }
  }
}

class TesNumberOfConnectedComponents {
  public static void main(String[] args) {
    NumberOfConnectedComponents testNumberOfConnectedComponents = new NumberOfConnectedComponents();
    int[][] edges = new int[][] {{0,1}, {1,2}, {3,4}};

    testNumberOfConnectedComponents.countComponents(5, edges);
  }
}
