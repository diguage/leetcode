package com.diguage.algorithm.ciqas;

import java.util.Objects;

/**
 * {@link com.diguage.algorithm.leetcode._0079_WordSearch}
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-04-26 09:44
 */
public class Test12 {
    public boolean exist(char[][] board, String word) {
        if (Objects.isNull(board) || board.length == 0 || board[0].length == 0) {
            return false;
        }
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (exist(board, word, y, x, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int y, int x, int index) {
        if (index == word.length()) {
            return true;
        }
        if (y < 0 || y == board.length || x < 0 || x == board[0].length) {
            return false;
        }
        if (board[y][x] != word.charAt(index)) {
            return false;
        }
        board[y][x] = Character.MAX_VALUE;
        boolean existable = exist(board, word, y - 1, x, index + 1)
                || exist(board, word, y, x + 1, index + 1)
                || exist(board, word, y + 1, x, index + 1)
                || exist(board, word, y, x - 1, index + 1);
        board[y][x] = word.charAt(index);
        return existable;
    }

    public static void main(String[] args) {
        Test12 test = new Test12();
        char[][] board = {
                {'a', 'b', 'c', 'e'},
                {'s', 'f', 'c', 's'},
                {'a', 'd', 'e', 'e'}
        };
        System.out.println(test.exist(board, "abcced"));
    }
}
