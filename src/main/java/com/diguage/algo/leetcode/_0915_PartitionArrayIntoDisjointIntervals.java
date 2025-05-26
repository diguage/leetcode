package com.diguage.algo.leetcode;

public class _0915_PartitionArrayIntoDisjointIntervals {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-26 11:39:29
   */
  public int partitionDisjoint(int[] nums) {
    int length = nums.length;
    int[] ext = new int[length];
    ext[length - 1] = nums[length - 1];
    int min = nums[length - 1];
    for (int i = length - 2; i >= 0; i--) {
      min = Math.min(min, nums[i]);
      ext[i] = min;
    }
    int max = nums[0];
    for (int i = 0; i < length - 1; i++) {
      max = Math.max(max, nums[i]);
      if (max <= ext[i + 1]) {
        return i + 1;
      }
    }
    return length - 1;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0915_PartitionArrayIntoDisjointIntervals()
      .partitionDisjoint(new int[]{1, 1, 1, 0, 6, 12});
  }
}
