package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _0436_FindRightInterval {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-16 16:16:17
   */
  public int[] findRightInterval(int[][] intervals) {
    int length = intervals.length;
    Integer[] index = new Integer[length];
    for (int i = 0; i < length; i++) {
      index[i] = i;
    }
    Arrays.sort(index, Comparator.comparingInt((Integer a) -> intervals[a][0]));
    int[] result = new int[length];
    for (int i = 0; i < length; i++) {
      int target = intervals[i][1];
      int left = 0, right = length - 1;
      while (left < right) {
        int mid = left + (right - left) / 2;
        int start = intervals[index[mid]][0];
        if (start >= target) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }
      result[i] = target <= intervals[index[left]][0] ? index[left] : -1;
    }
    return result;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0436_FindRightInterval()
      .findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}});
  }
}
