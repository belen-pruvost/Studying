package TreesAndGraphs;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Node {
  public int data;
  public State state;
  Set<Node> adjacent;


  public Node() {
  }

  public Node(int data) {
    this.data = data;
    adjacent = new HashSet<>();
  }

  public Set<Node> getAdjacent() {
    return adjacent;
  }
}

enum State {
  Unvisited,
  Visited,
  Visiting
}


class Graph {
  Set<Node> nodes;

  public Graph() {
    this.nodes = new HashSet<>();
  }

  public Set<Node> getNodes() {
    return nodes;
  }
}
