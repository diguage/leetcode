package com.diguage.algorithm.leetcode;

import java.util.Objects;

import static com.diguage.util.Printers.printMatrix;

/**
 * = 289. Game of Life
 *
 * https://leetcode.com/problems/game-of-life/[Game of Life - LeetCode]
 *
 * According to the https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life[Wikipedia's article]:
 * "The **Game of Life**, also known simply as *Life*, is a cellular automaton devised by the
 * British mathematician John Horton Conway in 1970."
 *
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each
 * cell interacts with its https://en.wikipedia.org/wiki/Moore_neighborhood[eight neighbors]
 * (horizontal, vertical, diagonal) using the following four rules (taken from the above
 * Wikipedia article):
 *
 * . Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * . Any live cell with two or three live neighbors lives on to the next generation.
 * . Any live cell with more than three live neighbors dies, as if by over-population..
 * . Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 *
 * Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
 *
 * .Example:
 * [source]
 * ----
 * Input:
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * Output:
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 * ----
 *
 * *Follow up:*
 *
 * . Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
 * . In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2019-10-29 00:01
 */
public class _0289_GameOfLife {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Game of Life.
     *
     * Memory Usage: 35.1 MB, less than 100.00% of Java online submissions for Game of Life.
     */
    public void gameOfLife(int[][] board) {
        if (Objects.isNull(board) || board.length == 0 || board[0].length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = countOfLive(board, i, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int value = 0;
                if (isLive(board, i, j)) {
                    value = 1;
                }
                board[i][j] = value;
            }
        }
    }

    private boolean isLive(int[][] matrix, int i, int j) {
        int value = matrix[i][j];
        if (value == 12 || value == 13 || value == -3) {
            return true;
        } else {
            return false;
        }
    }

    private int countOfLive(int[][] matrix, int i, int j) {
        int count = 0;
        int value = matrix[i][j];
        int iLength = matrix.length;
        int jLength = matrix[0].length;


        if (i - 1 >= 0) {
            if (j - 1 >= 0) {
                count += matrix[i - 1][j - 1] > 0 ? 1 : 0;
            }

            count += matrix[i - 1][j] > 0 ? 1 : 0;

            if (j + 1 < jLength) {
                count += matrix[i - 1][j + 1] > 0 ? 1 : 0;
            }
        }

        if (j - 1 >= 0) {
            count += matrix[i][j - 1] > 0 ? 1 : 0;
        }
        if (j + 1 < jLength) {
            count += matrix[i][j + 1] > 0 ? 1 : 0;
        }

        if (i + 1 < iLength) {
            if (j - 1 >= 0) {
                count += matrix[i + 1][j - 1] > 0 ? 1 : 0;
            }

            count += matrix[i + 1][j] > 0 ? 1 : 0;

            if (j + 1 < jLength) {
                count += matrix[i + 1][j + 1] > 0 ? 1 : 0;
            }
        }

        if (value > 0) {
            return count + 10;
        } else {
            return -count;
        }
    }

    public static void main(String[] args) {
        _0289_GameOfLife solution = new _0289_GameOfLife();
        int[][] matrix = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        printMatrix(matrix);
        solution.gameOfLife(matrix);
        printMatrix(matrix);
    }
}
