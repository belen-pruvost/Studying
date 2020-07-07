package LeetCode.Interview.Generic;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
  public int lengthOfLongestSubstring(String s) {
    int n = s.length();
    int ans = 0;
    Map<Character, Integer> map = new HashMap<>();
    for(int j = 0, i = 0; j < n; j++) {
      if(map.containsKey(s.charAt(j))) {
        i = Math.max(map.get(s.charAt(j)), i);
      }
      ans = Math.max(ans, j - i + 1);
      map.put(s.charAt(j), j + 1);
    }

    return ans;
  }
}

class TestLongestSubstringWithoutRepeatingCharacters {
  public static void main(String[] args) {
    LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
//    String s = "abcabcbb";
    String s = "pwwkew";
    System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s));
  }
}
