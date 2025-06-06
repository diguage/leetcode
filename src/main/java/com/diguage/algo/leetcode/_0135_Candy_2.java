package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0135_Candy_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-20 15:48:40
   */
  public int candy(int[] ratings) {
    int length = ratings.length;
    int[] left = new int[length];
    Arrays.fill(left, 1);
    int[] right = new int[length];
    Arrays.fill(right, 1);
    for (int i = 1; i < length; i++) {
      if (ratings[i] > ratings[i - 1]) {
        left[i] = left[i - 1] + 1;
      }
      if (ratings[length - 1 - i] > ratings[length - i]) {
        right[length - 1 - i] = right[length - i] + 1;
      }
    }
    int result = 0;
    for (int i = 0; i < length; i++) {
      result += Math.max(left[i], right[i]);
    }
    return result;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0135_Candy_2().candy(new int[]{1, 0, 2});
  }
}
