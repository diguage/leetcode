package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0576_OutOfBoundaryPaths {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-22 15:52:29
   */
  public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
    Map<Integer, Integer> memo = new HashMap<>();
    return dfs(m, n, maxMove, startRow, startColumn, memo);
  }

  private int dfs(int m, int n, int move, int row, int column, Map<Integer, Integer> memo) {
    int MOD = 1_000_000_007;
    if (row < 0 || m <= row
      || column < 0 || n <= column) {
      return 1;
    }
    if (move <= 0) {
      return 0;
    }

    Integer key = 10000 * move + 100 * row + column;
    if (memo.containsKey(key)) {
      return memo.get(key);
    }

    int next = move - 1;
    // 上
    int result = dfs(m, n, next, row - 1, column, memo);
    // 下
    result += dfs(m, n, next, row + 1, column, memo);
    result %= MOD;
    // 左
    result += dfs(m, n, next, row, column - 1, memo);
    result %= MOD;
    // 右
    result += dfs(m, n, next, row, column + 1, memo);
    result %= MOD;
    memo.put(key, result);
    return result;
  }
  // end::answer[]

  static void main() {
    new _0576_OutOfBoundaryPaths()
      .findPaths(2, 2, 2, 0, 0);
  }
}
