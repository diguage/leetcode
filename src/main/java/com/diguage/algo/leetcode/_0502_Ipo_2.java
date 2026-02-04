package com.diguage.algo.leetcode;

import java.util.*;

public class _0502_Ipo_2 {
  // tag::answer[]

  /**
   * 贪心算法
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-04 23:22:25
   */
  public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    // 这个解法的漏洞在于，大额投资换取大额汇报，但是测试用例不是这样的。有以小博大的情况。
    TreeMap<Integer, List<Integer>> profitMap = new TreeMap<>();
    for (int i = 0; i < profits.length; i++) {
      profitMap.computeIfAbsent(capital[i], _ -> new ArrayList<>())
        .add(profits[i]);
    }
    for (List<Integer> value : profitMap.values()) {
      Collections.sort(value, (a, b) -> b - a);
    }
    int result = w;
    for (int i = 0; i < k; i++) {
      if (profitMap.containsKey(result)) {
        List<Integer> ps = profitMap.get(result);
        Integer ip = ps.removeFirst();
        if (ps.isEmpty()) {
          profitMap.remove(result);
        }
        result += ip;
      } else {
        Map.Entry<Integer, List<Integer>> entry = profitMap.floorEntry(result);
        if (Objects.isNull(entry)) {
          continue;
        }
        result += entry.getValue().removeFirst();
        if (entry.getValue().isEmpty()) {
          profitMap.remove(entry.getKey());
        }
      }
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _0502_Ipo_2()
//      .findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1});
      .findMaximizedCapital(3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2});
  }
}
