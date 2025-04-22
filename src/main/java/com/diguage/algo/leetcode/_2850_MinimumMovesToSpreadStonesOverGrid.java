package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _2850_MinimumMovesToSpreadStonesOverGrid {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-22 21:35:28
   */
  public int minimumMoves(int[][] grid) {
    int row = grid.length;
    int column = grid[0].length;
    List<int[]> more = new ArrayList<>(row * column);
    List<int[]> less = new ArrayList<>(row * column);
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < column; c++) {
        if (grid[r][c] > 1) {
          for (int i = 1; i < grid[r][c]; i++) {
            more.add(new int[]{r, c});
          }
        } else if (grid[r][c] == 0) {
          less.add(new int[]{r, c});
        }
      }
    }
    List<List<int[]>> permutations = permutations(more);
    int result = Integer.MAX_VALUE;
    for (List<int[]> perm : permutations) {
      int distance = 0;
      for (int i = 0; i < less.size(); i++) {
        int[] start = perm.get(i);
        int[] end = less.get(i);
        distance += (Math.abs(end[0] - start[0]) + Math.abs(end[1] - start[1]));
      }
      result = Math.min(result, distance);
    }
    return result;
  }

  private List<List<int[]>> permutations(List<int[]> points) {
    List<List<int[]>> result = new ArrayList<>();
    List<int[]> path = new ArrayList<>();
    boolean[] used = new boolean[points.size()];
    permutations(points, result, path, used);
    return result;
  }

  private void permutations(List<int[]> points, List<List<int[]>> result,
                            List<int[]> path, boolean[] used) {
    if (path.size() == points.size()) {
      result.add(new ArrayList<>(path));
      return;
    }
    for (int i = 0; i < points.size(); i++) {
      if (used[i]) {
        continue;
      }
      used[i] = true;
      path.add(points.get(i));
      permutations(points, result, path, used);
      path.removeLast();
      used[i] = false;
    }
  }
  // end::answer[]
}
