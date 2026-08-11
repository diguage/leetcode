package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0859_BuddyStrings {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-11 23:29:47
   */
  public boolean buddyStrings(String s, String goal) {
    if (s.length() != goal.length() || s.length() < 2) {
      return false;
    }
    int[] chars = new int[26];
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      chars[s.charAt(i) - 'a']++;
      if (s.charAt(i) != goal.charAt(i)) {
        list.add(i);
      }
      if (list.size() > 2) {
        return false;
      }
    }
    if (list.size() == 2) {
      return s.charAt(list.getFirst()) == goal.charAt(list.getLast())
        && s.charAt(list.getLast()) == goal.charAt(list.getFirst());
    } else if (list.isEmpty()) {
      for (int a : chars) {
        if (a >= 2) {
          return true;
        }
      }
    }
    return false;
  }
  // end::answer[]
}
