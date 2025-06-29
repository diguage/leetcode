package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _0187_RepeatedDnaSequences {
  // tag::answer[]
  /**
   * 使用集合优化
   * <p>
   * 优化前：暴力法，通过 30/31 个测试用例。
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-29 23:01:27
   */
  public List<String> findRepeatedDnaSequences(String s) {
    Set<String> dict = new HashSet<>();
    Set<String> result = new HashSet<>();
    for (int i = 0; i <= s.length() - 10; i++) {
      String sub = s.substring(i, i + 10);
      if (dict.contains(sub)) {
        result.add(sub);
      } else {
        dict.add(sub);
      }
    }
    return new ArrayList<>(result);
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0187_RepeatedDnaSequences()
      .findRepeatedDnaSequences("AAAAAAAAAAA");
  }
}
