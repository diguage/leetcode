package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _0056_MergeIntervals_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-03-05 17:14:39
   */
  public int[][] merge(int[][] intervals) {
    // 对待合并区间进行排序，首先按照起点排序，然后按终点排序
    // 排序后，可以保证起点有序；在起点相等时，终点有序。
    Arrays.sort(intervals, Comparator.comparingInt((int[] o) -> o[0])
      .thenComparingInt(o -> o[1]));
    int merged = 0, curr = 0;
    while (merged < intervals.length && curr < intervals.length) {
      if (intervals[curr][0] <= intervals[merged][1]) {
        // 如果当前区间起点小于等于合并后区间的终点，那么直接合并到已经合并的区间里
        intervals[merged][1] = Math.max(intervals[merged][1], intervals[curr][1]);
      } else {
        // 如果当前区间起点大于合并后区间的终点，那么直接开启新的合并区间
        merged++;
        intervals[merged] = intervals[curr];
      }
      // 每次合并，当前区间都要向前走一下。
      curr++;
    }
    // 从数组中复制出已经合并了的区间
    return Arrays.copyOf(intervals, merged + 1);
  }

  // end::answer[]
}
