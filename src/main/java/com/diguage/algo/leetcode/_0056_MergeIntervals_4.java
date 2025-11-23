package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _0056_MergeIntervals_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-23 19:43:52
   */
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    int mergedIndex = 0, index = 1;
    while (index < intervals.length) {
      int[] merged = intervals[mergedIndex];
      int[] interval = intervals[index++];
      if (interval[0] <= merged[1]) {
        merged[1] = Math.max(merged[1], interval[1]);
      } else {
        intervals[++mergedIndex] = interval;
      }
    }
    return Arrays.copyOf(intervals, mergedIndex + 1);
  }
  // end::answer[]
}
