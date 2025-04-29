package com.diguage.algo.leetcode;

public class _0167_TwoSumIiInputArrayIsSorted_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-29 08:30
   */
  public int[] twoSum(int[] numbers, int target) {
    int left = 0, right = numbers.length - 1;
    while (left < right) {
      int sum = numbers[left] + numbers[right];
      if (sum == target) {
        break;
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }
    return new int[]{left + 1, right + 1};
  }
  // end::answer[]
}
