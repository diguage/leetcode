package com.diguage.algo.leetcode;

public class _0661_ImageSmoother {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-26 19:54:40
   */
  public int[][] imageSmoother(int[][] img) {
    int m = img.length;
    int n = img[0].length;
    int[][] result = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        result[i][j] = arg(img, i, j);
      }
    }
    return result;
  }

  private int arg(int[][] img, int row, int column) {
    int sum = img[row][column];
    int count = 1;
    // 上
    if (1 <= row) {
      // 左上
      if (1 <= column) {
        sum += img[row - 1][column - 1];
        count++;
      }
      sum += img[row - 1][column];
      count++;
      // 右上
      if (column < img[row].length - 1) {
        sum += img[row - 1][column + 1];
        count++;
      }
    }
    // 下
    if (row < img.length - 1) {
      // 左下
      if (1 <= column) {
        sum += img[row + 1][column - 1];
        count++;
      }
      sum += img[row + 1][column];
      count++;
      // 右下
      if (column < img[row].length - 1) {
        sum += img[row + 1][column + 1];
        count++;
      }
    }
    // 左
    if (1 <= column) {
      sum += img[row][column - 1];
      count++;
    }
    // 右
    if (column < img[row].length - 1) {
      sum += img[row][column + 1];
      count++;
    }
    return sum / count;
  }
  // end::answer[]
}
