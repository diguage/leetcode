package com.diguage.algo.leetcode;

public class _0712_MinimumAsciiDeleteSumForTwoStrings_1a {
  // tag::answer[]

  /**
   * 暴力破解 （63 / 93）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-24 22:36:43
   */
  public int minimumDeleteSum(String s1, String s2) {
    char[] sc1 = s1.toCharArray();
    char[] sc2 = s2.toCharArray();
    return dfs(sc1, sc1.length - 1, sc2, sc2.length - 1);
  }

  private int dfs(char[] a, int ai, char[] b, int bi) {
    if (ai < 0) {
      return sum(b, bi);
    }
    if (bi < 0) {
      return sum(a, ai);
    }
    if (a[ai] == b[bi]) {
      return dfs(a, ai - 1, b, bi - 1);
    } else {
      return Math.min(dfs(a, ai - 1, b, bi) + (int) a[ai],
        dfs(a, ai, b, bi - 1) + (int) b[bi]);
    }
  }

  private int sum(char[] a, int ai) {
    int result = 0;
    for (int i = 0; i <= ai; i++) {
      result += a[i];
    }
    return result;
  }
  // end::answer[]

// 正题反做：通过最长子序列来计算“差值”
//  public int minimumDeleteSum(String s1, String s2) {
//    char[] sc1 = s1.toCharArray();
//    char[] sc2 = s2.toCharArray();
//    int total = s1.chars().sum() + s2.chars().sum();
//    int[][] memo = new int[sc1.length][sc2.length];
//    for (int[] m : memo) {
//      Arrays.fill(m, -1);
//    }
//    int dfs = dfs(sc1, sc1.length - 1, sc2, sc2.length - 1, memo);
//    return total - dfs * 2;
//  }
//
//  private int dfs(char[] a, int ai, char[] b, int bi, int[][] memo) {
//    if (ai < 0 || bi < 0) {
//      return 0;
//    }
//    if (memo[ai][bi] != -1) {
//      return memo[ai][bi];
//    }
//    if (a[ai] == b[bi]) {
//      return memo[ai][bi] = dfs(a, ai - 1, b, bi - 1, memo) + ((int) a[ai]);
//    } else {
//      return memo[ai][bi] = Math.max(dfs(a, ai - 1, b, bi, memo),
//        dfs(a, ai, b, bi - 1, memo));
//    }
//  }

  static void main() {
    int sum = new _0712_MinimumAsciiDeleteSumForTwoStrings_1a()
      .minimumDeleteSum("sea", "eat");
    System.out.println(sum);
  }
}
