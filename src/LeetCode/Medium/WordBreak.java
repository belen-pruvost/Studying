package LeetCode.Medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:
The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.

Example 1:
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
*/

public class WordBreak {

  //Brute force
  public boolean wordBreakNaive(String s, List<String> wordDict) {
    return wordBreakNaive(s, new HashSet(wordDict), 0);
  }

  private boolean wordBreakNaive(String s, Set<String> wordDict, int start) {
    if (start == s.length()) {
      return true;
    }

    for (int end = start+1; end < s.length(); end++) {
      if (wordDict.contains(s.substring(start, end)) && wordBreakNaive(s, wordDict, end)) {
        return true;
      }
    }
    return false;
  }

  //Recursion with Memoization

  public boolean wordBreakOptimal(String s, List<String> wordDict) {
    return wordBreakOptimal(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
  }

  private boolean wordBreakOptimal(String s, Set<String> wordDict, int start, Boolean[] memo) {
    if (start==s.length()) {
      return true;
    }

    if (memo[start] != null) {
      return memo[start];
    }

    for(int end=start+1; end <= s.length(); end++) {
      if (wordDict.contains(s.substring(start, end)) && wordBreakOptimal(s, wordDict, end, memo)) {
        return memo[start] = true;
      }
    }
    return memo[start] = false;
  }

  // BFS

  public boolean wordBreakWithBFS(String s, List<String> wordDict) {
    Set<String> wordDictSet=new HashSet(wordDict);
    Queue<Integer> queue = new LinkedList<>();
    int[] visited = new int[s.length()];
    queue.add(0);
    while (!queue.isEmpty()) {
      int start = queue.remove();
      if (visited[start] == 0) {
        for (int end = start + 1; end <= s.length(); end++) {
          if (wordDictSet.contains(s.substring(start, end))) {
            queue.add(end);
            if (end == s.length()) {
              return true;
            }
          }
        }
        visited[start] = 1;
      }
    }
    return false;
  }

  public boolean wordBreakDP(String s, List<String> wordDict) {
    Set<String> wordDictSet=new HashSet(wordDict);
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[s.length()];
  }

}
