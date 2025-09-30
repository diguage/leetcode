package com.diguage.algo.leetcode;

public class _0213_HouseRobberIi_20 {
  // tag::answer[]

  /**
   * 思路一：分别从前和后向另外一段抢劫，且最后剩一个不抢，然后从两者中取最大值。
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-30 21:41:02
   */
  public int rob(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }
    int[] head = new int[nums.length];
    int[] tail = new int[nums.length];
    head[0] = nums[0];
    head[1] = Math.max(nums[0], nums[1]);
    tail[nums.length - 1] = nums[nums.length - 1];
    tail[nums.length - 2] = Math.max(nums[nums.length - 2], nums[nums.length - 1]);
    for (int i = 2; i < nums.length; i++) {
      int ti = nums.length - i - 1;
      if (i < nums.length - 1) {
        head[i] = Math.max(head[i - 1], head[i - 2] + nums[i]);
      }
      if (ti > 0) {
        tail[ti] = Math.max(tail[ti + 1], nums[ti] + tail[ti + 2]);
      }
    }
    return Math.max(head[nums.length - 2], tail[1]);
  }

  // end::answer[]
  static void main() {
    new _0213_HouseRobberIi_20()
      .rob(new int[]{200, 3, 140, 20, 10});
//      .rob(new int[]{6, 3, 10, 8, 2, 10, 3, 5, 10, 5, 3});
//      .rob(new int[]{1, 2, 1, 1});
//      .rob(new int[]{1, 2, 3});
  }
}
