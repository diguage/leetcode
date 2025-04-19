package com.diguage.algo.leetcode;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _0139_WordBreak_20 {
  // tag::answer[]
  /**
   * 纯回溯通过 34/47 的测试用例。在 35 个测试用例时超时。
   *
   * 加备忘录则可以通过。效率还挺高，时间和内存都超过了 80%+ 的用户
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-19 15:41:59
   */
  public boolean wordBreak(String s, List<String> wordDict) {
    Set<Integer> wordLengths = new HashSet<>();
    for (String string : wordDict) {
      wordLengths.add(string.length());
    }
    Set<String> set = new HashSet<>(wordDict);
    List<Integer> lengths = wordLengths.stream()
      .sorted(Comparator.reverseOrder()).toList();
    // 备忘录：记录剩余 i 个字符时，字符串是否可以拆分
    Boolean[] memo = new Boolean[s.length()];
    return backtrack(s, set, lengths, memo);
  }

  private boolean backtrack(String s, Set<String> set,
                            List<Integer> lengths, Boolean[] memo) {
    if (s == null || s.isEmpty() || set.contains(s)) {
      return true;
    }
    if (s.length() < lengths.getLast()) {
      return false;
    }
    for (Integer i : lengths) {
      if (s.length() < i) {
        continue;
      }
      String prefix = s.substring(0, i);
      if (!set.contains(prefix)) {
        continue;
      }
      String substring = s.substring(i);
      if (memo[substring.length() - 1] != null) {
        return memo[substring.length() - 1];
      }
      boolean track = backtrack(substring, set, lengths, memo);
      memo[substring.length() - 1] = track;
      if (track) {
        return true;
      }
    }
    return false;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0139_WordBreak_20().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
      List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));
  }
}
