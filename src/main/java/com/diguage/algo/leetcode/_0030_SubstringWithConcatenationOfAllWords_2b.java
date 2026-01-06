package com.diguage.algo.leetcode;

import java.util.*;

public class _0030_SubstringWithConcatenationOfAllWords_2b {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-06 20:50:00
   */
  public List<Integer> findSubstring(String s, String[] words) {
    int wordLength = words[0].length(); // 单词长度
    int windowLength = wordLength * words.length; // 所有单词的总长度，即窗口大小
    // 目标：窗口中的单词出现次数必须与 dict 完全一致
    Map<String, Integer> dict = new HashMap<>();
    for (String word : words) {
      dict.merge(word, 1, Integer::sum);
    }
    List<Integer> result = new ArrayList<>();
    // 枚举第一个窗口的左端点，做 wordLen 次起点不同的滑动窗口
    for (int start = 0; start < wordLength; start++) {
      Map<String, Integer> counter = new HashMap<>();
      int overload = 0; // 统计过多的单词个数（包括不在 words 中的单词）
      // 枚举窗口最后一个单词的右开端点
      for (int right = start + wordLength; right <= s.length(); right += wordLength) {
        // 1. inWord 进入窗口
        String inWord = s.substring(right - wordLength, right);
        // 下面 cnt[inWord]++ 后，inWord 的出现次数过多
        if (counter.getOrDefault(inWord, 0).equals(dict.getOrDefault(inWord, 0))) {
          overload++;
        }
        counter.merge(inWord, 1, Integer::sum); // cnt[inWord]++
        int left = right - windowLength; // 窗口第一个单词的左端点
        // 窗口大小不足 windowLen
        if (left < 0) {
          continue;
        }
        // 2. 更新答案
        // 如果没有超出 dict 的单词，那么也不会有少于 dict 的单词
        if (overload == 0) {
          result.add(left);
        }
        // 3. 窗口最左边的单词 outWord 离开窗口，为下一轮循环做准备
        String outWord = s.substring(left, left + wordLength);
        counter.merge(outWord, -1, Integer::sum); // cnt[outWord]--
        if (counter.get(outWord).equals(dict.getOrDefault(outWord, 0))) {
          overload--;
        }
      }
    }
    return result;
  }
  // end::answer[]
  static void main() {
    new _0030_SubstringWithConcatenationOfAllWords_2b()
      .findSubstring("a", new String[]{"a"});
  }
}
