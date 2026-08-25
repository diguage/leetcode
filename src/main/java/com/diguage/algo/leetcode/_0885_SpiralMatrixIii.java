package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0885_SpiralMatrixIii {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-25 21:44:37
   */
  public int[][] spiralMatrixIII(int rows, int cols, int r, int c) {
    List<int[]> result = new ArrayList<>();
    int[][] directions = new int[][]{
      {0, 1},  // 0右
      {1, 0}, // 1左
      {0, -1},  // 2下
      {-1, 0}  // 3上
    };
    result.add(new int[]{r, c});
    if (rows * cols == result.size()) {
      return result.toArray(new int[result.size()][]);
    }
    for (int k = 1; k < 2 * (rows + cols); k += 2) {
      for (int i = 0; i < 4; i++) {
        int dk = k + (i / 2);
        for (int j = 0; j < dk; j++) {
          r += directions[i][0];
          c += directions[i][1];
          if (0 <= r && r < rows && 0 <= c && c < cols) {
            result.add(new int[]{r, c});
            if (rows * cols == result.size()) {
              return result.toArray(new int[result.size()][]);
            }
          }
        }
      }
    }
    return null;
  }

  // end::answer[]
//  public int[][] spiralMatrixIII(int rows, int cols, int r, int c) {
//    int[][] matrix = new int[rows + 2][cols + 2];
//    Arrays.fill(matrix[0], -1);
//    Arrays.fill(matrix[rows + 1], -1);
//    for (int i = 1; i <= rows; i++) {
//      matrix[i][0] = -1;
//      matrix[i][cols + 1] = -1;
//    }
//    List<int[]> result = new ArrayList<>();
//    int[][] directions = new int[][]{
//      {0, 1},  // 0右
//      {0, -1}, // 1左
//      {1, 0},  // 2下
//      {-1, 0}  // 3上
//    };
//    int d = 0;
//    r = r + 1;
//    c = c + 1;
//    while (result.size() < rows * cols) {
//      boolean visited = matrix[r][c] == 1;
//      if (!visited) {
//        matrix[r][c] = 1;
//        result.add(new int[]{r - 1, c - 1});
//        if (result.size() == rows * cols) {
//          break;
//        }
//      }
//      boolean flag = true;
//      if (d == 0) {
//        if (matrix[r + directions[d][0]][c + directions[d][1]] == -1
//          || (matrix[r][c - 1] == 1 && matrix[r + 1][c] == 0)) {
//          d = 2;
//          flag = false;
//        }
//      }
//      if (d == 1) {
//        if ((!visited && matrix[r - 1][c] == 0) || (matrix[r][c - 1] == -1)) {
//          d = 3;
//          flag = false;
//        }
//      }
//      if (flag && d == 2) {
//        if (!visited || matrix[r + 1][c] == -1) {
//          d = 1;
//        }
//      }
//      if (flag && d == 3) {
//        if ((!visited && matrix[r][c + 1] == 0) || (matrix[r - 1][c] == -1)) {
//          d = 0;
//        }
//      }
//      int[] dir = directions[d];
//      r += dir[0];
//      c += dir[1];
//    }
//    return result.toArray(new int[][]{});
//  }
  static void main() {
    new _0885_SpiralMatrixIii()
      .spiralMatrixIII(3, 3, 2, 0);
//      .spiralMatrixIII(3, 3, 0, 0);
//      .spiralMatrixIII(5, 6, 1, 4);
  }
}
