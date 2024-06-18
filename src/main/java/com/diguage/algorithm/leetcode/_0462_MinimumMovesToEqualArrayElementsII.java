package com.diguage.algorithm.leetcode;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-18 18:57:41
 */
public class _0462_MinimumMovesToEqualArrayElementsII {
  /**
   * 参考 https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/solutions/1501230/zui-shao-yi-dong-ci-shu-shi-shu-zu-yuan-xt3r2/[462. 最小操作次数使数组元素相等 II - 官方题解^]。
   */
  public int minMoves2(int[] nums) {
    int size = nums.length;
    int mid = quickSelect(nums, 0, size - 1, size / 2);
    int result = 0;
    for (int i = 0; i < size; i++) {
      result += Math.abs(nums[i] - mid);
    }
    return result;
  }

  private int quickSelect(int[] nums, int left, int right, int index) {
    if (left == right) {
      return nums[index];
    }
    int l = left - 1;
    int r = right + 1;
    int num = nums[left];
    while (l < r) {
      do {
        l++;
      } while (nums[l] < num);
      do {
        r--;
      } while (num < nums[r]);
      if (l < r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
      }
    }
    if (index <= r) {
      return quickSelect(nums, left, r, index);
    } else {
      return quickSelect(nums, r + 1, right, index);
    }
  }
}
