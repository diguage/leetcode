package com.diguage.algorithm.leetcode;

import java.util.Objects;

/**
 * = 63. Unique Paths II
 *
 * https://leetcode.com/problems/unique-paths-ii/[Unique Paths II - LeetCode]
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * *Note:* m and n will be at most 100.
 *
 * .Example 1:
 * [source]
 * ----
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2019-10-26 23:50
 */
public class _0063_UniquePathsII {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths II.
     * <p>
     * Memory Usage: 40.5 MB, less than 33.84% of Java online submissions for Unique Paths II.
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (Objects.isNull(obstacleGrid)
                || obstacleGrid.length == 0
                || obstacleGrid[0].length == 0
                || obstacleGrid[0][0] == 1) {
            return 0;
        }
        obstacleGrid[0][0] = 1;

        int m = obstacleGrid.length;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) {
                obstacleGrid[i][0] = 1;
            } else {
                obstacleGrid[i][0] = 0;
            }
        }
        int n = obstacleGrid[0].length;
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0 && obstacleGrid[0][j - 1] == 1) {
                obstacleGrid[0][j] = 1;
            } else {
                obstacleGrid[0][j] = 0;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }

    /**
     * Runtime: 1 ms, faster than 23.04% of Java online submissions for Unique Paths II.
     * <p>
     * Memory Usage: 40.5 MB, less than 35.38% of Java online submissions for Unique Paths II.
     */
    public int uniquePathsWithObstaclesMy(int[][] obstacleGrid) {
        if (Objects.isNull(obstacleGrid)
                || obstacleGrid.length == 0
                || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        boolean hasObstacle = false;
        for (int i = 0; i < n; i++) {
            int value = obstacleGrid[0][i];
            if (value == 1) {
                hasObstacle = true;
                obstacleGrid[0][i] = -1;
            } else {
                if (hasObstacle) {
                    obstacleGrid[0][i] = 0;
                } else {
                    obstacleGrid[0][i] = 1;
                }
            }
        }
        hasObstacle = false;
        if (obstacleGrid[0][0] == -1) {
            hasObstacle = true;
        }
        for (int i = 1; i < m; i++) {
            int value = obstacleGrid[i][0];
            if (hasObstacle) {
                obstacleGrid[i][0] = 0;
            }
            if (value == 1) {
                hasObstacle = true;
                obstacleGrid[i][0] = -1;
            } else {
                if (hasObstacle) {
                    obstacleGrid[i][0] = 0;
                } else {
                    obstacleGrid[i][0] = 1;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int value = obstacleGrid[i][j];
                if (value == 1) {
                    obstacleGrid[i][j] = -1;
                } else {
                    int top = obstacleGrid[i - 1][j];
                    if (top == -1) {
                        top = 0;
                    }

                    int left = obstacleGrid[i][j - 1];
                    if (left == -1) {
                        left = 0;
                    }
                    obstacleGrid[i][j] = top + left;
                }
            }
        }
        return Math.max(obstacleGrid[m - 1][n - 1], 0);
    }

    public static void main(String[] args) {
        _0063_UniquePathsII solution = new _0063_UniquePathsII();
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int r1 = solution.uniquePathsWithObstacles(obstacleGrid);
        System.out.println((r1 == 2) + " : " + r1);

        int[][] obstacleGrid2 = {{1}};
        int r2 = solution.uniquePathsWithObstacles(obstacleGrid2);
        System.out.println((r2 == 0) + " : " + r2);

        int[][] obstacleGrid3 = {{1, 1}};
        int r3 = solution.uniquePathsWithObstacles(obstacleGrid3);
        System.out.println((r3 == 0) + " : " + r3);

        int[][] obstacleGrid4 = {{1, 0}};
        int r4 = solution.uniquePathsWithObstacles(obstacleGrid4);
        System.out.println((r4 == 0) + " : " + r4);

        int[][] obstacleGrid5 = {{1}, {0}};
        int r5 = solution.uniquePathsWithObstacles(obstacleGrid5);
        System.out.println((r5 == 0) + " : " + r5);
    }
}
