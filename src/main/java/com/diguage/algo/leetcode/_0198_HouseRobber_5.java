package com.diguage.algo.leetcode;

public class _0198_HouseRobber_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-06-25 11:30:36
   */
  public int rob(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    } else {
      // 注意：a, b 表示截止到当前下标，可以抢劫的最大金额。
      int a = nums[0], b = Math.max(nums[0], nums[1]);
      for (int i = 2; i < nums.length; i++) {
        int temp = Math.max(a + nums[i], b);
        a = b;
        b = temp;
      }
      return b;
    }
  }
  // end::answer[]
}
