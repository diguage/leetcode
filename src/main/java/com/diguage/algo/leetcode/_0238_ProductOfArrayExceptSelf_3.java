package com.diguage.algo.leetcode;

public class _0238_ProductOfArrayExceptSelf_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-22 19:31:52
   */
  public int[] productExceptSelf(int[] nums) {
    // 先使用 result 存储前缀乘积
    int[] result = new int[nums.length];
    result[0] = nums[0];
    for (int i = 1; i < nums.length - 1; i++) {
      result[i] = result[i - 1] * nums[i];
    }
    int suffix = 1; // 利用变量 suffix 存放后缀乘积
    for (int i = nums.length - 1; i > 0; i--) {
      result[i] = result[i - 1] * suffix;
      suffix *= nums[i];
    }
    result[0] = suffix;
    return result;
  }

  // end::answer[]
  static void main() {
    new _0238_ProductOfArrayExceptSelf_3().productExceptSelf(new int[]{1, 2, 3, 4, 5});
  }
}
