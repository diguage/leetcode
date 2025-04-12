package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0054_SpiralMatrix_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-12 23:18:24
   */
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>(matrix.length * matrix[0].length);
    bfs(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, result);
    return result;
  }

  private void bfs(int[][] matrix,
                   int columnStart, int rowStart,
                   int columnEnd, int rowEnd,
                   List<Integer> result) {
    if (columnStart > columnEnd || rowStart > rowEnd) {
      return;
    }
    // 上
    for (int i = rowStart; i <= rowEnd; i++) {
      result.add(matrix[columnStart][i]);
    }
    // 右
    for (int i = columnStart + 1; i <= columnEnd; i++) {
      result.add(matrix[i][rowEnd]);
    }
    if (result.size() == matrix.length * matrix[0].length) {
      return;
    }
    // 下
    for (int i = rowEnd - 1; i >= rowStart; i--) {
      result.add(matrix[columnEnd][i]);
    }
    // 左
    for (int i = columnEnd - 1; i > columnStart; i--) {
      result.add(matrix[i][rowStart]);
    }
    bfs(matrix, columnStart + 1, rowStart + 1,
      columnEnd - 1, rowEnd - 1, result);
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0054_SpiralMatrix_3().spiralOrder(new int[][]{
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
    });
  }
}
