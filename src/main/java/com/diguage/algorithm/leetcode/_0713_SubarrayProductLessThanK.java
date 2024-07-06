package com.diguage.algorithm.leetcode;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-23 16:38:11
 */
public class _0713_SubarrayProductLessThanK {
  // tag::answer[]
  /**
   * 参考 https://leetcode.cn/problems/subarray-product-less-than-k/solutions/1463527/cheng-ji-xiao-yu-k-de-zi-shu-zu-by-leetc-92wl/[713. 乘积小于 K 的子数组 - 官方题解^]
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-06-23 16:38:11
   */
  public int numSubarrayProductLessThanK(int[] nums, int k) {
    int result = 0;
    int length = nums.length;
    int product = 1;
    int i = 0;
    for (int j = 0; j < length; j++) {
      product *= nums[j];
      while (i <= j && product >= k) {
        product /= nums[i];
        i++;
      }
      result += j - i + 1;
    }
    return result;
  }
  // end::answer[]
}
