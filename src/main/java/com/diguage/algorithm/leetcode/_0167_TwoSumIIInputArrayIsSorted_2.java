package com.diguage.algorithm.leetcode;

/**
 * = 167. Two Sum II - Input array is sorted
 *
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/[Two Sum II - Input array is sorted - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-07-03 20:02:38
 */
public class _0167_TwoSumIIInputArrayIsSorted_2 {
    /**
     */
    public int[] twoSum(int[] numbers, int target) {
      int low = 0, high = numbers.length - 1;
      while (low < high) {
        if (numbers[low] + numbers[high] == target) {
          return new int[]{low + 1, high + 1};
        } else if (target - numbers[low] < numbers[high]) {
          high--;
        } else if (numbers[low] < target - numbers[high]) {
          low++;
        }
      }
      return new int[]{-1, -1};
    }
}
