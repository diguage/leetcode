package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0417_PacificAtlanticWaterFlow {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-06 22:54:09
   */
  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    int m = heights.length, n = heights[0].length;
    boolean[][] pacific = new boolean[m][n];
    boolean[][] atlantic = new boolean[m][n];
    for (int i = 0; i < n; i++) {
      dfs(heights, pacific, 0, i);
      dfs(heights, atlantic, m - 1, n - i - 1);
    }
    for (int i = 0; i < m; i++) {
      dfs(heights, pacific, i, 0);
      dfs(heights, atlantic, m - 1 - i, n - 1);
    }
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (pacific[i][j] && atlantic[i][j]) {
          result.add(List.of(i, j));
        }
      }
    }
    return result;
  }

  private void dfs(int[][] heights, boolean[][] fic, int row, int column) {
    if (row < 0 || row >= heights.length || column < 0 || column >= heights[0].length) {
      return;
    }
    if (fic[row][column]) {
      return;
    }
    fic[row][column] = true;
    // 上
    if (row - 1 >= 0 && heights[row][column] <= heights[row - 1][column]) {
      dfs(heights, fic, row - 1, column);
    }
    // 下
    if (row + 1 < heights.length && heights[row][column] <= heights[row + 1][column]) {
      dfs(heights, fic, row + 1, column);
    }
    // 左
    if (column - 1 >= 0 && heights[row][column - 1] >= heights[row][column]) {
      dfs(heights, fic, row, column - 1);
    }
    // 右
    if (column + 1 < heights[0].length && heights[row][column] <= heights[row][column + 1]) {
      dfs(heights, fic, row, column + 1);
    }
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0417_PacificAtlanticWaterFlow().pacificAtlantic(new int[][]{
      {1, 2, 2, 3, 5},
      {3, 2, 3, 4, 4},
      {2, 4, 5, 3, 1},
      {6, 7, 1, 4, 5},
      {5, 1, 1, 2, 4}
    });
  }
}
