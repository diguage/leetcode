package com.diguage.algo.leetcode;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _0835_ImageOverlap {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-24 23:04:01
   */
  public int largestOverlap(int[][] A, int[][] B) {
    int N = A.length;
    List<Point> ap = new ArrayList<>();
    List<Point> bp = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (A[i][j] == 1) {
          ap.add(new Point(i, j));
        }
        if (B[i][j] == 1) {
          bp.add(new Point(i, j));
        }
      }
    }
    Set<Point> set = new HashSet<>(bp);
    int result = 0;
    Set<Point> seen = new HashSet<>();
    for (Point a : ap) {
      for (Point b : bp) {
        Point delta = new Point(b.x - a.x, b.y - a.y);
        if (!seen.contains(delta)) {
          seen.add(delta);
          int cnt = 0;
          for (Point p : ap) {
            if (set.contains(new Point(p.x + delta.x, p.y + delta.y))) {
              cnt++;
            }
          }
          result = Math.max(result, cnt);
        }
      }
    }
    return result;
  }
  // end::answer[]
}
