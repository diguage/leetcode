package com.diguage.algo.leetcode;

public class _0747_LargestNumberAtLeastTwiceOfOthers {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-06 21:38:25
   */
  public int dominantIndex(int[] nums) {
    int first = -1, second = -1; // 把 first 初始化成 0 代码可以更简单
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (first < 0 || num > nums[first]) {
        if (first >= 0) {
          second = first;
        }
        first = i;
      } else if (second < 0 || num > nums[second]) {
        second = i;
      }
    }
    return nums[first] >= nums[second] * 2 ? first : -1;
  }

  // end::answer[]
  static void main() {
    new _0747_LargestNumberAtLeastTwiceOfOthers()
      .dominantIndex(new int[]{0, 0, 3, 2});
  }
}
