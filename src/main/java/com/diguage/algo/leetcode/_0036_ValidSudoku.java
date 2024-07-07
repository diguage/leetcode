package com.diguage.algo.leetcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * = 36. Valid Sudoku
 *
 * https://leetcode.com/problems/valid-sudoku/[Valid Sudoku - LeetCode]
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated *according to the following rules:*
 *
 * . Each row must contain the digits `1-9` without repetition.
 * . Each column must contain the digits `1-9` without repetition.
 * . Each of the 9 3x3 sub-boxes of the grid must contain the digits `1-9` without repetition.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character `'.'`.
 *
 * ----
 *
 * .Example 1:
 * [source]
 * ----
 * Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 *     modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * ----
 *
 * *Note:*
 *
 * * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * * Only the filled cells need to be validated according to the mentioned rules.
 * * The given board contain only digits `1-9` and the character `'.'`.
 * * The given board size is always 9x9.
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-06 12:24
 */
public class _0036_ValidSudoku {
  // tag::answer[]
    /**
     * Runtime: 5 ms, faster than 21.21% of Java online submissions for Valid Sudoku.
     *
     * Memory Usage: 43.2 MB, less than 95.65% of Java online submissions for Valid Sudoku.
     *
     * Copy from: https://leetcode.com/problems/valid-sudoku/discuss/15472/Short%2BSimple-Java-using-Strings[Short+Simple Java using Strings - LeetCode Discuss]
     */
    public boolean isValidSudoku(char[][] board) {
        Set<String> numbers = new HashSet<>(board.length * board.length);
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (!Objects.equals(board[y][x], '.')) {
                    String value = "(" + board[y][x] + ")";
                    if (!numbers.add(y + value)
                            || !numbers.add(value + x)
                            || !numbers.add(y / 3 + value + x / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0036_ValidSudoku solution = new _0036_ValidSudoku();
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
        boolean r1 = solution.isValidSudoku(b1);
        System.out.println(r1);

        char[][] b2 = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean r2 = solution.isValidSudoku(b2);
        System.out.println(!r2);
    }
}
