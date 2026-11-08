package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0054_SpiralMatrix_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-11-08 22:44:25
   */
  public List<Integer> spiralOrder(int[][] matrix) {
    int row = matrix.length;
    int column = matrix[0].length;
    List<Integer> result = new ArrayList<>(row * column);
    bfs(matrix, result, 0, 0, row - 1, column - 1);
    return result;
  }

  private void bfs(int[][] matrix, List<Integer> result,
                   int rowStart, int columnStart, int rowEnd, int columnEnd) {
    if (rowStart > rowEnd || columnStart > columnEnd) {
      return;
    }
    // 上
    for (int c = columnStart; c <= columnEnd; c++) {
      result.add(matrix[rowStart][c]);
    }
    // 右
    for (int r = rowStart + 1; r <= rowEnd; r++) {
      result.add(matrix[r][columnEnd]);
    }
    if (result.size()==matrix.length * matrix[0].length) {
      return;
    }
    // 下
    for (int c = columnEnd - 1; c >= columnStart; c--) {
      result.add(matrix[rowEnd][c]);
    }
    // 左
    for (int r = rowEnd - 1; r > rowStart; r--) {
      result.add(matrix[r][columnStart]);
    }
    bfs(matrix, result, rowStart + 1, columnStart + 1, rowEnd - 1, columnEnd - 1);
  }
  // end::answer[]
}
