package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0679_24Game {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-09 22:57:44
   */
  private static final double EPS = 1e-10;

  public boolean judgePoint24(int[] cards) {
    List<Double> cs = new ArrayList<>();
    for (int i : cards) {
      cs.add((double) i);
    }
    return dfs(cs);
  }

  private boolean dfs(List<Double> cards) {
    int size = cards.size();
    if (size == 1) {
      return Math.abs(cards.getFirst() - 24) < EPS;
    }
    for (int i = 0; i < size; i++) {
      double a = cards.get(i);
      for (int j = i + 1; j < size; j++) {
        double b = cards.get(j);
        List<Double> cans = new ArrayList<>();
        cans.add(a + b);
        cans.add(a - b);
        cans.add(b - a);
        cans.add(a * b);
        if (Math.abs(b) > EPS) {
          cans.add(a / b);
        }
        if (Math.abs(a) > EPS) {
          cans.add(b / a);
        }
        List<Double> next = new ArrayList<>(cards);
        next.remove(j);
        for (Double c : cans) {
          next.set(i, c);
          if (dfs(next)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  // end::answer[]
}
