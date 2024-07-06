package com.diguage.algorithm.leetcode;

public class _0912_SortAnArray {
  // tag::answer[]
  /**
   * 归并排序
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-06 17:47:27
   */
  public int[] sortArray(int[] nums) {
    mergeSort(nums, 0, nums.length - 1);
    return nums;
  }

  private void mergeSort(int[] nums, int left, int right) {
    if (right == left) {
      return;
    }
    int mid = left + (right - left) / 2;
    mergeSort(nums, left, mid);
    mergeSort(nums, mid + 1, right);
    merge(nums, left, mid, right);
  }

  private void merge(int[] nums, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int l = left, r = mid + 1;
    int i = 0;
    while (l <= mid && r <= right) {
      if (nums[l] <= nums[r]) {
        temp[i++] = nums[l++];
      } else {
        temp[i++] = nums[r++];
      }
    }
    while (l <= mid) {
      temp[i++] = nums[l++];
    }
    while (r <= right) {
      temp[i++] = nums[r++];
    }
    for (int j = left; j <= right; j++) {
      nums[j] = temp[j - left];
    }
  }
  // end::answer[]
}
