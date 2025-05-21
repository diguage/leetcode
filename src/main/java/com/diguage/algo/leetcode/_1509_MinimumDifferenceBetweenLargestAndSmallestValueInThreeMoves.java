package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _1509_MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-21 22:54:47
   */
  public int minDifference(int[] nums) {
    int length = nums.length;
    if (length <= 4) {
      return 0;
    }
    Arrays.sort(nums);
    int diff = nums[length - 1] - nums[0];
    int max = 0;
    // max = Math.max(max, (nums[3] - nums[0]) + (nums[length - 1] - nums[length - 1]));
    // max = Math.max(max, (nums[2] - nums[0]) + (nums[length - 1] - nums[length - 2]));
    // max = Math.max(max, (nums[1] - nums[0]) + (nums[length - 1] - nums[length - 3]));
    // max = Math.max(max, (nums[0] - nums[0]) + (nums[length - 1] - nums[length - 4]));
    for (int i = 3; i >= 0; i--) {
      max = Math.max(max, (nums[i] - nums[0]) + (nums[length - 1] - nums[length - (4 - i)]));
    }
    return diff - max;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _1509_MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves()
      .minDifference(new int[]{1, 5, 0, 10, 14});
  }

}
