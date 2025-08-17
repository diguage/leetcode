package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _0435_NonOverlappingIntervals {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-15 21:37:39
   */
  public int eraseOverlapIntervals(int[][] intervals) {
    // 这里是根据右边坐标点来排序
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
    int count = 0;
    int right = Integer.MIN_VALUE;
    for (int i = 0; i < intervals.length; i++) {
      if (right <= intervals[i][0]) {
        count++;
        right = intervals[i][1];
      }
    }
    return intervals.length - count;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0435_NonOverlappingIntervals()
      .eraseOverlapIntervals(new int[][]{{-52, 31}, {-73, -26}, {82, 97}, {-65, -11},
        {-62, -49}, {95, 99}, {58, 95}, {-31, 49}, {66, 98}, {-63, 2}, {30, 47}, {-40, -26}});
  }
}
