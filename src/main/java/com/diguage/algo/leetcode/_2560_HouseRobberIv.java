package com.diguage.algo.leetcode;

public class _2560_HouseRobberIv {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-17 17:04:09
   */
  public int minCapability(int[] nums, int k) {
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (int num : nums) {
      min = Math.min(min, num);
      max = Math.max(max, num);
    }
    while (min <= max) {
      int mid = min + (max - min) / 2;
      int count = 0;
      boolean visited = false;
      for (int num : nums) {
        if (num <= mid && !visited) {
          count++;
          visited = true;
        } else {
          visited = false;
        }
      }
      if (count >= k) {
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }
    return min;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _2560_HouseRobberIv().minCapability(new int[]{2, 3, 5, 9}, 2);
  }
}
