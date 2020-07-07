package MorePractice;

import java.util.*;

public class ReconstructItinerary {
  HashMap<String, List<String>> flightMap = new HashMap<>();
  HashMap<String, boolean[]> visited = new HashMap<>();
  int flights = 0;
  List<String> result = null;


  public List<String> findItinerary(List<List<String>> tickets) {
    buildMap(tickets);

    for (Map.Entry<String, List<String>> entry : this.flightMap.entrySet()) {
      Collections.sort(entry.getValue());
      this.visited.put(entry.getKey(), new boolean[entry.getValue().size()]);
    }

    this.flights = tickets.size();
    LinkedList<String> route = new LinkedList<>();
    route.add("JFK");

    this.backtracking("JFK", route);
    return this.result;
  }

  private void buildMap(List<List<String>> tickets) {
    for (List<String> ticket : tickets) {
      String origin = ticket.get(0);
      String destination = ticket.get(1);
      if (!this.flightMap.containsKey(origin)) {
        this.flightMap.put(origin, new ArrayList<>());
      }

      this.flightMap.get(origin).add(destination);
    }
  }

  protected boolean backtracking(String origin, LinkedList<String> route) {
    if (route.size() == this.flights + 1) {
      this.result = (List<String>) route.clone();
      return true;
    }

    if (!this.flightMap.containsKey(origin)) {
      return false;
    }

    int i = 0;
    boolean[] visited = this.visited.get(origin);

    for (String dest : this.flightMap.get(origin)) {
      if (!visited[i]) {
        visited[i] = true;
        route.add(dest);
        boolean isPossible = this.backtracking(dest, route);
        route.pollLast();
        visited[i] = false;

        if (isPossible) {
          return true;
        }
      }
      ++i;
    }

    return false;
  }
}

class TestReconstructItinerary {
  public static void main(String[] args) {
    ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
    List<String> ticket1 = Arrays.asList("JFK", "KUL");
    List<String> ticket2 = Arrays.asList("JFK", "NRT");
    List<String> ticket3 = Arrays.asList("NRT", "JFK");
    List<List<String>> tickets = new ArrayList<>();
    tickets.add(ticket1);
    tickets.add(ticket2);
    tickets.add(ticket3);

    reconstructItinerary.findItinerary(tickets);
  }
}
