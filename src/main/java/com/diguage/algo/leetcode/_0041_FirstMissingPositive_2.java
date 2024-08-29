package com.diguage.algo.leetcode;

public class _0041_FirstMissingPositive_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-08-29 17:26:06
   */
  public int firstMissingPositive(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      // 把非正数变成正数
      if (nums[i] <= 0) {
        nums[i] = n + 1;
      }
    }
    for (int i = 0; i < n; i++) {
      // 把当前坐标元素指向的坐标上的数字变成负数
      int num = Math.abs(nums[i]);
      if (num <= n) {
        nums[num - 1] = -Math.abs(nums[num - 1]);
      }
    }
    for (int i = 0; i < n; i++) {
      // 出现正数的地方，就是遗漏的值
      if (0 < nums[i]) {
        return i + 1;
      }
    }
    return n + 1;
  }
  // end::answer[]
}
