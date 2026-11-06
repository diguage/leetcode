package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _0056_MergeIntervals_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-11-06 21:58:33
   */
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    List<int[]> result = new ArrayList<>();
    result.add(intervals[0]);
    for (int i = 1; i < intervals.length; i++) {
      int[] last = result.getLast();
      int[] ints = intervals[i];
      if (last[1] < ints[0]) {
        result.add(ints);
      } else {
        last[0] = Math.min(last[0], ints[0]);
        last[1] = Math.max(last[1], ints[1]);
      }
    }
    return result.toArray(new int[result.size()][]);
  }
  // end::answer[]
}
