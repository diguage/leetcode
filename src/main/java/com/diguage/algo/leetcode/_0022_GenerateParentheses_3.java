package com.diguage.algo.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _0022_GenerateParentheses_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2019-10-22 12:40:12
   */
  public List<String> generateParenthesis(int n) {
    Set<String> set = new HashSet<>();
    set.add("()");
    for (; n > 1; n--) {
      Set<String> next = new HashSet<>();
      for (String sb : set) {
        for (int i = 0; i < sb.length(); i++) {
          StringBuilder nsb = new StringBuilder(sb);
          nsb.insert(i, "()");
          next.add(nsb.toString());
        }
      }
      set = next;
    }
    return set.stream().toList();
  }
  // end::answer[]

  static void main() {
    new _0022_GenerateParentheses_3().generateParenthesis(3);
  }
}
