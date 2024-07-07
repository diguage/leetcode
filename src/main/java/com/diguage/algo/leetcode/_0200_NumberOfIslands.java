package com.diguage.algo.leetcode;

import java.util.Objects;

/**
 * = 200. Number of Islands
 *
 * Given a 2d grid map of `'1'`s (land) and `'0'`s (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * .Example 1:
 * [source]
 * ----
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-25 23:42
 */
public class _0200_NumberOfIslands {
  // tag::answer[]
    /**
     * Runtime: 1 ms, faster than 99.99% of Java online submissions for Number of Islands.
     *
     * Memory Usage: 42 MB, less than 41.86% of Java online submissions for Number of Islands.
     *
     * Copy from: https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-shu-liang-by-leetcode/[岛屿数量 - 岛屿数量 - 力扣（LeetCode）]
     */
    public int numIslands(char[][] grid) {
        if (Objects.isNull(grid) || grid.length == 0) {
            return 0;
        }
        int yLength = grid.length;
        int xLength = grid[0].length;
        int result = 0;
        for (int y = 0; y < yLength; y++) {
            for (int x = 0; x < xLength; x++) {
                if (grid[y][x] == '1') {
                    result++;
                    dfs(grid, y, x);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int y, int x) {
        int yLength = grid.length;
        int xLength = grid[0].length;
        if (y < 0 || y >= yLength || x < 0 || x >= xLength
                || grid[y][x] == '0') {
            return;
        }
        grid[y][x] = '0';
        dfs(grid, y - 1, x);
        dfs(grid, y + 1, x);
        dfs(grid, y, x - 1);
        dfs(grid, y, x + 1);
    }

  // end::answer[]


    public static void main(String[] args) {
        _0200_NumberOfIslands solution = new _0200_NumberOfIslands();
        char[][] g1 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int r1 = solution.numIslands(g1);
        System.out.println((r1 == 3) + " : " + r1);
    }
}
