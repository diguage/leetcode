package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0238_ProductOfArrayExceptSelf_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-22 19:31:52
   */
  public int[] productExceptSelf(int[] nums) {
    int[] prefix = new int[nums.length];
    Arrays.fill(prefix, 1);
    int[] suffix = new int[nums.length];
    Arrays.fill(suffix, 1);
    for (int i = 0; i < nums.length - 1; i++) {
      prefix[i] = (i - 1 >= 0 ? prefix[i - 1] : 1) * nums[i];
    }
    for (int i = nums.length - 1; i > 0; i--) {
      suffix[i] = (i + 1 < nums.length ? suffix[i + 1] : 1) * nums[i];
    }
    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      result[i] = (i - 1 >= 0 ? prefix[i - 1] : 1)
        * (i + 1 < nums.length ? suffix[i + 1] : 1);
    }
    return result;
  }

  // end::answer[]
  static void main() {
    new _0238_ProductOfArrayExceptSelf_3().productExceptSelf(new int[]{1, 2, 3, 4, 5});
  }
}
