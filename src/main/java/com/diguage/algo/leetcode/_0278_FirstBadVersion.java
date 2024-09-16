package com.diguage.algo.leetcode;

public class _0278_FirstBadVersion {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-16 16:18:53
   */
  public int firstBadVersion(int n) {
    int left = 1, right = n;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (isBadVersion(mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return right;
  }

  private boolean isBadVersion(int version) {
    return true;
  }
  // end::answer[]
}
