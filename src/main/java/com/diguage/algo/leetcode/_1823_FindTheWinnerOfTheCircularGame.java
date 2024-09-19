package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class _1823_FindTheWinnerOfTheCircularGame {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-19 15:24:45
   */
  public int findTheWinner(int n, int k) {
    Queue<Integer> queue = new ArrayDeque<>(n);
    for (int i = 1;i<=n;i++) {
      queue.offer(i);
    }
    while(queue.size()>1) {
      for (int i= 1;i<k;i++) {
        queue.offer(queue.poll());
      }
      queue.poll();
    }
    return queue.poll();
  }
  // end::answer[]
}
