package Articles;

import java.util.Arrays;

public class KnightDialerDynamicProgramming {

  int[][] moves = new int[][]{
      {4,6},{6,8},{7,9},{4,8},{3,9,0},
      {},{1,7,0},{2,6},{1,3},{2,4}};

  public int countSequences(int startPosition, int numHops) {
    int[] priorCase = new int[10];
    Arrays.fill(priorCase, 1);
    int[] currentCase = new int[10];
    int currentNumHops = 1;
    while (currentNumHops <= numHops) {
      Arrays.fill(currentCase, 0);
      currentNumHops += 1;
      for (int position = 0; position < 10; position++) {
        for (int neighbor : moves[position]) {
          currentCase[position] += priorCase[neighbor];
        }
      }
      priorCase = currentCase.clone();
    }
    return currentCase[startPosition];
  }
}
