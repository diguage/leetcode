package com.diguage.algo.leetcode;

public class _0645_SetMismatch {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-17 23:25:45
   */
  public int[] findErrorNums(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
        int a = nums[i];
        nums[i] = nums[a - 1];
        nums[a - 1] = a;
      }
    }
    int a = -1, b = -1;
    for (int i = 0; i < n; i++) {
      if (nums[i] != i + 1) {
        a = nums[i];
        b = i == 0 ? 1 : nums[i - 1] + 1;
      }
    }
    return new int[]{a, b};
  }
  // end::answer[]

  //    int c = -1;
//    for (int i = 0; i < nums.length; i++) {
//      if (nums[i] == i + 1) {
//        continue;
//      }
//      int a = nums[i];
//      while (nums[i] != i + 1 && nums[i] != -1) {
//
//      }
//      if (nums[a - 1] == a) {
//        c = a;
//        nums[i] = -1;
//      } else {
//        nums[i] = nums[a - 1];
//        nums[a - 1] = a;
//      }
//    }
//    int m = -1;
//    for (int i = 0; i < nums.length; i++) {
//      if (nums[i] == i + 1) {
//        continue;
//      }
//      m = i + 1;
//      break;
//    }
//    return new int[]{c, m};
}
