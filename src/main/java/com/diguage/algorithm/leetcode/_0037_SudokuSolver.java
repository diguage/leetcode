package com.diguage.algorithm.leetcode;

import com.diguage.util.Printers;

/**
 * = 37. Sudoku Solver
 *
 * https://leetcode.com/problems/sudoku-solver/[(5) Sudoku Solver - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-03-25 09:34
 */
public class _0037_SudokuSolver {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0);
    }

    /**
     * Runtime: 17 ms, faster than 35.23% of Java online submissions for Sudoku Solver.
     * Memory Usage: 37 MB, less than 21.05% of Java online submissions for Sudoku Solver.
     */
    private boolean backtrack(char[][] board, int step) {
        int len = board.length;
        if (step == len * len) {
            return true;
        }
        int y = step / len;
        int x = step % len;

        for (int i = y; i < len; i++) {
            for (int j = x; j < len; j++) {
                if (board[i][j] != '.') {
                    return backtrack(board, step + 1);
                }
                for (char c = '1'; c <= '9'; c++) {
                    if (!isValid(board, i, j, c)) {
                        continue;
                    }
                    board[i][j] = c;
                    System.out.printf("y=%d,x=%d, num=%s, step=%d %n",
                            y, x, c, step);
                    Printers.printMatrix(board);
                    if (backtrack(board, step + 1)) {
                        return true;
                    }
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int y, int x, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[(y / 3) * 3 + i / 3][(x / 3) * 3 + i % 3] == c
                    || board[y][i] == c
                    || board[i][x] == c) {
                return false;
            }
        }
        return true;
    }

    /**
     * Copy From
     */
    private boolean backtrackXY(char[][] board, int y, int x) {
        int len = board.length;
        if (x == len) {
            return backtrackXY(board, y + 1, 0);
        }
        if (y == len) {
            return true;
        }
        for (int i = y; i < len; i++) {
            for (int j = x; j < len; j++) {
                if (board[i][j] != '.') {
                    return backtrackXY(board, i, j + 1);
                }
                for (char c = '1'; c <= '9'; c++) {
                    if (!isValid(board, i, j, c)) {
                        continue;
                    }
                    board[i][j] = c;
                    System.out.printf("y=%d,x=%d, num=%s %n", i, j, c);
                    Printers.printMatrix(board);
                    if (backtrackXY(board, i, j + 1)) {
                        return true;
                    }
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] b1 = {
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
        _0037_SudokuSolver solution = new _0037_SudokuSolver();
        Printers.printMatrix(b1);
        solution.solveSudoku(b1);
        Printers.printMatrix(b1);
    }
}
