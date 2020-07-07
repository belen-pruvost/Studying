package LeetCode.Interview.PhoneExamples;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FlowerPlantingWithNoAdjacent {
  public int[] gardenNoAdj(int N, int[][] paths) {
    int[] result = new int[N];

    Map<Integer, Set<Integer>> map = new HashMap<>();

    for (int i = 0; i < N; i++) {
      map.put(i, new HashSet<>());
    }


    for (int[] path : paths) {
      int x = path[0] - 1;
      int y = path[1] - 1;
      map.get(x).add(y);
      map.get(y).add(x);
    }

    for (int i = 0; i < N; i++) {
      int[] colors = new int[5];
      for (int nei : map.get(i)) {
        colors[result[nei]] = 1;
      }

      for (int c = 4; c >= 1; c--) {
        if (colors[c] != 1)
          result[i] = c;
      }
    }

    return result;
  }
}

class Test {
  public static void main(String[] args) {
    FlowerPlantingWithNoAdjacent flowerPlantingWithNoAdjacent = new FlowerPlantingWithNoAdjacent();
    int[][] paths = new int[][]{{1,2},{2,3}, {3,1}};
    int[] res = flowerPlantingWithNoAdjacent.gardenNoAdj(3, paths);
    String lala = "";

  }
}
