package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _0452_MinimumNumberOfArrowsToBurstBalloons {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-19 21:20:51
   */
  public int findMinArrowShots(int[][] points) {
    Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
    List<int[]> inter = new ArrayList<>();
    inter.add(points[0]);
    for (int i = 1; i < points.length; i++) {
      int[] point = points[i];
      int[] last = inter.getLast();
      if (last[1] < point[0]) {
        // 新区间在已处理区间的后面，则直接新增
        inter.add(point);
      } else {
        // 有重叠，则进行区间合并
        last[0] = Math.max(last[0], point[0]);
        last[1] = Math.min(last[1], point[1]);
      }
    }
    return inter.size();
  }
  // end::answer[]
}
