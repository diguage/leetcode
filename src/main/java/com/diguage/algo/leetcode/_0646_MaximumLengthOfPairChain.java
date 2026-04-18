package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _0646_MaximumLengthOfPairChain {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-18 22:38:26
   */
  public int findLongestChain(int[][] pairs) {
    Arrays.sort(pairs, Comparator.comparingInt((int[] a) -> a[0])
      .thenComparingInt(a -> a[1]));
    int result = 1;
    int index = 0;
    for (int i = 1; i < pairs.length; i++) {
      int[] h = pairs[index];
      int[] t = pairs[i];
      if (h[1] < t[0]) {
        index = i;
        result++;
        // 减小结尾数值，提高增加长度的可能性
      } else if (h[0] <= t[0] && t[1] < h[1]) {
        index = i;
      }
    }
    return result;
  }

  // end::answer[]
  static void main() {
    new _0646_MaximumLengthOfPairChain()
      .findLongestChain(new int[][]{
        new int[]{-6, 9},
        new int[]{1, 6},
        new int[]{8, 10},
        new int[]{-1, 4},
        new int[]{-6, -2},
        new int[]{-9, 8},
        new int[]{-5, 3},
        new int[]{0, 3}});
  }
}
