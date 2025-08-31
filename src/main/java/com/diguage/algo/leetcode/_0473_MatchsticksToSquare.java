package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0473_MatchsticksToSquare {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-31 22:03:27
   */
  public boolean makesquare(int[] matchsticks) {
    int sum = Arrays.stream(matchsticks).sum();
    if (sum % 4 != 0) {
      return false;
    }
    Arrays.sort(matchsticks);
    int[] edges = new int[4];
    // 从 matchsticks.length - 1 开始处理，
    // 相当于从大到小处理，可以明显减少回溯次数
    return dfs(matchsticks.length - 1, matchsticks, edges, sum / 4);
  }

  private boolean dfs(int index, int[] matchsticks, int[] edges, int side) {
    if (index == -1) {
      return true;
    }
    out:
    for (int i = 0; i < edges.length; i++) {
      // 剪枝，如果遇到相同的边长，就不再重复处理
      for (int j = 0; j < i; j++) {
        if (edges[j] == edges[i]) {
          continue out;
        }
      }
      edges[i] += matchsticks[index];
      if (edges[i] <= side && dfs(index - 1, matchsticks, edges, side)) {
        return true;
      }
      edges[i] -= matchsticks[index];
    }
    return false;
  }

  // end::answer[]
  public static void main(String[] args) {
    boolean result = new _0473_MatchsticksToSquare()
      .makesquare(new int[]{5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3});
    System.out.println(result);
  }
}
