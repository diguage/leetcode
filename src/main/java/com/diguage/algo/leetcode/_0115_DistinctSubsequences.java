package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _0115_DistinctSubsequences {
  // tag::answer[]

  /**
   * 超时，通过 52 / 66 个测试用例。
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-02 21:46:40
   */
  public int numDistinct(String s, String t) {
    Set<List<Integer>> result = new HashSet<>();
    List<Integer> path = new ArrayList<>(t.length());
    backtrack(s, t, result, path, 0, 0);
    return result.size();
  }

  private void backtrack(String s, String t,
                         Set<List<Integer>> result, List<Integer> path,
                         int originIndex, int subIndex) {
    if (subIndex == t.length()) {
      result.add(new ArrayList<>(path));
      return;
    }
    for (int i = originIndex; i < s.length(); i++) {
      if (s.length() - i < t.length() - subIndex) {
        return;
      }
      if (s.charAt(i) != t.charAt(subIndex)) {
        continue;
      }
      path.add(i);
      backtrack(s, t, result, path, i + 1, subIndex + 1);
      path.removeLast();
    }
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0115_DistinctSubsequences()
      .numDistinct("rabbbit", "rabbit");
  }
}
