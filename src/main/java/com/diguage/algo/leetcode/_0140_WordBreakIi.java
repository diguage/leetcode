package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0140_WordBreakIi {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-19 20:59:56
   */
  public List<String> wordBreak(String s, List<String> wordDict) {
    List<String> result = new ArrayList<>(s.length());
    // 从 LinkedList 切换到 ArrayList，内存占用就大幅下降 43.77% → 91.82%
    List<String> path = new ArrayList<>(s.length());
    backtrack(s, wordDict, result, 0, path);
    return result;
  }

  private void backtrack(String s, List<String> dict,
                         List<String> result, int index, List<String> path) {
    if (s.length() < index) {
      return;
    }
    if (index == s.length()) {
      result.add(String.join(" ", path));
      return;
    }
    for (String word : dict) {
      int length = word.length();
      if (s.length() < index + length) {
        continue;
      }
      String substring = s.substring(index, index + length);
      // 使用 word.equals(substring)，可以避免重复
      if (word.equals(substring)) {
        path.add(word);
        backtrack(s, dict, result, index + length, path);
        path.removeLast();
      }
    }
  }
  // end::answer[]
}
