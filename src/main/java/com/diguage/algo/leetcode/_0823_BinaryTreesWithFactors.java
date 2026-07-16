package com.diguage.algo.leetcode;

import java.util.*;

public class _0823_BinaryTreesWithFactors {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-16 21:31:41
   */
  public int numFactoredBinaryTrees(int[] arr) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int i : arr) {
      map.put(i, new HashSet<>());
    }
    Arrays.sort(arr);
    for (int num : arr) {
      Set<Integer> set = map.get(num);
      for (int j = 0; arr[j] < num; j++) {
        int diff = num / arr[j];
        if (num % arr[j] == 0 && map.containsKey(diff)) {
          set.add(arr[j]);
          set.add(diff);
        }
      }
    }
    int MOD = 1_000_000_007;
    Map<Integer, Long> memo = new HashMap<>();
    long result = 0;
    for (int num : arr) {
      long temp = dfs(map, MOD, num, memo) % MOD;
      result = (result + temp) % MOD;
    }
    return (int) result;
  }

  private long dfs(Map<Integer, Set<Integer>> map, int MOD,
                   int num, Map<Integer, Long> memo) {
    if (memo.containsKey(num)) {
      return memo.get(num);
    }
    long result = 1;
    Set<Integer> set = map.get(num);
    for (Integer in : set) {
      // 注意：这里应该使用乘法原理！
      long a = dfs(map, MOD, in, memo);
      long b = dfs(map, MOD, num / in, memo);
      long temp = (a * b) % MOD;
      result = (result + temp) % MOD;
    }
    result %= MOD;
    memo.put(num, result);
    return result;
  }

  // end::answer[]
  static void main() {
    new _0823_BinaryTreesWithFactors().numFactoredBinaryTrees(new int[]{18, 3, 6, 2});
  }
}
