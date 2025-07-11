package com.diguage.algo.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class _0313_SuperUglyNumber {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-11 16:39:48
   */
  public int nthSuperUglyNumber(int n, int[] primes) {
    PriorityQueue<Long> queue = new PriorityQueue<>();
    Set<Long> set = new HashSet<>();
    queue.offer(1L);
    long max = Long.MIN_VALUE;
    while (n > 0) {
      long ugly = queue.poll();
      System.out.println(ugly);
      if (n == 1) {
        return (int) ugly;
      }
      n--;
      for (int prime : primes) {
        long next = ugly * prime;
        // 超过最大值，而且目前的数字已经足够，则就可以直接中止了
        if (next > max && queue.size() >= n) {
          break;
        }
        if (!set.contains(next)) {
          queue.offer(next);
          set.add(next);
          max = Math.max(max, next);
        }
      }
    }
    return -1;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0313_SuperUglyNumber().nthSuperUglyNumber(12, new int[]{2, 7, 13, 19});
  }
}
