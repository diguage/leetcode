package com.diguage.algo.leetcode;

public class _0837_New21Game {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-28 21:55:38
   */
  public double new21Game(int n, int k, int maxPts) {
    double[] f = new double[n + 1];
    double s = 0;
    for (int i = n; i >= 0; i--) {
      f[i] = i >= k ? 1 : s / maxPts;
      // 当前循环计算的是 f[i+1] + ... + f[i+maxPts]
      // 下个循环计算的是 f[i] + ... + f[i+maxPts-1]，多了 f[i]，少了 f[i+maxPts]
      s += f[i];
      if (i + maxPts <= n) {
        s -= f[i + maxPts];
      }
    }
    return f[0];
  }
  // end::answer[]

  static void main() {
    new _0837_New21Game().new21Game(6, 1, 10);
  }
}
