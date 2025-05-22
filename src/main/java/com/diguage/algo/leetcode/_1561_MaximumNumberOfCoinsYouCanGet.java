package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _1561_MaximumNumberOfCoinsYouCanGet {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-22 23:28:11
   */
  public int maxCoins(int[] piles) {
    Arrays.sort(piles);
    int result = 0;
    // TODO 有更简单的写法，尝试把坐标写出来，去寻找规律。
    for (int i = piles.length - 2, cnt = piles.length / 3;
         cnt > 0 && i > 0; i -= 2, cnt--) {
      result += piles[i];
    }
    return result;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _1561_MaximumNumberOfCoinsYouCanGet()
      .maxCoins(new int[]{2, 4, 1, 2, 7, 8});
  }
}
