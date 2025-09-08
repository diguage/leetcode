package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _0056_MergeIntervals_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-08 22:05:45
   */
  public int[][] merge(int[][] intervals) {
    // 按照左端点排序，是因为正序首先要找是最左端点，右端点会不断更新
    Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
    List<int[]> result = new ArrayList<>();
    result.add(intervals[0]);
    for (int i = 1; i < intervals.length; i++) {
      int[] last = result.getLast();
      int[] curr = intervals[i];
      if (last[1] < curr[0]) {
        result.add(curr);
      }else {
        // 根据第一个元素排序，所以，前面的，第一个元素肯定更小
        int[] item = {last[0], Math.max(last[1], curr[1])};
        result.set(result.size() - 1, item);
      }
    }
    return result.toArray(new int[result.size()][]);
  }
  // end::answer[]
}
