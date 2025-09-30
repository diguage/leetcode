package com.diguage.algo.leetcode;

public class _0213_HouseRobberIi_21 {
  // tag::answer[]

  /**
   * 思路一：分别从第一个和第二个开始向后抢劫，从头抢的，
   * 放过最后一个；从第二个抢的，抢到最后，然后从两种中取最值。
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
    head[0] = nums[0];
    head[1] = Math.max(nums[0], nums[1]);
    int[] tail = new int[nums.length];
    tail[1] = nums[1];
    tail[2] = Math.max(nums[1], nums[2]);
    for (int i = 2; i < nums.length; i++) {
      if (i < nums.length - 1) {
        head[i] = Math.max(head[i - 1], head[i - 2] + nums[i]);
      }
      if (i < nums.length - 1) {
        tail[i + 1] = Math.max(tail[i], nums[i + 1] + tail[i - 1]);
      }
    }
    return Math.max(head[nums.length - 2], tail[nums.length - 1]);
  }

  // end::answer[]
  static void main() {
    new _0213_HouseRobberIi_21()
      .rob(new int[]{200, 3, 140, 20, 10});
//      .rob(new int[]{6, 3, 10, 8, 2, 10, 3, 5, 10, 5, 3});
//      .rob(new int[]{1, 2, 1, 1});
//      .rob(new int[]{1, 2, 3});
  }
}
