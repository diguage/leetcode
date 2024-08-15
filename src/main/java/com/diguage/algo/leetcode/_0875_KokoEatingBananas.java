package com.diguage.algo.leetcode;

public class _0875_KokoEatingBananas {
  // tag::answer[]

  /**
   * 二分查找，确定左边界
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-08-15 20:40:08
   */
  public int minEatingSpeed(int[] piles, int h) {
    int left = 1, right = 0;
    for (int pile : piles) {
      right = Math.max(right, pile);
    }
    while (left < right) {
      int mid = left + (right - left) / 2;
      int hours = hours(piles, mid);
      if (hours == h) {
        // 搜索左侧边界，需要收缩右侧边界
        right = mid;
      } else if (hours < h) {
        // 由于消耗时间小于指定时间，
        // 那么就需要降低速度，来提高消耗时间。
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  /**
   * 以 k 速度，吃完所有香蕉需要的时间
   */
  private int hours(int[] piles, int k) {
    int result = 0;
    for (int pile : piles) {
      result += pile / k;
      if (pile % k != 0) {
        result++;
      }
    }
    return result;
  }
  // end::answer[]
}
