package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2800_ShortestStringThatContainsThreeStrings {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-05 22:38:45
   */
  public String minimumString(String a, String b, String c) {
    List<List<String>> perms = new ArrayList<>(6);
    List<String> ss = Arrays.asList(a, b, c);
    backtrack(ss, perms, new ArrayList<>(), new boolean[ss.size()]);
    String result = null;
    for (List<String> perm : perms) {
      String temp = merge(merge(perm.get(0), perm.get(1)), perm.get(2));
      if (result == null || temp.length() < result.length()
        || temp.length() == result.length() && temp.compareTo(result) < 0) {
        result = temp;
      }
    }
    return result;
  }

  private String merge(String a, String b) {
    if (a.contains(b)) return a;
    if (b.contains(a)) return b;
    int min = Math.min(a.length(), b.length());
    for (int i = min; i > 0; i--) {
      // 如果 a 的结尾和 b 的开头子串相同，则该子串只需要出现一次
      if (a.substring(a.length() - i)
        .equals(b.substring(0, i))) {
        return a + b.substring(i);
      }
    }
    return a + b;
  }

  private void backtrack(List<String> ss, List<List<String>> set,
                         List<String> path, boolean[] used) {
    if (ss.size() == path.size()) {
      set.add(new ArrayList<>(path));
      return;
    }
    for (int i = 0; i < ss.size(); i++) {
      if (used[i]) {
        continue;
      }
      used[i] = true;
      path.add(ss.get(i));
      backtrack(ss, set, path, used);
      path.removeLast();
      used[i] = false;
    }
  }

  // end::answer[]
  public static void main(String[] args) {
    new _2800_ShortestStringThatContainsThreeStrings()
//      .merge("abc", "def");
      .minimumString("abc", "bca", "aaa");
  }
}
