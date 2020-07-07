package LeetCode.Youtube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupedAnagrams {
  /*
    Given an array of strings, group anagrams together.
    Example:
    Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
    Output:
    [
      ["ate","eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]

    Note:
    - All inputs will be in lowercase.
    - The order of your output does not matter.
  */

  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    HashMap<String, List<String>> map = new HashMap<>();
    for(String s: strs) {
      char[] current = s.toCharArray();
      Arrays.sort(current);
      String sorted = new String(current);
      if(!map.containsKey(sorted)) {
        map.put(sorted, new ArrayList<>());
      }
      map.get(sorted).add(s);
    }

    result.addAll(map.values());

    return result;
  }
}
