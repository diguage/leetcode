package com.diguage.algo.leetcode;

public class _0370_RangeAddition_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-07 17:47:44
   */
  public int[] getModifiedArray(int length, int[][] updates) {
    int[] array = new int[length];
    for (int[] update : updates) {
      int start = update[0];
      int end = update[1];
      int value = update[2];
      array[start] += value;
      if (end + 1 < length) {
        array[end + 1] -= value;
      }
    }
    for (int i = 1; i < length; i++) {
      array[i] += array[i - 1];
    }
    return array;
  }
  // end::answer[]
}
