package com.diguage.algo.leetcode;

public class _0041_FirstMissingPositive_6 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2019-07-26 08:49
   */
  public int firstMissingPositive(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      int num = nums[i];
      if (num <= 0 || num > n) {
        nums[i] = 0;
        continue;
      }
      while (nums[i] != i + 1) {
        if (nums[i] <= 0 || nums[i] > n) {
          nums[i] = 0;
          break;
        }
        int temp = nums[i];
        if (nums[temp - 1] == temp) {
          nums[i] = 0;
          continue;
        }
        nums[i] = nums[temp - 1];
        nums[temp - 1] = temp;
      }
    }
    for (int i = 0; i < n; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    return n + 1;
  }
  // end::answer[]
}
