package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0274_HIndex {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-14 22:20:18
   */
  public int hIndex(int[] citations) {
    Arrays.sort(citations);
    int result = 0;
    for (int i = citations.length - 1; i >= 0; i--) {
      if (citations[i] > result) {
        result++;
      } else {
        break;
      }
    }
    return result;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0274_HIndex().hIndex(new int[]{1, 3, 1});
  }
}
