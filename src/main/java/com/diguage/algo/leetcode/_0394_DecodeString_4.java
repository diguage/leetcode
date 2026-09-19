package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _0394_DecodeString_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-19 22:22:58
   */
  public String decodeString(String s) {
    StringBuilder result = new StringBuilder();
    Deque<Integer> counter = new ArrayDeque<>();
    List<StringBuilder> temp = new ArrayList<>();
    int i = 0;
    while (i < s.length()) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        int next = s.indexOf('[', i);
        int num = Integer.parseInt(s.substring(i, next));
        counter.push(num);
        i = next;
        continue;
      } else if (c == '[') {
        temp.add(new StringBuilder());
      } else if (c == ']') {
        String st = temp.removeLast().toString();
        int cnt = counter.pop();
        if (temp.isEmpty()) {
          result.append(st.repeat(cnt));
        } else {
          temp.getLast().append(st.repeat(cnt));
        }
      } else {
        if (temp.isEmpty()) {
          result.append(c);
        } else {
          temp.getLast().append(c);
        }
      }
      i++;
    }
    return result.toString();
  }
  // end::answer[]
}
