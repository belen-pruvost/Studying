package LeetCode.Interview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class WordLadder {
  /*
  * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence
  * from beginWord to endWord, such that:
      - Only one letter can be changed at a time.
      - Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

    * Note:
    - Return 0 if there is no such transformation sequence.
    - All words have the same length.
    - All words contain only lowercase alphabetic characters.
    - You may assume no duplicates in the word list.
    - You may assume beginWord and endWord are non-empty and are not the same.

    Example 1:
    Input:
    beginWord = "hit",
    endWord = "cog",
    wordList = ["hot","dot","dog","lot","log","cog"]
    Output: 5
    Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    return its length 5.

    Example 2:
    Input:
    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot","dot","dog","lot","log"]
    Output: 0
    Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
  */

  class Pair<K, V> {
    K key;
    V value;
    K getKey() {
      return key;
    }
    V getValue() {
      return value;
    }

    public Pair(K key, V value) {
      this.key = key;
      this.value = value;
    }

  }
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    int l = beginWord.length();
    Map<String, List<String>> allComboDict = new HashMap<>();

    wordList.forEach(
        word -> {
          for(int i=0; i<l; i++) {
            String newWord = word.substring(0,i) + "*" + word.substring(i+1);
            List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
            transformations.add(word);
            allComboDict.put(newWord, transformations);
          }
        });

    Queue<Pair<String, Integer>> Q = new LinkedList<>();
    Q.add(new Pair(beginWord, 1));
    Map<String,Boolean> visited = new HashMap<>();
    visited.put(beginWord, true);
    while(!Q.isEmpty()) {
      Pair<String, Integer> node = Q.remove();
      String word = node.getKey();
      int level = node.getValue();

      for(int i=0; i<l; i++) {
        String newWord = word.substring(0,i) + "*" + word.substring(i+1);

        for(String adjacentWord: allComboDict.getOrDefault(newWord, new ArrayList<>())) {
          if(adjacentWord.equals(endWord)) {
            return level + 1;
          }

          if(!visited.containsKey(adjacentWord)) {
            visited.put(adjacentWord, true);
            Q.add(new Pair(adjacentWord, level+1));
          }
        }

      }
    }

    return 0;

  }
}


class TestWordLadder {
  public static void main(String[] args) {
    WordLadder wordLadder = new WordLadder();
    List<String> dictionary = new ArrayList<>();
    dictionary.add("hot");
    dictionary.add("dot");
    dictionary.add("dog");
    dictionary.add("lot");
    dictionary.add("log");
    dictionary.add("cog");
    System.out.println(wordLadder.ladderLength("hit", "cog", dictionary));
  }
}