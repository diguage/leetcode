package com.diguage.algo.leetcode;

public class _0769_MaxChunksToMakeSorted {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-11 22:03:53
   */
  public int maxChunksToSorted(int[] arr) {
    int m = 0, result = 0;
    for (int i = 0; i < arr.length; i++) {
      m = Math.max(m, arr[i]);
      if (m == i) {
        result++;
      }
    }
    return result;
  }
  // end::answer[]
  static void main() {
    new _0769_MaxChunksToMakeSorted()
      .maxChunksToSorted(new int[]{2, 0, 1, 3});
//      .maxChunksToSorted(new int[]{2, 0, 1, 3});
  }
}
