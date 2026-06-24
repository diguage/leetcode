package com.diguage.algo.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _0791_CustomSortString {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-24 21:27:48
   */
  public String customSortString(String order, String s) {
    int[] chars = new int[26];
    for (int i = 0; i < 26; i++) {
      chars[i] = 27 + i;
    }
    char[] orderChars = order.toCharArray();
    for (int i = 0; i < orderChars.length; i++) {
      chars[orderChars[i] - 'a'] = i;
    }
    PriorityQueue<Character> pq = new PriorityQueue<>(
      Comparator.comparingInt(a -> chars[a - 'a']));
    for (char c : s.toCharArray()) {
      pq.offer(c);
    }
    StringBuilder sb = new StringBuilder(s.length());
    while (!pq.isEmpty()) {
      sb.append(pq.poll());
    }
    return sb.toString();
  }
  // end::answer[]
}
