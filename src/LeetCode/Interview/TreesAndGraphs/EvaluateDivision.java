package LeetCode.Interview.TreesAndGraphs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {
  /*
  * Equations are given in the format A / B = k, where A and B are variables represented as strings,
  and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

    Example:
    Given a / b = 2.0, b / c = 3.0.
    queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
    return [6.0, 0.5, -1.0, 1.0, -1.0 ].

    The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries ,
    where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

    According to the example above:

    equations = [ ["a", "b"], ["b", "c"] ],
    values = [2.0, 3.0],
    queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].


    The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
  */

  class Node {
    String val;
    int state;
    Map<Node, Double> neighbors;

    public Node(String val) {
      this.val = val;
      this.state = 0;
      this.neighbors = new HashMap<>();
    }
  }

  class Graph {
    Map<String, Node> nodeMap;

    public Graph() {
      this.nodeMap = new HashMap<>();
    }

    public void buildGraph(List<List<String>> equations, double[] values) {
      for (int i=0; i < equations.size(); i++) {
        List<String> equation = equations.get(i);
        double value = values[i];
        String first = equation.get(0);
        String second = equation.get(1);

        if(!nodeMap.containsKey(first)) {
          nodeMap.put(first, new Node(first));
        }

        if(!nodeMap.containsKey(second)) {
          nodeMap.put(second, new Node(second));
        }

        nodeMap.get(first).neighbors.put(nodeMap.get(second), value);
        nodeMap.get(second).neighbors.put(nodeMap.get(first), 1.0 / value);
      }
    }

    public void resetStates() {
      for(String key: nodeMap.keySet()) {
        nodeMap.get(key).state = 0;
      }
    }
  }

  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    Graph graph = new Graph();
    graph.buildGraph(equations, values);
    double[] ans = new double[queries.size()];
    int i = 0;
    for(List<String> query : queries) {
      Node start = graph.nodeMap.get(query.get(0));
      Node end = graph.nodeMap.get(query.get(1));
      ans[i] = dfs(start, end, 1.0);
      i++;
      graph.resetStates();
    }

    return ans;
  }

  private double dfs(Node start, Node end, double product) {
    if(start == null || end == null) {
      return -1;
    }
    if(start.val.equals(end.val)) {
      return product;
    }

    start.state = 1;
    for(Node neighbor : start.neighbors.keySet()) {
      if(neighbor.state == 0) {
        double cand = dfs(neighbor, end, product * start.neighbors.get(neighbor));
        if(cand != -1) {
          return cand;
        }
      }
    }
    start.state = 2;
    return -1;
  }
}
