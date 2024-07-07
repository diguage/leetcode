package com.diguage.algo.leetcode;

import java.util.Objects;

/**
 * = 130. Surrounded Regions
 *
 * https://leetcode.com/problems/surrounded-regions/[Surrounded Regions - LeetCode]
 *
 * Given a 2D board containing `'X'` and `'O'` (the letter O), capture all regions surrounded by `'X'`.
 *
 * A region is captured by flipping all `'O'`s into `'X'`s in that surrounded region.
 *
 * *Example:*
 *
 * ----
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * ----
 *
 * After running your function, the board should be:
 *
 * ----
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * ----
 *
 * *Explanation:*
 *
 * Surrounded regions shouldn’t be on the border, which means that any `'O'` on the border of the board are not flipped to `'X'`. Any `'O'` that is not on the border and it is not connected to an `'O'` on the border will be flipped to `'X'`. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-25 19:57
 */
public class _0130_SurroundedRegions {
  // tag::answer[]
    /**
     * Runtime: 4 ms, faster than 22.25% of Java online submissions for Surrounded Regions.
     *
     * Memory Usage: 49.1 MB, less than 7.14% of Java online submissions for Surrounded Regions.
     *
     * Copy from: https://leetcode-cn.com/problems/surrounded-regions/solution/bfsdi-gui-dfsfei-di-gui-dfsbing-cha-ji-by-ac_pipe/[bfs+递归dfs+非递归dfs+并查集 - 被围绕的区域 - 力扣（LeetCode）]
     */
    public void solve(char[][] board) {
        if (Objects.isNull(board) || board.length == 0) {
            return;
        }

        int yLength = board.length;
        int xLength = board[0].length;
        for (int y = 0; y < yLength; y++) {
            for (int x = 0; x < xLength; x++) {
                boolean isEdge = y == 0 || y == yLength - 1
                        || x == 0 || x == xLength - 1;
                if (isEdge && board[y][x] == 'O') {
                    dfs(board, y, x);
                }
            }
        }

        for (int y = 0; y < yLength; y++) {
            for (int x = 0; x < xLength; x++) {
                if (board[y][x] == 'O') {
                    board[y][x] = 'X';
                }
                if (board[y][x] == '#') {
                    board[y][x] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int y, int x) {
        if (y < 0 || y >= board.length || x < 0 || x >= board[0].length
                || board[y][x] == 'X'
                || board[y][x] == '#') {
            return;
        }
        board[y][x] = '#';
        dfs(board, y - 1, x);
        dfs(board, y + 1, x);
        dfs(board, y, x - 1);
        dfs(board, y, x + 1);
    }


  // end::answer[]


    public static void main(String[] args) {
        _0130_SurroundedRegions solution = new _0130_SurroundedRegions();
    }
}
