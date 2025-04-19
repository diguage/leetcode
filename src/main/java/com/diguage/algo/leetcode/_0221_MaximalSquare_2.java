package com.diguage.algo.leetcode;

public class _0221_MaximalSquare_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-18 23:35:51
   */
  public int maximalSquare(char[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    int result = 0;
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        if (matrix[r][c] == '0') {
          continue;
        }
        // 加速
        if (result == 0) {
          result = 1;
        }
        char left = '0';
        if (0 <= c - 1) {
          left = matrix[r][c - 1];
        }
        // 加速
        if (left == '0') {
          continue;
        }
        char top = '0';
        if (0 <= r - 1) {
          top = matrix[r - 1][c];
        }
        // 加速
        if (top == '0') {
          continue;
        }
        char topLeft = matrix[r - 1][c - 1];
        // 加速
        if (topLeft == '0') {
          continue;
        }
        matrix[r][c] = (char) (1 + Math.min(left, Math.min(topLeft, top)));
        result = Math.max(result, matrix[r][c] - '0');
      }
    }
    return result * result;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0221_MaximalSquare_2().maximalSquare(new char[][]{
      {'1', '0', '1', '0', '0'},
      {'1', '0', '1', '1', '1'},
      {'1', '1', '1', '1', '1'},
      {'1', '0', '0', '1', '0'}
    });
  }
}
