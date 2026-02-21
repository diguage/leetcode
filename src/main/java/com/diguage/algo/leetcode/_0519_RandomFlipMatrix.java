package com.diguage.algo.leetcode;

import java.util.*;

public class _0519_RandomFlipMatrix {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-21 19:20:15
   */
  class Solution {
    int row;
    int column;
    Set<Integer> used;
    Random random;

    public Solution(int m, int n) {
      row = m;
      column = n;
      random = new Random();
      reset();
    }

    public int[] flip() {
      int counter = row * column;
      int a = random.nextInt(counter), b = a;
      while (a >= 0 && used.contains(a)) {
        a--;
      }
      while (b < counter && used.contains(b)) {
        b++;
      }
      int c = a >= 0 && !used.contains(a) ? a : b;
      used.add(c);
      return new int[]{c / column, c % column};
    }

    public void reset() {
      used = new HashSet<>();
    }
  }
  // end::answer[]
}
