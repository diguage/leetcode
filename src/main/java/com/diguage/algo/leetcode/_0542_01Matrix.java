package com.diguage.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class _0542_01Matrix {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-07 22:47:35
   */
  public int[][] updateMatrix(int[][] mat) {
    Queue<int[]> queue = new ArrayDeque<>();
    int row = mat.length;
    int column = mat[0].length;
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < column; c++) {
        if (mat[r][c] == 0) {
          queue.offer(new int[]{r, c});
        } else {
          mat[r][c] = -1;
        }
      }
    }
    int[] dx = new int[]{0, 0, -1, 1};
    int[] dy = new int[]{-1, 1, 0, 0};
    while (!queue.isEmpty()) {
      int[] point = queue.poll();
      int r = point[0];
      int c = point[1];
      for (int i = 0; i < 4; i++) {
        int nr = r + dx[i];
        int nc = c + dy[i];
        if (0 <= nr && nr < row
          && 0 <= nc && nc < column
          && mat[nr][nc] == -1) {
          mat[nr][nc] = mat[r][c] + 1;
          queue.offer(new int[]{nr, nc});
        }
      }
    }
    return mat;
  }
  // end::answer[]
}
