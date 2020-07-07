package MorePractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleII {
  enum State {
    BLANK, PARTIAL, COMPLETED
  }

  boolean isPossible;
  State[] visited;
  Map<Integer, List<Integer>> adjMap;
  List<Integer> topologicalOrder;

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    if(numCourses <= 1){
      return new int[]{0};
    }

    init(numCourses);
    setAdjacencyMap(prerequisites);

    for(int i = 0; i < numCourses; i++) {
      if(visited[i] == State.BLANK) {
        this.dfs(i);
      }
    }

    if(!isPossible) {
      return new int[0];
    }

    int[] order = new int[numCourses];

    for(int i = 0; i < numCourses; i++) {
      order[i] = topologicalOrder.get(numCourses - i - 1);
    }
    return order;
  }

  private void init(int numCourses) {
    visited = new State[numCourses];
    for(int i = 0; i < numCourses; i++) {
      visited[i] = State.BLANK;
    }
    isPossible = true;
    topologicalOrder = new ArrayList<>();
    adjMap = new HashMap<>();
  }

  private void dfs(int course) {
    //Avoid cycle
    if(!this.isPossible) {
      return;
    }

    //Start the recursion
    visited[course] = State.PARTIAL;
    for(Integer neighbor: this.adjMap.getOrDefault(course, new ArrayList<>())) {
      if(visited[neighbor] == State.BLANK) {
        this.dfs(neighbor);
      } else if(visited[neighbor] == State.PARTIAL) {
        //there is a cycle
        this.isPossible = false;
      }
    }
    visited[course] = State.COMPLETED;
    this.topologicalOrder.add(course);
  }

  private void setAdjacencyMap(int[][] prerequisites) {
    for(int[] prerequisite: prerequisites) {
      if(!adjMap.containsKey(prerequisite[1])) {
        adjMap.put(prerequisite[1], new ArrayList<>());
      }
      adjMap.get(prerequisite[1]).add(prerequisite[0]);
    }
  }
}

class TesCourseScheduleII {
  public static void main(String[] args) {
    CourseScheduleII courseScheduleII = new CourseScheduleII();
    courseScheduleII.findOrder(4, new int[][]{{1,0}, {2,0}, {3,1}, {3,2}});
  }
}
