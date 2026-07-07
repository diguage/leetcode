package com.diguage.algo.leetcode;

public class _0813_LargestSumOfAverages {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-07 22:21:16
   */
  public double largestSumOfAverages(int[] nums, int k) {
    int n = nums.length;
    double[] prefix = new double[n + 1];
    for (int i = 0; i < n; i++) {
      prefix[i + 1] = prefix[i] + nums[i];
    }
    double[][] dp = new double[n + 1][k + 1];
    for (int i = 1; i <= n; i++) {
      dp[i][1] = prefix[i] / i;
    }
    for (int j = 2; j <= k; j++) {
      for (int i = j; i <= n; i++) {
        for (int x = j - 1; x < i; x++) {
          dp[i][j] = Math.max(dp[i][j], dp[x][j - 1] + (prefix[i] - prefix[x]) / (i - x));
        }
      }
    }
    return dp[n][k];
  }
  // end::answer[]
  static void main() {
    new _0813_LargestSumOfAverages().largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3);
  }
}
