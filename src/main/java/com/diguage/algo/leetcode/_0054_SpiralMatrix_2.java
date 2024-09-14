package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0054_SpiralMatrix_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-14 17:42:39
   */
  public List<Integer> spiralOrder(int[][] matrix) {
    int row = matrix.length;
    int column = matrix[0].length;
    List<Integer> result = new ArrayList<>(row * column);
    bfs(matrix, result, 0, 0, row, column);
    return result;
  }

  private void bfs(int[][] matrix, List<Integer> result,
                   int row, int column,
                   int rLen, int cLen) {
    if (rLen <= 0 || cLen <= 0) {
      return;
    }
    for (int i = column; i < column + cLen; i++) {
      result.add(matrix[row][i]);
    }
    for (int i = row + 1; i < row + rLen; i++) {
      result.add(matrix[i][column + cLen - 1]);
    }
    // 不想增加复杂判断了，数量足够就直接返回
    // 如果不返回，在最后只剩下一层且有多个元素时，中间元素会被重复添加
    if (result.size() == matrix.length * matrix[0].length) {
      return;
    }
    for (int i = column + cLen - 2; i >= column; i--) {
      result.add(matrix[row + rLen - 1][i]);
    }
    for (int i = row + rLen - 2; i > row; i--) {
      result.add(matrix[i][column]);
    }
    bfs(matrix, result, row + 1, column + 1, rLen - 2, cLen - 2);
  }
  // end::answer[]
}
