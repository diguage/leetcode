package com.diguage.algo.leetcode;

public class _0031_NextPermutation_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-21 15:29:48
   */
  public void nextPermutation(int[] nums) {
    int i = nums.length - 2;
    // 选择第一对升序数字，是降序就向前走。
    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i--;
    }
    if (i >= 0) {
      // 如果找到了升序数字对，则从后向前寻找一个大于 nums[i] 的数字，然后交换
      int j = nums.length - 1;
      while (j >= 0 && nums[i] >= nums[j]) {
        j--;
      }
      swap(nums, i, j);
    }
    // 反转 i+1 的数字
    reverse(nums, i + 1);
  }

  private void reverse(int[] nums, int index) {
    int left = index, right = nums.length - 1;
    while (left < right) {
      swap(nums, left, right);
      left++;
      right--;
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0031_NextPermutation_2().nextPermutation(new int[]{1, 5, 4, 3, 2});
  }
}
