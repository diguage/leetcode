package com.diguage.algo.sort;

public class CyclicSort {
  // tag::answer[]

  /**
   * 循环排序
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-18 19:19:45
   */
  public void cyclicSort(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      while (nums[i] != i) {
        // 只要坐标上数跟坐标不相等就交换
        int temp = nums[i];
        nums[i] = nums[temp];
        nums[temp] = temp;
      }
    }
  }

  // end::answer[]
  static void main() {
    int[] nums = {3, 7, 0, 9, 2, 5, 8, 1, 6, 4};
    CyclicSort cs = new CyclicSort();
    cs.cyclicSort(nums);
  }
}
