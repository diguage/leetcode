package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _0767_ReorganizeString {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-10 23:01:52
   */
  public String reorganizeString(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(
      Map.Entry.<Character, Integer>comparingByValue().reversed()
        .thenComparing(Map.Entry.comparingByKey()));
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      queue.offer(entry);
    }
    if (s.length() % 2 == 0
      ? (queue.peek().getValue() >= s.length() / 2 + 1)
      : (queue.peek().getValue() > s.length() / 2 + 1)) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    int index = -1;
    while (!queue.isEmpty()) {
      Map.Entry<Character, Integer> entry = queue.poll();
      if (sb.isEmpty()) {
        sb.repeat(entry.getKey().toString(), entry.getValue());
        index = sb.length() - 1;
      } else {
        for (int i = 0; i < entry.getValue() && index >= 0; i++) {
          sb.insert(index, entry.getKey());
          index--;
          if (index < 0) {
            index = sb.length() - 1;
          }
        }
      }
    }
    return sb.toString();
  }
  // end::answer[]

  static void main() {
    new _0767_ReorganizeString().reorganizeString("vvvlo");
  }
}
