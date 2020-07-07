package LeetCode.Interview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleII {
  /*
  * There are a total of n courses you have to take, labeled from 0 to n-1.
    Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
    *  which is expressed as a pair: [0,1]

    Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

    There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

    Example 1:
    Input: 2, [[1,0]]
    Output: [0,1]
    Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
                 course 0. So the correct course order is [0,1] .
    Example 2:
    Input: 4, [[1,0],[2,0],[3,1],[3,2]]
    Output: [0,1,2,3] or [0,2,1,3]
    Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
                 courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
                 So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
    Note:
    - The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
    - You may assume that there are no duplicate edges in the input prerequisites.
  */

  enum State {
    BLANK, PARTIAL, COMPLETED
  }

  boolean isPossible;
  State[] visited;
  Map<Integer, List<Integer>> adjList;
  List<Integer> topologicalOrder;

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    this.init(numCourses);
    for(int i=0; i<prerequisites.length; i++) {
      // b me habilita a hacer a [b -> a]
      int dest = prerequisites[i][0]; // a
      int src = prerequisites[i][1]; // b
      List<Integer> ls = this.adjList.getOrDefault(src, new ArrayList<>());
      ls.add(dest);
      this.adjList.put(src, ls);
    }

    for(int i=0; i < numCourses; i++) {
      if(visited[i] == State.BLANK) {
        this.dfs(i);
      }
    }

    int[] order;
    if(!this.isPossible) {
      order = new int[0];
      return order;
    }

    order = new int[numCourses];
    for(int i=0; i < numCourses; i++) {
      order[i] = this.topologicalOrder.get(numCourses - i - 1);
    }
    return order;
  }

  private void init(int numCourses) {
    this.isPossible = true;
    this.visited = new State[numCourses];
    this.adjList = new HashMap<>();
    this.topologicalOrder = new ArrayList<>();

    for(int i=0; i < numCourses; i++) {
      visited[i] = State.BLANK;
    }
  }

  private void dfs(int node) {
    //Avoid cycle
    if(!this.isPossible) {
      return;
    }


    //Start the recursion
    visited[node] = State.PARTIAL;
    for(Integer neighbor: this.adjList.getOrDefault(node, new ArrayList<>())) {
      if(visited[neighbor] == State.BLANK) {
        this.dfs(neighbor);
      } else if(visited[neighbor] == State.PARTIAL) {
        //there is a cycle
        this.isPossible = false;
      }
    }
    visited[node] = State.COMPLETED;
    this.topologicalOrder.add(node);
  }
}

class TestCourseScheduleII {
  public static void main(String[] args) {
    CourseScheduleII courseScheduleII = new CourseScheduleII();
    courseScheduleII.findOrder(2, new int[][]{{1,0}});
  }
}
