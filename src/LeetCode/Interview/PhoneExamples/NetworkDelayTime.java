package LeetCode.Interview.PhoneExamples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkDelayTime {
  Map<Integer, Integer> dist;

  public int networkDelayTime(int[][] times, int N, int K) {
    Map<Integer, List<int[]>> graph = new HashMap<>();
    for (int[] edge : times) {
      if (!graph.containsKey(edge[0])) {
        graph.put(edge[0], new ArrayList<int[]>());
      }
      graph.get(edge[0]).add(new int[]{edge[2], edge[1]});
    }

    dist = new HashMap<>();
    for (int node = 1; node <= N; node++) {
      dist.put(node, Integer.MAX_VALUE);
    }

    dfs(graph, K, 0);
    int ans = 0;
    for (int cand : dist.values()) {
      if (cand == Integer.MAX_VALUE) {
        return -1;
      }
      ans = Math.max(ans, cand);
    }

    return ans;
  }

  private void dfs(Map<Integer, List<int[]>> graph, int node, int elapsed) {
    if (elapsed >= dist.get(node)) {
      return;
    }
    dist.put(node, elapsed);
    if (graph.containsKey(node)) {
      for (int[] info : graph.get(node)) {
        dfs(graph, info[1], elapsed + info[0]);
      }
    }
  }
}
