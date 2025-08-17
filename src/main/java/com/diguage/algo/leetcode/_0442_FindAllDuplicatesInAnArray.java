package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0442_FindAllDuplicatesInAnArray {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-17 22:40:41
   */
  public List<Integer> findDuplicates(int[] nums) {
    int n = nums.length;
    // 使用 “Cyclic Sort 循环排序” 模式，来对数组进行排序
    for (int i = 0; i < n; i++) {
      while (nums[i] != nums[nums[i] - 1]) {
        // 这里必须使用交换方法来完成交换
        // 不使用交换方法，而直接使用下标来引用，会导致“漂移”。
        swap(nums, i, nums[i] - 1);
      }
    }

    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (nums[i] != i + 1) {
        result.add(nums[i]);
      }
    }
    return result;
  }
  private void swap(int[] nums, int a, int b) {
    int tmp = nums[a];
    nums[a] = nums[b];
    nums[b] = tmp;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0442_FindAllDuplicatesInAnArray()
      .findDuplicates(new int[]{5, 4, 6, 7, 9, 3, 10, 9, 5, 6});
  }
}
