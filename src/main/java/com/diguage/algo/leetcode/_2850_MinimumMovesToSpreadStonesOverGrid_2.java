package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _2850_MinimumMovesToSpreadStonesOverGrid_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-05 19:43:42
   */
  public int minimumMoves(int[][] grid) {
    List<int[]> more = new ArrayList<>();
    List<int[]> less = new ArrayList<>();
    for (int c = 0; c < grid.length; c++) {
      for (int r = 0; r < grid[c].length; r++) {
        if (grid[c][r] == 0) {
          less.add(new int[]{c, r});
        } else if (grid[c][r] > 1) {
          for (int i = 1; i < grid[c][r]; i++) {
            more.add(new int[]{c, r});
          }
        }
      }
    }
    List<List<int[]>> permutations = buildPermutations(more);
    int result = Integer.MAX_VALUE;
    for (List<int[]> starts : permutations) {
      int step = 0;
      for (int i = 0; i < less.size(); i++) {
        int[] start = starts.get(i);
        int[] end = less.get(i);
        step += (Math.abs(end[0] - start[0]) + Math.abs(end[1] - start[1]));
      }
      result = Math.min(result, step);
    }
    return result;
  }

  private List<List<int[]>> buildPermutations(List<int[]> more) {
    List<List<int[]>> result = new ArrayList<>(more.size() * more.size());
    List<int[]> path = new ArrayList<>(more.size());
    boolean[] used = new boolean[more.size()];
    buildPermutations(more, result, path, used);
    return result;
  }

  private void buildPermutations(List<int[]> points, List<List<int[]>> result,
                                 List<int[]> path, boolean[] used) {
    if (path.size() == points.size()) {
      result.add(new ArrayList<>(path));
      return;
    }
    for (int i = 0; i < points.size(); i++) {
      if (used[i]) {
        continue;
      }
      path.add(points.get(i));
      used[i] = true;
      buildPermutations(points, result, path, used);
      used[i] = false;
      path.removeLast();
    }
  }
  // end::answer[]
}
