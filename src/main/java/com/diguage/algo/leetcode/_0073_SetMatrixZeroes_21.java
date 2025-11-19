package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0073_SetMatrixZeroes_21 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-19 21:18
   */
  public void setZeroes(int[][] matrix) {
    // 从数中找缺失的数字，使用缺失的数字作为占位符来处理
    // 处理其他太费劲了。而且，细节太多，极易出错。
    int m = matrix.length;
    int n = matrix[0].length;
    int size = m * n % 32 == 0 ? m * n / 32 : m * n / 32 + 1;
    int cap = size * 32;
    // 使用位来标记哪个数字出现过
    int[] data = new int[size];
    Arrays.fill(data, 0);
    for (int[] ints : matrix) {
      for (int r = 0; r < n; r++) {
        int num = ints[r];
        if (num >= cap || num < 0) {
          continue;
        }
        int index = num / 32;
        int rem = num % 32;
        data[index] |= (1 << rem);
      }
    }
    int placeholder = cap + 2;
    for (int i = 0; i < data.length; i++) {
      int bits = data[i];
      for (int j = 0; j < 32; j++) {
        // 第一个未出现的数字就是可用的占位符
        if (((bits >>> j) & 1) == 0) {
          placeholder = i * 32 + j;
          break;
        }
      }
      if (placeholder != cap + 2) {
        break;
      }
    }

    // 先将出现0的行列使用占位符数字标记
    for (int c = 0; c < m; c++) {
      for (int r = 0; r < n; r++) {
        if (matrix[c][r] == 0) {
          for (int ic = 0; ic < m; ic++) {
            if (matrix[ic][r] != 0) {
              matrix[ic][r] = placeholder;
            }
          }
          for (int ir = 0; ir < n; ir++) {
            if (matrix[c][ir] != 0) {
              matrix[c][ir] = placeholder;
            }
          }
        }
      }
    }
    // 再统一修改为 0
    for (int c = 0; c < m; c++) {
      for (int r = 0; r < n; r++) {
        if (matrix[c][r] == placeholder) {
          matrix[c][r] = 0;
        }
      }
    }
  }
  // end::answer[]

  static void main() {
    int[][] matrix5 = {{1, 0}};
//    int[][] matrix5 = {
//      {1, 1, 1},
//      {1, 0, 1},
//      {32, 1, 1}};
//    int[][] matrix5 = {
//      {0, 1, 2, 0},
//      {3, 4, 5, 2},
//      {1, 3, 1, 5}};
//    int[][] matrix5 = {
//      {8, 3, 6, 9, 7, 8, 0, 6},
//      {0, 3, 7, 0, 0, 4, 3, 8},
//      {5, 3, 6, 7, 1, 6, 2, 6},
//      {8, 7, 2, 5, 0, 6, 4, 0},
//      {0, 2, 9, 9, 3, 9, 7, 3}};
    new _0073_SetMatrixZeroes_21()
      .setZeroes(matrix5);
  }
}
