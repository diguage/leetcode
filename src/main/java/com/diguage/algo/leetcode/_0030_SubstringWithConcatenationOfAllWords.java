package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0030_SubstringWithConcatenationOfAllWords {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-23 14:35:27
   */
  public List<Integer> findSubstring(String s, String[] words) {
    Map<String, Integer> dict = new HashMap<>();
    for (String word : words) {
      dict.put(word, dict.getOrDefault(word, 0) + 1);
    }
    int wordLen = words[0].length();
    int wordNum = words.length;
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < wordLen; i++) {
      Map<String, Integer> map = new HashMap<>();
      int left = i, right = i, hit = 0;
      while (right + wordLen <= s.length()) {
        String word = s.substring(right, right + wordLen);
        right += wordLen;
        if (dict.containsKey(word)) {
          int num = map.getOrDefault(word, 0) + 1;
          map.put(word, num);
          hit++;
          // 出现情况三，遇到了符合的单词，但是次数超了
          if (num > dict.get(word)) {
            // 一直移除单词，直到次数符合
            while (map.get(word) > dict.get(word)) {
              String deleteWord = s.substring(left, left + wordLen);
              map.compute(deleteWord, (k, cnt) -> cnt - 1);
              left += wordLen;
              hit--;
            }
          }
        } else {
          // 出现情况二，遇到了不匹配的单词，直接将 left 移动到该单词的后边
          map.clear();
          hit = 0;
          left = right;
        }
        if (hit == wordNum) {
          result.add(left);
          // 出现情况一，子串完全匹配，我们将上一个子串的第一个单词从tmp中移除，窗口后移wordLen
          String firstWord = s.substring(left, left + wordLen);
          map.compute(firstWord, (k, cnt) -> cnt - 1);
          hit--;
          left += wordLen;
        }
      }
    }
    return result;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0030_SubstringWithConcatenationOfAllWords()
      .findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
  }
}
