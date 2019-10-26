package com.diguage.algorithm.leetcode;

import java.util.Arrays;

/**
 * = 62. Unique Paths
 *
 * https://leetcode.com/problems/unique-paths/[Unique Paths - LeetCode]
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * *Note:* m and n will be at most 100.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: m = 7, n = 3
 * Output: 28
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2019-10-26 22:56
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[] row = new int[n];
        Arrays.fill(row, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                row[j] = row[j - 1] + row[j];
            }
        }
        return row[n - 1];
    }

    /**
     * timeout
     */
    public int uniquePathsBottomUp(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePathsBottomUp(m - 1, n) + uniquePathsBottomUp(m, n - 1);
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
     * <p>
     * Memory Usage: 33 MB, less than 5.10% of Java online submissions for Unique Paths.
     */
    public int uniquePathsMatrix(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            paths[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            paths[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }
        return paths[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();
        int r1 = solution.uniquePaths(3, 2);
        System.out.println((r1 == 3) + " : " + r1);

        int r2 = solution.uniquePaths(7, 3);
        System.out.println((r2 == 28) + " : " + r2);

        int r3m = solution.uniquePathsMatrix(23, 12);
        System.out.println((r3m == 193536720) + " : " + r3m);

        int r3 = solution.uniquePaths(23, 12);
        System.out.println((r3 == 193536720) + " : " + r3);

        int r4m = solution.uniquePathsMatrix(100, 81);
        System.out.println((r4m == 1780241190) + " : " + r4m);

        int r4 = solution.uniquePaths(100, 81);
        System.out.println((r4 == 1780241190) + " : " + r4);
    }
}
