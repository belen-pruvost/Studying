package Articles;

import java.util.HashMap;

public class KnightDialerRecursive {

  int[][] moves = new int[][]{
      {4,6},{6,8},{7,9},{4,8},{3,9,0},
      {},{1,7,0},{2,6},{1,3},{2,4}};

  HashMap<Integer, HashMap<Integer, Integer>> cache = new HashMap<>();

  public int countSequences(int starting, int numHops) {
    if(cache.containsKey(starting) && cache.get(starting).containsKey(numHops)) {
      return cache.get(starting).get(numHops);
    }

    if(numHops == 0) {
      return 1;
    }

    int numSequences = 0;
    for (int i : moves[starting]) {
      numSequences += countSequences(i, numHops - 1);
    }

    HashMap<Integer, Integer> val = new HashMap<>();
    val.put(numHops, numSequences);

    cache.put(starting, val);

    return numSequences;
  }
}
