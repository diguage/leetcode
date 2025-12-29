package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.Objects;

public class _0718_MaximumLengthOfRepeatedSubarray_31b {
  // tag::answer[]
  /**
   * 暴力破解（42/55）→ 备忘录
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-29 19:53:46
   */
  public int findLength(int[] nums1, int[] nums2) {
    int result = 0;
    int[][] memo = new int[nums1.length][nums2.length];
    for (int[] ints : memo) {
      Arrays.fill(ints, -1);
    }
    for (int i = nums1.length - 1; i >= 0; i--) {
      for (int j = nums2.length - 1; j >= 0; j--) {
        result = Math.max(result, dfs(nums1, i, nums2, j, memo));
      }
    }
    return result;
  }

  private int dfs(int[] a, int ai, int[] b, int bi, int[][] memo) {
    if (ai < 0 || bi < 0) {
      return 0;
    }
    if (memo[ai][bi] >= 0) {
      return memo[ai][bi];
    }
    int result = 0;
    if (Objects.equals(a[ai], b[bi])) {
      result = dfs(a, ai - 1, b, bi - 1, memo) + 1;
    }
    memo[ai][bi] = result;
    return result;
  }
  // end::answer[]
}
