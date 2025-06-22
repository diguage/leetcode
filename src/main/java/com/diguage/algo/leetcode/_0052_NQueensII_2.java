package com.diguage.algo.leetcode;
import static com.diguage.util.Printers.*;

/**
 * = 52. N-Queens II
 *
 * https://leetcode.com/problems/n-queens-ii/[N-Queens II - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-29 20:35:25
 */
public class _0052_NQueensII_2 {
  // tag::answer[]
  /**
   * 自己实现
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-06-29 20:35:25
   */
  private int result = 0;

  public int totalNQueens(int n) {
    int[][] matrix = new int[n][n];
    backtrack(matrix, 0, 0);
    return result;
  }

  private void backtrack(int[][] matrix, int step, int count) {
    int size = matrix.length;
    int pow = size * size;
    printMatrix(matrix);
    if (step > pow) {
      return;
    } else if (size == count) {
      result++;
    } else {
      for (int i = step; i < pow; i++) {
        int row = i / size;
        int col = i % size;
        if (isValid(matrix, row, col)) {
          matrix[row][col] = 1;
          backtrack(matrix, (row + 1) * size, count + 1);
          matrix[row][col] = 0;
        }
      }
    }
  }

  private boolean isValid(int[][] matrix, int row, int col) {
    int length = matrix.length;
    for (int i = 0; i < length; i++) {
      if (matrix[row][i] == 1) {
        return false;
      }
      if (i < row && matrix[i][col] == 1) {
        return false;
      }
    }
    for (int i = 0; i < length; i++) {
      // 左上角
      if (0 <= row - i && 0 <= col - i && matrix[row - i][col - i] == 1) {
        return false;
      }
      // 右上角
      if (0 <= row - i && col + i < length && matrix[row - i][col + i] == 1) {
        return false;
      }
    }
    return true;
  }

  // end::answer[]


  public static void main(String[] args) {
    int result = new _0052_NQueensII_2().totalNQueens(4);
    System.out.println("result=" + result + " : " + (result == 2));
  }
}
