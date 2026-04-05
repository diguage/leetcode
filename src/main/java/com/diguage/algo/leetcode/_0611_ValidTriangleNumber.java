package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0611_ValidTriangleNumber {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-05 22:37:10
   */
  public int triangleNumber(int[] nums) {
    Arrays.sort(nums);
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      int a = nums[i];
      System.out.printf("i=%d, num=%d\n", i, a);
      for (int j = i + 1; j < nums.length; j++) {
        int b = nums[j];
        System.out.printf("j=%d, num=%d\n", j, b);
        for (int k = j + 1; k < nums.length; k++) {
          int c = nums[k];
          System.out.printf("k=%d, num=%d\n", k, c);
          if (a + b <= c) {
            break;
          }
          result++;
        }
      }
    }
    return result;
  }
  // end::answer[]
  static void main() {
    new _0611_ValidTriangleNumber().triangleNumber(new int[]{2, 2, 3, 4});
  }
}
