package com.diguage.algo.leetcode;

public class _0167_TwoSumIIInputArrayIsSorted_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-03 20:02:38
   */
  public int[] twoSum(int[] numbers, int target) {
    int l = 0;
    int r = numbers.length - 1;
    while (l < r) {
      int sum = numbers[l] + numbers[r];
      if (sum == target) {
        return new int[]{l + 1, r + 1};
      } else if (sum < target) {
        l++;
      } else {
        r--;
      }
    }
    return new int[]{-1, -1};
  }
  // end::answer[]
}
