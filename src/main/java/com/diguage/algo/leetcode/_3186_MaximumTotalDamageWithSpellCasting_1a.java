package com.diguage.algo.leetcode;

import java.util.*;

public class _3186_MaximumTotalDamageWithSpellCasting_1a {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-09 20:11:43
   */
  public long maximumTotalDamage(int[] power) {
    // 统计每个伤害的个数
    Map<Integer, Integer> cnt = new HashMap<>();
    for (int p : power) {
      cnt.merge(p, 1, Integer::sum);
    }
    int n = cnt.size();
    int[] a = new int[n];
    int i = 0;
    for (Integer k : cnt.keySet()) {
      a[i++] = k;
    }
    Arrays.sort(a);

    long[] memo = new long[n];
    Arrays.fill(memo, -1);
    return dfs(a, cnt, memo, n - 1);
  }

  private long dfs(int[] a, Map<Integer, Integer> cnt, long[] memo, int index) {
    if (index < 0) {
      return 0;
    }
    if (memo[index] >= 0) {
      return memo[index];
    }
    long result = dfs(a, cnt, memo, index - 1);
    int x = a[index];
    int j = index;
    // 这里为什么是 j-1，而不是 j ？
    while (j > 0 && a[j - 1] >= x - 2) {
      j--;
    }
    result = Math.max(result, dfs(a, cnt, memo, j - 1) + x * cnt.get(x));
    return memo[index] = result;
  }
  // end::answer[]

  static void main() {
    new _3186_MaximumTotalDamageWithSpellCasting_1a()
      .maximumTotalDamage(new int[]{1, 1, 3, 4});
  }
}
