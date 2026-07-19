package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _0826_MostProfitAssigningWork {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-19 21:59:47
   */
  public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    Arrays.sort(worker);
    int n = difficulty.length;
    int m = worker.length;
    Integer[] index = new Integer[n];
    for (int i = 0; i < n; i++) {
      index[i] = i;
    }
    // 这样能通过验证，但是感觉有点蒙对了的感觉。
    Arrays.sort(index,
      Comparator.comparingInt((Integer a) -> profit[a])
        .thenComparingInt(a -> difficulty[a]));
    int result = 0;
    int idx = n - 1;
    for (int i = m - 1; i >= 0; i--) {
      while (idx >= 0 && difficulty[index[idx]] > worker[i]) {
        idx--;
      }
      if (idx >= 0) {
        result += profit[index[idx]];
      }
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _0826_MostProfitAssigningWork()
//      .maxProfitAssignment(new int[]{85, 47, 57}, new int[]{24, 66, 99}, new int[]{40, 25, 25});
      .maxProfitAssignment(new int[]{68, 35, 52, 47, 86}, new int[]{67, 17, 1, 81, 3}, new int[]{92, 10, 85, 84, 82});
  }
}
