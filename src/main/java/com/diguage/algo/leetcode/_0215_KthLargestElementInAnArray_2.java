package com.diguage.algo.leetcode;

/**
 * = 215. Kth Largest Element in an Array
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/[Kth Largest Element in an Array - LeetCode]
 *
 * Find the **k**th largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * ----
 *
 * *Note:*
 *
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-26 18:00
 */
public class _0215_KthLargestElementInAnArray_2 {
  // tag::answer[]
  /**
   * 参考 https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/307351/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/[数组中的第K个最大元素-题解^] 思路后，自己写出来的。
   */
  public int findKthLargest(int[] nums, int k) {
    int size = nums.length;
    return quickselect(nums, 0, size - 1, size - k);
  }

  private int quickselect(int[] nums, int left, int right, int k) {
    if (left == right) {
      return nums[k];
    }
    int num = nums[left];
    int l = left - 1, r = right + 1;
    while (l < r) {
      do {
        l++;
      } while (nums[l] < num);
      do {
        r--;
      } while (num < nums[r]);
      if (l < r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
      }
    }
    // TODO: 这里为什么需要使用 r ，而不能是 l ？
    if (k <= r) {
      return quickselect(nums, left, r, k);
    } else {
      return quickselect(nums, r + 1, right, k);
    }
  }

  // end::answer[]


  public static void main(String[] args) {
    int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
    _0215_KthLargestElementInAnArray_2 solution = new _0215_KthLargestElementInAnArray_2();
    int result = solution.findKthLargest(nums, 4);
    System.out.println(result);
  }
}
