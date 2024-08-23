package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0057_InsertInterval {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2019-10-23 12:27
   */
  public int[][] insert(int[][] intervals, int[] newInterval) {
    int left = newInterval[0];
    int right = newInterval[1];
    boolean flag = false;
    List<int[]> result = new ArrayList<>();
    for (int[] ints : intervals) {
      if (right < ints[0]) {
        // 在插入区间的右侧且无交集
        if (!flag) {
          // 注意：这里是 left, right，不能直接放 newInterval
          result.add(new int[]{left, right});
          flag = true;
        }
        result.add(ints);
      } else if (ints[1] < left) {
        // 在插入区间的左侧且无交集
        result.add(ints);
      } else {
        left = Math.min(left, ints[0]);
        right = Math.max(right, ints[1]);
      }
    }
    if (!flag) {
      result.add(new int[]{left, right});
    }
    return result.toArray(new int[result.size()][2]);
  }

  // end::answer[]
  public static void main(String[] args) {
    int[][] result = new _0057_InsertInterval().insert(
      new int[][]{new int[]{1, 2}, new int[]{3, 5},
        new int[]{6, 7}, new int[]{8, 10}, new int[]{12, 16}},
      new int[]{4, 8});
    System.out.println(Arrays.toString(result));
  }
}
