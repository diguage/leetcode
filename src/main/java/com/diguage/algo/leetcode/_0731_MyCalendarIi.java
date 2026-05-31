package com.diguage.algo.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class _0731_MyCalendarIi {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-31 21:44:41
   */
  class MyCalendarTwo {
    private TreeMap<Integer, Integer> counter;

    public MyCalendarTwo() {
      counter = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
      counter.put(startTime, counter.getOrDefault(startTime, 0) + 1);
      counter.put(endTime, counter.getOrDefault(endTime, 0) - 1);
      int book = 0;
      for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
        book += entry.getValue();
        if (book > 2) {
          counter.put(startTime, counter.get(startTime) - 1);
          counter.put(endTime, counter.get(endTime) + 1);
          return false;
        }
      }
      return true;
    }
  }
  // end::answer[]
}
