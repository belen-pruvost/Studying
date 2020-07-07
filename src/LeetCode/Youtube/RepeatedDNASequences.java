package LeetCode.Youtube;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepeatedDNASequences {
  /*
  * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
  * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

    Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

    Example:
    Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

    Output: ["AAAAACCCCC", "CCCCCAAAAA"]
  */

  public List<String> findRepeatedDnaSequences(String s) {
    List<String> result = new ArrayList<>();
    HashMap<String, Integer> occurrences = new HashMap<>();
    for(int i = 0; i <= s.length() - 10; i++) {
      String current = s.substring(i, i + 10);
      occurrences.put(current, occurrences.getOrDefault(current, 0)+1);
      if(occurrences.get(current) == 2) {
        result.add(current);
      }
    }
    return result;
  }
}
