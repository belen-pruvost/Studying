package TreesAndGraphs;


import java.util.LinkedList;
import java.util.Queue;

public class Exercise1 {
  public boolean isThereARouteBetweenNodes(Graph graph, Node start, Node end) {
    if (start == end) {
      return true;
    }

    for(Node n : graph.getNodes()) {
      n.state = State.Unvisited;
    }

    Queue<Node> queue = new LinkedList<>();

    start.state = State.Visiting;
    queue.add(start);

    while(!queue.isEmpty()) {
      Node current = queue.remove();
      for(Node n : current.getAdjacent()) {
        if(n.state == State.Unvisited) {
          if(n == end) {
            return true;
          }
          n.state = State.Visiting;
          queue.add(n);
        }
      }
      current.state = State.Visited;
    }

    return false;
  }
}

class TestExercise {
  public static void main(String[] args) {

  }
}
