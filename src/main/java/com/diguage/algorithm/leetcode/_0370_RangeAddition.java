package com.diguage.algorithm.leetcode;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-07-05 14:39:13
 */
public class _0370_RangeAddition {
  public int[] getModifiedArray(int length, int[][] updates) {
    if (updates == null || updates.length == 0) {
      return new int[length];
    }
    int[] diff = new int[length];

    for (int[] update : updates) {
      int start = update[0];
      int end = update[1];
      int val = update[2];
      diff[start] += val;
      if (end + 1 < diff.length) {
        diff[end + 1] -= val;
      }
    }

    for (int i = 1; i < length; i++) {
      diff[i] += diff[i - 1];
    }
    return diff;
  }
}
