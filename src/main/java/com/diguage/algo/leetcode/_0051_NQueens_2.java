package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.diguage.util.Printers.printMatrix;

/**
 * = 51. N-Queens
 *
 * [N-Queens - LeetCode](https://leetcode.com/problems/n-queens/)
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-29 16:44:40
 */
public class _0051_NQueens_2 {
  // tag::answer[]
  /**
   * 自己实现
   */
  public List<List<String>> solveNQueens(int n) {
    if (n <= 0) {
      return Collections.emptyList();
    }
    int[][] board = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(board[i], 0);
    }
    List<List<String>> result = new ArrayList<>();
    backtrack(result, board, 0, 0);
    return result;
  }

  private void backtrack(List<List<String>> result, int[][] board, int index, int count) {
    int length = board.length;
    printMatrix(board);
    if (length < count) {
      return;
    }
    if (length == count) {
      List<String> r = new ArrayList<>(length);
      for (int[] ints : board) {
        StringBuilder sb = new StringBuilder();
        for (int n : ints) {
          if (n == 1) {
            sb.append("Q");
          } else {
            sb.append(".");
          }
        }
        r.add(sb.toString());
      }
      result.add(r);
    }
    for (int i = index; i < length * length; i++) {
      int row = i / length;
      int col = i % length;
      if (!isValid(board, row, col)) {
        continue;
      }
      board[row][col] = 1;
      backtrack(result, board, i, count + 1);
      board[row][col] = 0;
    }
  }

  private boolean isValid(int[][] board, int row, int col) {
    int length = board.length;
    for (int i = 0; i < length; i++) {
      if (board[i][col] == 1) {
        return false;
      }
      if (board[row][i] == 1) {
        return false;
      }
    }
    for (int i = 0; i < length; i++) {
      if (0 <= row - i && 0 <= col - i
        && board[row - i][col - i] == 1) {
        return false;
      }
      if (row + i < length && col + i < length
        && board[row + i][col + i] == 1) {
        return false;
      }
      if (0 <= row - i && col + i < length
        && board[row - i][col + i] == 1) {
        return false;
      }
      if (row + i < length && 0 <= col - i
        && board[row + i][col - i] == 1) {
        return false;
      }
    }
    return true;
  }
  // end::answer[]
}
