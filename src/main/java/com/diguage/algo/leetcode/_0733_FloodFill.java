package com.diguage.algo.leetcode;

public class _0733_FloodFill {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-01 23:27:26
   */
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int origin = image[sr][sc];
    if (origin == color) {
      return image;
    }
    dfs(image, sr, sc, color, origin);
    return image;
  }

  private void dfs(int[][] image, int r, int c, int color, int origin) {
    if (r < 0 || image.length <= r
      || c < 0 || image[r].length <= c
      || image[r][c] != origin) {
      return;
    }
    image[r][c] = color;
    // 上
    dfs(image, r - 1, c, color, origin);
    // 下
    dfs(image, r + 1, c, color, origin);
    // 左
    dfs(image, r, c - 1, color, origin);
    // 右
    dfs(image, r, c + 1, color, origin);
  }
  // end::answer[]
}
