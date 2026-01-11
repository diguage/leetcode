package com.diguage.algo.leetcode;

import java.util.*;

public class _0037_SudokuSolver_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-11 08:53:00
   */
  public void solveSudoku(char[][] board) {
    Map<String, Set<Character>> chars = new HashMap<>();
    Set<Character> nums = new HashSet<>();
    for (char c : "123456789".toCharArray()) {
      nums.add(c);
    }
    for (int i = 0; i < 9; i++) {
      chars.put("r" + i, new HashSet<>(nums));
      chars.put("c" + i, new HashSet<>(nums));
    }
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        chars.put("r" + r + "/c" + c, new HashSet<>(nums));
      }
    }
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[r].length; c++) {
        char digit = board[r][c];
        if ('.' == digit) {
          continue;
        }
        chars.get("r" + r).remove(digit);
        chars.get("c" + c).remove(digit);
        chars.get("r" + r / 3 + "/c" + c / 3).remove(digit);
      }
    }
    backtrack(board, chars, 0);
  }

  private boolean backtrack(char[][] board, Map<String, Set<Character>> chars, int index) {
    if (index == board.length * board[0].length) {
      return true;
    }
    int row = index / 9;
    int col = index % 9;
    if (board[row][col] != '.') {
      return backtrack(board, chars, index + 1);
    }
    Set<Character> rc = chars.get("r" + row);
    Set<Character> cc = chars.get("c" + col);
    Set<Character> sc = chars.get("r" + row / 3 + "/c" + col / 3);
    Set<Character> next = rc;
    if (cc.size() < next.size()) {
      next = cc;
    }
    if (sc.size() < next.size()) {
      next = sc;
    }
    if (next.isEmpty()) {
      return false;
    }
    next = new HashSet<>(next);
    for (char digit : next) {
      if (!(rc.contains(digit) && cc.contains(digit) && sc.contains(digit))) {
        continue;
      }
      rc.remove(digit);
      cc.remove(digit);
      sc.remove(digit);
      board[row][col] = digit;
      if (backtrack(board, chars, index + 1)) {
        return true;
      }
      board[row][col] = '.';
      sc.add(digit);
      cc.add(digit);
      rc.add(digit);
    }
    return false;
  }
  // end::answer[]

  static void main() {
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
    new _0037_SudokuSolver_5().solveSudoku(borad);
  }

}
