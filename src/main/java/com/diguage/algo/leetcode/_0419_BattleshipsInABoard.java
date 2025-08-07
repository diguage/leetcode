package com.diguage.algo.leetcode;

public class _0419_BattleshipsInABoard {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-07 22:40:32
   */
  public int countBattleships(char[][] board) {
    int m = board.length, n = board[0].length;
    int result = 0;
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (board[r][c] == 'X') {
          if (r > 0 && board[r - 1][c] == 'X') {
            continue;
          }
          if (c > 0 && board[r][c - 1] == 'X') {
            continue;
          }
          result++;
        }
      }
    }
    return result;
  }
//  public int countBattleships(char[][] board) {
//    int m = board.length, n = board[0].length;
//    int result = 0;
//    // TODO 还需要处理一行一列的情况
//    for (int i = 0; i < m; i++) {
//      for (int j = 0; j < n; ) {
//        if (board[i][j] == 'X') {
//          int next = scan(board, i, j, false);
//          if (next - 1 > j || (next - 1 == j && (i + 1 < m && board[i + 1][j] == '.'))) {
//            result++;
//          }
//          j = next;
//        } else {
//          j++;
//        }
//      }
//    }
//    for (int i = 0; i < n; i++) {
//      for (int j = 0; j < m; ) {
//        if (board[j][i] == 'X') {
//          int next = scan(board, i, j, true);
//          if (next - 1 > j) {
//            result++;
//          }
//          j = next;
//        } else {
//          j++;
//        }
//      }
//    }
//    return result;
//  }
//
//  private int scan(char[][] board, int row, int col, boolean isRow) {
//    if (isRow) {
//      for (int i = row; i < board.length; i++) {
//        if (board[i][col] != 'X') {
//          return i;
//        }
//      }
//      return board.length;
//    } else {
//      for (int i = col; i < board[row].length; i++) {
//        if (board[row][i] != 'X') {
//          return i;
//        }
//      }
//      return board[0].length;
//    }
//  }

  // end::answer[]
  public static void main(String[] args) {
    new _0419_BattleshipsInABoard().countBattleships(new char[][]{
      {'X', '.', '.', 'X'},
      {'.', '.', '.', 'X'},
      {'.', '.', '.', 'X'}
    });
  }
}
