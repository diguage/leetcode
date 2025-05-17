package com.diguage.algo.leetcode;

public class _0045_JumpGameIi_20 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-17 21:14:27
   */
  public int jump(int[] nums) {
    int length = nums.length;
    int max = 0;
    int step = 0;
    int end = 0;
    for (int i = 0; i < length; i++) {
      max = Math.max(max, i + nums[i]);
      if (max >= length - 1) {
        return step + 1;
      }
      if (i == end) {
        end = max;
        step++;
      }
    }
    return step;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0045_JumpGameIi_20()
      .jump(new int[]{2, 3, 1, 1, 4});
  }
}
