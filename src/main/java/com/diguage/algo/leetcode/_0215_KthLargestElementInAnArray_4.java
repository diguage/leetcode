package com.diguage.algo.leetcode;

public class _0215_KthLargestElementInAnArray_4 {
  // tag::answer[]
/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2025-03-26 16:24:19
 */
public int findKthLargest(int[] nums, int k) {
  // 第 k 大的元素，正好是升序数组的 nums.length - k 个元素
  return quickselect(nums, nums.length - k, 0, nums.length - 1);
}

private int quickselect(int[] nums, int k, int left, int right) {
  if (left == right) {
    return nums[k];
  }
  int pivot = nums[left];
  // 由于下面先移动指针，所以左右指针各项左右移一位
  int l = left - 1, r = right + 1;
  while (l < r) {
    // 交换之后，没有移动指针，所以先移动指针再循环
    do {
      l++;
    } while (nums[l] < pivot);
    do {
      r--;
    } while (pivot < nums[r]);
    if (l < r) {
      int tmp = nums[l];
      nums[l] = nums[r];
      nums[r] = tmp;
    }
  }
  // r 是最后一个小于或等于 pivot 的元素的索引。
  // [left, r] 是确定小于或等于 pivot 的部分。
  if (k <= r) {
    return quickselect(nums, k, left, r);
  } else {
    return quickselect(nums, k, r + 1, right);
  }
}
  // end::answer[]

  public static void main(String[] args) {
    new _0215_KthLargestElementInAnArray_4().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
  }
}
