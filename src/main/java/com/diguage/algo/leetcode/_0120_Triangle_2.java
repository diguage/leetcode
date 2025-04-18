package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.List;

public class _0120_Triangle_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2020-02-07 23:14
   */
  public int minimumTotal(List<List<Integer>> triangle) {
    int[] dp = new int[triangle.size()];
    dp[0] = triangle.get(0).get(0);
    for (int i = 1; i < triangle.size(); i++) {
      List<Integer> row = triangle.get(i);
      // 注意：这里有个技巧，从后向前遍历，不会影响剩余元素的计算。
      //      如果从前向后遍历，则会影响下一个元素的计算。
      for (int j = row.size() - 1; j >= 0; j--) {
        if (j == 0) {
          dp[j] = row.get(j) + dp[j];
        } else if (j == row.size() - 1) {
          dp[j] = row.get(j) + dp[j - 1];
        } else {
          dp[j] = row.get(j) + Math.min(dp[j - 1], dp[j]);
        }
      }
    }
    return Arrays.stream(dp).min().getAsInt();
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0120_Triangle_2()
      .minimumTotal(List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3)));
  }
}
