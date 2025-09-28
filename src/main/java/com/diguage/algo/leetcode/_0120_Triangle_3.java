package com.diguage.algo.leetcode;

import java.util.List;

public class _0120_Triangle_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-28 21:13:30
   */
  public int minimumTotal(List<List<Integer>> triangle) {
    Integer[] dp = triangle.getLast().toArray(new Integer[0]);
    // 最后一行已经复制了，从倒数第二行开始处理
    for (int i = triangle.size() - 2; i >= 0; i--) {
      List<Integer> curr = triangle.get(i);
      for (int j = 0; j < curr.size(); j++) {
        dp[j] = curr.get(j) + Math.min(dp[j], dp[j + 1]);
      }
    }
    return dp[0];
  }
  // end::answer[]

  static void main() {
    new _0120_Triangle_3().minimumTotal(List.of(
      List.of(2),
      List.of(3, 4),
      List.of(6, 5, 7),
      List.of(4, 1, 8, 3)));
  }
}
