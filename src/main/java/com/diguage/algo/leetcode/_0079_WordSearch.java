package com.diguage.algo.leetcode;

import java.util.Objects;

/**
 * = 79. Word Search
 *
 * https://leetcode.com/problems/word-search/[Word Search - LeetCode]
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * .Example:
 * [source]
 * ----
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-03 17:31
 */
public class _0079_WordSearch {
  // tag::answer[]

    /**
     * Runtime: 4 ms, faster than 89.90% of Java online submissions for Word Search.
     *
     * Memory Usage: 38.4 MB, less than 97.96% of Java online submissions for Word Search.
     *
     * Copy from: https://leetcode.com/problems/word-search/discuss/27658/Accepted-very-short-Java-solution.-No-additional-space.[Accepted very short Java solution. No additional space. - LeetCode Discuss]
     */
    public boolean exist(char[][] board, String word) {
        if (Objects.isNull(board) || board.length == 0) {
            return false;
        }
        if (Objects.isNull(word) || word.length() == 0) {
            return false;
        }
        char[] chars = word.toCharArray();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (exist(board, y, x, chars, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) {
            return true;
        }
        if (y < 0 || x < 0 || y == board.length || x == board[y].length) {
            return false;
        }
        if (board[y][x] != word[i]) {
            return false;
        }
        board[y][x] = Character.MAX_VALUE;
        boolean existable = exist(board, y - 1, x, word, i + 1)
                || exist(board, y, x + 1, word, i + 1)
                || exist(board, y + 1, x, word, i + 1)
                || exist(board, y, x - 1, word, i + 1);
        board[y][x] = word[i];
        return existable;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0079_WordSearch solution = new _0079_WordSearch();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String w1 = "ABCCED";
        boolean r1 = solution.exist(board, w1);
        System.out.println((r1) + " : " + r1);

        String w2 = "SEE";
        boolean r2 = solution.exist(board, w2);
        System.out.println((r2) + " : " + r2);

        String w3 = "ABCB";
        boolean r3 = solution.exist(board, w3);
        System.out.println((!r3) + " : " + r3);
    }
}
