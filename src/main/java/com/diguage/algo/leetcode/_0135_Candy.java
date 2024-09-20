package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0135_Candy {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-20 15:48:40
   */
  public int candy(int[] ratings) {
    int[] left = new int[ratings.length];
    int[] right = new int[ratings.length];
    Arrays.fill(left, 1);
    Arrays.fill(right, 1);
    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i - 1] < ratings[i]) {
        left[i] = left[i - 1] + 1;
      }
    }
    for (int i = ratings.length - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1]) {
        right[i] = right[i + 1] + 1;
      }
    }
    int result = 0;
    for (int i = 0; i < ratings.length; i++) {
      result += Math.max(left[i], right[i]);
    }
    return result;
  }
  // end::answer[]
}
