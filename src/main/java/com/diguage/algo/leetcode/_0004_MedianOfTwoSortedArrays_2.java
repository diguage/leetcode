package com.diguage.algo.leetcode;

public class _0004_MedianOfTwoSortedArrays_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-06 22:50:37
   */
  public double findMedianSortedArrays(int[] a, int[] b) {
    if (a.length > b.length) {
      int[] tmp = a;
      a = b;
      b = tmp;
    }
    int m = a.length;
    int n = b.length;
    // 循环不变量：a[left] <= b[j+1]
    // 循环不变量：a[right] > b[j+1]
    int left = -1;
    int right = m;
    while (left + 1 < right) { // 开区间 (left, right) 不为空
      int i = left + (right - left) / 2;
      int j = (m + n + 1) / 2 - i - 2;
      if (a[i] < b[j + 1]) {
        left = i; // 缩小二分区间（i, right）
      } else {
        right = i; // 缩小二分区间（left, i）
      }
    }
    // 此时 left 等于 right - 1
    // a[left] <= b[j+1] 且 a[right] > b[j'+1] = b[j]，所以答案是 i = left
    int i = left;
    int j = (m + n + 1) / 2 - i - 2;
    int ai = i >= 0 ? a[i] : Integer.MIN_VALUE;
    int bj = j >= 0 ? b[j] : Integer.MIN_VALUE;
    int ai1 = i + 1 < m ? a[i + 1] : Integer.MAX_VALUE;
    int bj1 = j + 1 < n ? b[j + 1] : Integer.MAX_VALUE;
    int max1 = Math.max(ai, bj);
    int min2 = Math.min(ai1, bj1);
    return (m + n) % 2 > 0 ? max1 : (max1 + min2) / 2.0;
  }
  // end::answer[]
}
