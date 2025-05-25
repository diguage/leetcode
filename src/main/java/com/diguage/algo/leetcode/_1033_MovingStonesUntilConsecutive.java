package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _1033_MovingStonesUntilConsecutive {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-25 22:01:29
   */
  public int[] numMovesStones(int a, int b, int c) {
    int[] nums = {a, b, c};
    Arrays.sort(nums);
    a = nums[0];
    b = nums[1];
    c = nums[2];
    int[] result = new int[2];
    if (c - a == 2) {
      result[0] = 0;
    } else if (b - a <= 2 || c - b <= 2) {
      result[0] = 1;
    } else {
      result[0] = 2;
    }
    result[1] = c - a - 2;
    return result;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _1033_MovingStonesUntilConsecutive().numMovesStones(3, 5, 1);
  }
}
