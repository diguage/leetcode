package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _2800_ShortestStringThatContainsThreeStrings_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-22 21:40:20
   */
  public String minimumString(String a, String b, String c) {
    ArrayList<List<String>> cs = new ArrayList<>(6);
    backtrack(new String[]{a, b, c}, cs, new boolean[3], new ArrayList<>());
    String result = a + b + c;
    for (List<String> s : cs) {
      String ns = merge(merge(s.getFirst(), s.get(1)), s.getLast());
      if (ns.length() < result.length()) {
        result = ns;
      } else if (ns.length() == result.length()) {
        if (ns.compareTo(result) < 0) {
          result = ns;
        }
      }
    }
    return result;
  }

  private void backtrack(String[] s, List<List<String>> result, boolean[] used, List<String> path) {
    if (path.size() == s.length) {
      result.add(new ArrayList<>(path));
      return;
    }
    for (int i = 0; i < s.length; i++) {
      if (used[i]) {
        continue;
      }
      used[i] = true;
      path.addLast(s[i]);
      backtrack(s, result, used, path);
      path.removeLast();
      used[i] = false;
    }
  }

  private String merge(String a, String b) {
    if (a.contains(b)) {
      return a;
    }
    if (b.contains(a)) {
      return b;
    }
    int start = Math.min(a.length(), b.length());
    for (int i = start; i > 0; i--) {
      if (a.endsWith(b.substring(0, i))) {
        return a + b.substring(i);
      }
    }
    return a + b;
  }
  // end::answer[]

  static void main() {
    new _2800_ShortestStringThatContainsThreeStrings_2()
      .minimumString("a", "abc", "b");
//      .minimumString("cab", "a", "b");
//      .minimumString("abc", "bca", "aaa");
  }
}
