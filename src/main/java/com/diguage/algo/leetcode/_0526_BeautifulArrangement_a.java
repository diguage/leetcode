package com.diguage.algo.leetcode;

public class _0526_BeautifulArrangement_a {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-27 19:19:47
   */
  public int countArrangement(int n) {
    return dfs(0, n);
  }

  private int dfs(int s, int n) {
    if (s == ((1 << n) - 1)) {
      return 1;
    }
    int result = 0;
    int i = Integer.bitCount(s) + 1;
    for (int j = 1; j <= n; j++) {
      if ((s >> (j - 1) & 1) == 0 && (i % j == 0 || j % i == 0)) {
        result += dfs(s | (1 << (j - 1)), n);
      }
    }
    return result;
  }
  // end::answer[]
  static void main() {
    new _0526_BeautifulArrangement_a()
      .countArrangement(4);
  }
}
