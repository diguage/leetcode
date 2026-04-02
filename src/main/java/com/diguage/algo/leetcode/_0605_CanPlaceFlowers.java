package com.diguage.algo.leetcode;

public class _0605_CanPlaceFlowers {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-02 23:00:31
   */
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int m = 0;
    for (int i = 0; i < flowerbed.length; i++) {
      if (flowerbed[i] != 0) {
        continue;
      }
      if (i == 0) {
        if (flowerbed.length == 1 || flowerbed[1] == 0) {
          flowerbed[i] = -1;
          m++;
        }
        continue;
      }
      if (i == flowerbed.length - 1) {
        if (flowerbed[i - 1] == 0) {
          flowerbed[i] = -1;
          m++;
        }
        continue;
      }
      if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
        flowerbed[i] = -1;
        m++;
      }
    }
    return m >= n;
  }

  // end::answer[]
  static void main() {
    new _0605_CanPlaceFlowers().canPlaceFlowers(new int[]{1, 0, 1, 0, 1, 0, 1}, 2);
  }
}
