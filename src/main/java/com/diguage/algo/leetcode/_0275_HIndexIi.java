package com.diguage.algo.leetcode;

public class _0275_HIndexIi {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-06 23:09:04
   */
  public int hIndex(int[] citations) {
    int length = citations.length;
    int left = 0, right = length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int citation = citations[mid];
      int count = length - mid;
      if (citation > count) {
        right = mid - 1;
      } else if (citation < count) {
        left = mid + 1;
      } else {
        return citation;
      }
    }
    return length - right - 1;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0275_HIndexIi().hIndex(new int[]{1,2,100});
  }
}
