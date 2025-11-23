package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _0435_NonOverlappingIntervals_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-23 20:28:14
   */
  public int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
    int right = Integer.MIN_VALUE;
    int count = 0;
    for (int[] interval : intervals) {
      // 由于是按照右端点进行排序，而且要求的是需要删除的区间，所以，
      // right 只有在不重叠时需要更新，其余情况无需更新（这些区间要被删除掉）
      if (right <= interval[0]) {
        count++;
        right = interval[1];
      }
    }
    return intervals.length - count;
  }

  // end::answer[]
  static void main() {
    new _0435_NonOverlappingIntervals_2()
      .eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}});
  }
}
