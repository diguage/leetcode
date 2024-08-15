package com.diguage.algo.leetcode;

public class _1011_CapacityToShipPackagesWithinDDays {
  // tag::answer[]

  /**
   * 二分查找，确定左边界
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-08-15 21:25:01
   */
  public int shipWithinDays(int[] weights, int days) {
    if (weights == null || weights.length == 0) {
      return 0;
    }
    int left = weights[0];
    int right = 0;
    for (int weight : weights) {
      left = Math.max(left, weight);
      right += weight;
    }
    while (left < right) {
      int mid = left + (right - left) / 2;
      int time = getTime(weights, mid);
      if (time <= days) {
        // 如果时间小于等于指定天数，那么就需要降低货运能力
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  /**
   * 指定装载能力下，所需的天数
   */
  private int getTime(int[] weights, int cap) {
    int days = 0;
    for (int i = 0; i < weights.length; ) {
      int x = cap;
      // 在承载能力允许的范围内，尽可能多装
      while (i < weights.length) {
        // 剩余空间，不够装下当前货物，则天数加 1
        if (x < weights[i]) {
          break;
        } else {
          x -= weights[i];
        }
        i++;
      }
      days++;
    }
    return days;
  }
  // end::answer[]
}
