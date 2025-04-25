package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0037_SudokuSolver_3 {
  // tag::answer[]

  /**
   * * @author D瓜哥 · https://www.diguage.com
   * * @since 2024-09-11 10:59:08
   */
  public void solveSudoku(char[][] board) {
    // 使用比特位来标注已经存在哪些字符
    int[] rows = new int[9];
    int[] columns = new int[9];
    int[][] boxes = new int[3][3];
    List<int[]> positions = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        char c = board[i][j];
        if (c == '.') {
          // 记录需要填充的位置
          positions.add(new int[]{i, j});
        } else {
          int num = c - '0' - 1;
          flip(rows, columns, boxes, i, j, num);
        }
      }
    }
    // 使用回溯尝试填充
    backtrack(board, rows, columns, boxes, positions, 0);
  }

  private boolean backtrack(char[][] board,
                            int[] rows, int[] columns, int[][] boxes,
                            List<int[]> positions, int index) {
    if (positions.size() == index) {
      return true;
    }
    int[] pos = positions.get(index);
    int r = pos[0];
    int c = pos[1];
    // 打开这些输出，就超时。关闭，就能超过 90%
    //    System.out.printf("%5d   %33s\n", rows[r], Integer.toBinaryString(rows[r]));
    //    System.out.printf("%5d   %33s\n", columns[c], Integer.toBinaryString(columns[c]));
    //    System.out.printf("%5d   %33s\n", boxes[r / 3][c / 3], Integer.toBinaryString(boxes[r / 3][c / 3]));
    int orNum = rows[r] | columns[c] | boxes[r / 3][c / 3];
    //    System.out.printf("%5d   %33s\n", orNum, Integer.toBinaryString(orNum));
    int negNum = ~orNum;
    //    System.out.printf("%5d   %33s\n", negNum, Integer.toBinaryString(negNum));
    int mask = negNum & 0x1FF;
    //    System.out.printf("%5d   %33s\n", mask, Integer.toBinaryString(mask));
    for (; mask != 0; mask &= (mask - 1)) {
      int digitMask = mask & (-mask);
      //      System.out.printf("%5d   %33s\n", digitMask, Integer.toBinaryString(digitMask));
      //      System.out.printf("%5d   %33s\n", digitMask - 1, Integer.toBinaryString(digitMask - 1));
      int num = Integer.bitCount(digitMask - 1);
      //      System.out.println(num);
      flip(rows, columns, boxes, r, c, num);
      board[r][c] = (char) (num + '0' + 1);
      boolean result = backtrack(board, rows, columns, boxes, positions, index + 1);
      if (result) {
        return true;
      }
      flip(rows, columns, boxes, r, c, num);
    }
    return false;
  }

  private void flip(int[] rows, int[] columns, int[][] boxes,
                    int i, int j, int num) {
    int digit = 1 << num;
    // 这里使用异或而不是使用或，或只能用于初次标记。
    // 而异或的优点是，在选择和撤销时，可以使用相同的操作。
    rows[i] ^= digit;
    columns[j] ^= digit;
    boxes[i / 3][j / 3] ^= digit;
  }

  // end::answer[]
  public static void main(String[] args) {
    char[][] borad = {
      {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
      {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
      {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
      {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
      {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
      {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
      {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
      {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
      {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };
    new _0037_SudokuSolver_3().solveSudoku(borad);
  }
}
