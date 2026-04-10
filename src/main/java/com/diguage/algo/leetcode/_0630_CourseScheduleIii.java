package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _0630_CourseScheduleIii {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-10 21:12:49
   */
  public int scheduleCourse(int[][] courses) {
    // 按照 lastDay 从小到大排序
    Arrays.sort(courses, Comparator.comparingInt(o -> o[1]));
    // 最大堆
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    int day = 0; // 已消耗时间
    for (int[] c : courses) {
      int duration = c[0];
      int lastDay = c[1];
      if (day + duration <= lastDay) { // 没有超过 lastDay，直接学习
        day += duration;
        pq.offer(duration);
      } else if (!pq.isEmpty() && duration <= pq.peek()) { // 该课程的时间比之前的最长时间要短
        // 反悔，撤销之前 duration 最长的课程，改为学习该课程
        // 节省出来的时间，能在后面上完更多的课程
        day -= pq.poll() - duration;
        pq.offer(duration);
      }
    }
    return pq.size();
  }

  // end::answer[]
  static void main() {
    new _0630_CourseScheduleIii()
      .scheduleCourse(new int[][]{{1, 2}, {2, 3}});
  }
}

