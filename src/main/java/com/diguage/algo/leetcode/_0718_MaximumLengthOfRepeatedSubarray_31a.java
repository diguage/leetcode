package com.diguage.algo.leetcode;

public class _0718_MaximumLengthOfRepeatedSubarray_31a {
  // tag::answer[]
  /**
   * 暴力破解（42/55）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-29 19:53:46
   */
  public int findLength(int[] nums1, int[] nums2) {
    int result = 0;
    // 从这里也可以看出，深度优先遍历不一定都能从一个入口遍历完，可能还需要多个入口。
    for (int i = nums1.length - 1; i >= 0; i--) {
      for (int j = nums2.length - 1; j >= 0; j--) {
        result = Math.max(result, dfs(nums1, i, nums2, j));
      }
    }
    return result;
  }

  private int dfs(int[] a, int ai, int[] b, int bi) {
    if (ai < 0 || bi < 0) {
      return 0;
    }
    if (a[ai] == b[bi]) {
      return dfs(a, ai - 1, b, bi - 1) + 1;
    } else {
      return 0;
    }
  }
  // end::answer[]
}
