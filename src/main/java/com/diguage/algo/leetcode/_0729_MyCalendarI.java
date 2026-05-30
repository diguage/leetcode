package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0729_MyCalendarI {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-30 22:36:52
   */
  class MyCalendar {
    private List<int[]> stack;

    public MyCalendar() {
      stack = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
      if (stack.isEmpty()) {
        stack.add(new int[]{startTime, endTime});
        return true;
      } else {
        if (endTime <= stack.getFirst()[0]) {
          stack.addFirst(new int[]{startTime, endTime});
          return true;
        } else if (stack.getLast()[1] <= startTime) {
          stack.addLast(new int[]{startTime, endTime});
          return true;
        } else {
          for (int i = 0; i < stack.size(); i++) {
            int[] curr = stack.get(i);
            if (curr[1] <= startTime
              && (i < stack.size() - 1 && endTime <= stack.get(i + 1)[0])) {
              stack.add(i + 1, new int[]{startTime, endTime});
              return true;
            }
          }
          return false;
        }
      }
    }
  }
  // end::answer[]

  static void main() {
//    MyCalendar calendar = new MyCalendar();
//    calendar.book(47, 50);
//    calendar.book(33, 41);
//    calendar.book(39, 45);
//    calendar.book(33, 42);
//    calendar.book(25, 32);
//    calendar.book(26, 35);
//    calendar.book(19, 25);
//    calendar.book(3, 8);
//    calendar.book(8, 13);
//    calendar.book(18, 27);
  }
}
