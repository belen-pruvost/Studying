package LeetCode.Youtube;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {
  /*
  *You are playing the following Flip Game with your friend:
  * Given a string that contains only these two characters: + and -,
  * you and your friend take turns to flip two consecutive "++" into "--".
  * The game ends when a person can no longer make a move and therefore the other person will be the winner.

    Write a function to compute all possible states of the string after one valid move.

    Example:
    Input: s = "++++"
    Output:
    [
      "--++",
      "+--+",
      "++--"
    ]
    Note: If there is no valid move, return an empty list [].
  */

  public List<String> generatePossibleNextMoves(String s) {
    List<String> result = new ArrayList<>();
    for(int i=0; i<s.length()-2; i++) {
      if(s.charAt(i)!=s.charAt(i+1)) {
        continue;
      }
      String replace = s.charAt(i) == '-' ? "++" : "--";
      String current = s.substring(0, i) + replace + s.substring(i+2);
      result.add(current);
    }
    return result;
  }
}


class TestFlipGame {
  public static void main(String[] args) {
    FlipGame flipGame = new FlipGame();
    List<String> result = flipGame.generatePossibleNextMoves("++++");
    String j = "";
  }
}
