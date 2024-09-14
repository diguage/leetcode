package com.diguage.algo.leetcode;

public class _0238_ProductOfArrayExceptSelf_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-14 15:53:49
   */
  public int[] productExceptSelf(int[] nums) {
    // 可以把 pre 和 post 简化掉，直接在 result 上进行计算
    int[] pre = new int[nums.length];
    pre[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      pre[i] = nums[i] * pre[i - 1];
    }
    int[] post = new int[nums.length];
    post[nums.length - 1] = nums[nums.length - 1];
    for (int i = nums.length - 2; i >= 0; i--) {
      post[i] = nums[i] * post[i + 1];
    }
    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      int preNum = 1;
      if (0 < i) {
        preNum = pre[i - 1];
      }
      int postNum = 1;
      if (i < nums.length - 1) {
        postNum = post[i + 1];
      }
      result[i] = preNum * postNum;
    }
    return result;
  }
  // end::answer[]
}
