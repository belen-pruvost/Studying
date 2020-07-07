package LeetCode.Youtube;

import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
  /*
  * Given a string, sort it in decreasing order based on the frequency of characters.

    Example 1:
    Input:
    "tree"
    Output:
    "eert"
    Explanation:
    'e' appears twice while 'r' and 't' both appear once.
    So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.


    Example 2:
    Input:
    "cccaaa"
    Output:
    "cccaaa"
    Explanation:
    Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
    Note that "cacaca" is incorrect, as the same characters must be together.


    Example 3:
    Input:
    "Aabb"
    Output:
    "bbAa"

    Explanation:
    "bbaA" is also a valid answer, but "Aabb" is incorrect.
    Note that 'A' and 'a' are treated as two different characters.
  */

  public String frequencySort(String s) {
    if(s == null ||s.length() == 0) {
      return s;
    }

    HashMap<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
    maxHeap.addAll(map.keySet());

    StringBuilder sb = new StringBuilder();
    while(!maxHeap.isEmpty()) {
      Character current = maxHeap.remove();
      for(int i=0; i < map.get(current); i++) {
        sb.append(current);
      }
    }

    return sb.toString();
  }
}
