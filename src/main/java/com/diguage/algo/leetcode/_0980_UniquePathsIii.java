package com.diguage.algo.leetcode;

public class _0980_UniquePathsIii {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-13 20:29:14
   */
  int result = 0;
  int[][] options = new int[][]{
    {-1, 0},// 上
    {1, 0}, // 下
    {0, 1}, // 右
    {0, -1}, // 左
  };

  public int uniquePathsIII(int[][] grid) {
    int row = grid.length;
    int column = grid[0].length;
    int sr = -1, sc = -1;
    int path = 0;
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < column; c++) {
        if (grid[r][c] == 0) {
          path++;
          continue;
        }
        if (grid[r][c] == 1) {
          sr = r;
          sc = c;
          path++;
        }
      }
    }
    backtrack(grid, sr, sc, path);
    return result;
  }

  private void backtrack(int[][] grid, int sr, int sc, int path) {
    // 如果越界，则排除
    if (sr < 0 || grid.length <= sr || sc < 0 || grid[sr].length <= sc || path < 0) {
      return;
    }
    if (grid[sr][sc] == Integer.MIN_VALUE || grid[sr][sc] == -1) {
      return;
    }
    // 走到终点并且通过所有节点，则找到一个满足要求的结果
    if (grid[sr][sc] == 2) {
      if (path == 0) {
        result++;
      }
      return;
    }
    int origin = grid[sr][sc];
    grid[sr][sc] = Integer.MIN_VALUE;
    for (int[] option : options) {
      int r = sr + option[0];
      int c = sc + option[1];
      backtrack(grid, r, c, path - 1);
    }
    grid[sr][sc] = origin;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0980_UniquePathsIii().uniquePathsIII(new int[][]{
      {1, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 2, -1}});
  }
}
