package com.diguage.algo.leetcode;

public class _0795_NumberOfSubarraysWithBoundedMaximum {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-26 22:46:32
   */
  public int numSubarrayBoundedMax(int[] nums, int left, int right) {
    int n = nums.length, result = 0, a = -1, b = -1;
    for (int i = 0; i < n; i++) {
      if (nums[i] > right) {
        a = i;
      }
      if (nums[i] >= left) {
        b = i;
      }
      result += b - a;
    }
    return result;
  }

  // end::answer[]
  static void main() {
    new _0795_NumberOfSubarraysWithBoundedMaximum()
      .numSubarrayBoundedMax(new int[]{2, 9, 2, 5, 6}, 2, 8);
  }
}
