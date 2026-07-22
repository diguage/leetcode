package com.diguage.algo.leetcode;

public class _0832_FlippingAnImage {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-22 22:50:57
   */
  public int[][] flipAndInvertImage(int[][] image) {
    for (int[] row : image) {
      int l = 0, r = row.length - 1;
      while (l < r) {
        int temp = row[l] ^ 1;
        row[l] = row[r] ^ 1;
        row[r] = temp;
        l++;
        r--;
      }
      if (l == r) {
        row[l] ^= 1;
      }
    }
    return image;
  }
  // end::answer[]
}
