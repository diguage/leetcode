package com.diguage.algo.leetcode;

import java.util.*;

public class _0502_Ipo_2 {
  // tag::answer[]
  /**
   * 贪心算法（原版有问题 -> 优化后）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-04 23:22:25
   */
  public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    int length = profits.length;
    List<int[]> c2p = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      c2p.add(new int[]{capital[i], profits[i]});
    }
    Collections.sort(c2p, Comparator.comparingInt(a -> a[0]));
    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
    int index = 0;
    while (k > 0) {
      // 将投入小于 w 的投资收益入队
      while (index < length && c2p.get(index)[0] <= w) {
        queue.add(c2p.get(index)[1]);
        index++;
      }
      if (queue.isEmpty()) {
        break;
      }
      // 获取当前可以获得的最大收益
      w += queue.poll();
      k--;
    }
    return w;
  }
  // end::answer[]

  static void main() {
    new _0502_Ipo_2()
//      .findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1});
      .findMaximizedCapital(3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2});
  }
}
