package com.diguage.algo.leetcode;

import java.util.*;

/**
 * = 127. Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/[Word Ladder - LeetCode]
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * . Only one letter can be changed at a time.
 * . Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 *
 * *Note:*
 *
 * * Return 0 if there is no such transformation sequence.
 * * All words have the same length.
 * * All words contain only lowercase alphabetic characters.
 * * You may assume no duplicates in the word list.
 * * You may assume beginWord and endWord are non-empty and are not the same.
 *
 * .Example 2:
 * [source]
 * ----
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-30 21:46:35
 */
public class _0127_WordLadder_2 {
  // tag::answer[]
  /**
   * 自己解答
   */
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> dic = new HashSet<>(wordList);
    Set<String> seen = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    int step = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String word = queue.poll();
        if (word.equals(endWord)) {
          return step + 1;
        }
        if (seen.contains(word)) {
          continue;
        } else {
          seen.add(word);
        }
        for (int j = 0; j < word.length(); j++) {
          List<String> words = create(word, j, dic, seen);
          queue.addAll(words);
        }
      }
      step++;
    }
    return 0;
  }

  public List<String> create(String word, int index, Set<String> dic, Set<String> seen) {
    List<String> result = new ArrayList<>();
    char[] array = word.toCharArray();
    char ec = array[index];
    for (int i = 0; i < 26; i++) {
      char c = (char) ('a' + i);
      if (c != ec) {
        array[index] = c;
        String w = new String(array);
        // 提前踢出掉无用单词
        if (dic.contains(w) && !seen.contains(w)) {
          result.add(w);
        }
      }
    }
    return result;
  }

  // end::answer[]


  public static void main(String[] args) {
    _0127_WordLadder_2 solution = new _0127_WordLadder_2();
    int r1 = solution.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
    System.out.println((r1 == 5) + " : " + r1);
  }
}
