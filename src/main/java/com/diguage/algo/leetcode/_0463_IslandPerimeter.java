package com.diguage.algo.leetcode;

public class _0463_IslandPerimeter {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-28 22:12:23
   */
  public int islandPerimeter(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    int perimeter = 0;
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        if (grid[r][c] == 0) {
          continue;
        }
        perimeter += calcPerimeter(grid, r, c);
      }
    }
    return perimeter;
  }

  private int calcPerimeter(int[][] grid, int r, int c) {
    int result = 0;
    // 上
    if (r == 0 || grid[r - 1][c] == 0) {
      result++;
    }
    // 下
    if (r + 1 == grid.length || grid[r + 1][c] == 0) {
      result++;
    }
    // 左
    if (c == 0 || grid[r][c - 1] == 0) {
      result++;
    }
    // 右
    if (c + 1 == grid.length || grid[r][c + 1] == 0) {
      result++;
    }
    grid[r][c] = result > 0 ? result : -1;
    return result;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0463_IslandPerimeter().islandPerimeter(new int[][]{
      {0, 1, 0, 0},
      {1, 1, 1, 0},
      {0, 1, 0, 0},
      {1, 1, 0, 0}
    });
  }
}
