package com.diguage.algo.leetcode;

public class _0852_PeakIndexInAMountainArray {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-07 22:45:37
   */
  public int peakIndexInMountainArray(int[] a) {
    int left = 0, right = a.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      // 看哪边增长，峰值就在哪边
      if (a[mid] < a[mid + 1]) {
        left = mid;
      } else if (a[mid - 1] > a[mid]) {
        right = mid;
      } else {
        return mid;
      }
    }
    return left;
  }

  // end::answer[]
  static void main() {
    new _0852_PeakIndexInAMountainArray()
      .peakIndexInMountainArray(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19});
  }
}
