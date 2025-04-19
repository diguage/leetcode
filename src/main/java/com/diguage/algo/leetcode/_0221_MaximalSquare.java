package com.diguage.algo.leetcode;

import java.util.Objects;

/**
 * = 221. Maximal Square
 *
 * https://leetcode.com/problems/maximal-square/[Maximal Square - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-28 12:21
 */
public class _0221_MaximalSquare {
  // tag::answer[]

    /**
     * Runtime: 4 ms, faster than 95.17% of Java online submissions for Maximal Square.
     * Memory Usage: 43.3 MB, less than 91.18% of Java online submissions for Maximal Square.
     *
     * Copy from: https://leetcode.com/problems/maximal-square/solution/[Maximal Square solution - LeetCode]
     *
     * @author D瓜哥 · https://www.diguage.com
     * @since 2020-01-28 12:21
     */
    public int maximalSquare(char[][] matrix) {
        if (Objects.isNull(matrix) || matrix.length == 0) {
            return 0;
        }
        int yLength = matrix.length;
        int xLength = matrix[0].length;
        int[] dp = new int[xLength + 1];
        int maxSideLength = 0;
        int previous = 0;
        for (int y = 1; y <= yLength; y++) {
            for (int x = 1; x <= xLength; x++) {
                int temp = dp[x];
                if (matrix[y - 1][x - 1] == '1') {
                    dp[x] = Math.min(Math.min(previous, dp[x]), dp[x - 1]) + 1;
                    maxSideLength = Math.max(maxSideLength, dp[x]);
                } else {
                    dp[x] = 0;
                }
                previous = temp;
            }
        }

        return maxSideLength * maxSideLength;
    }

    /**
     * Runtime: 13 ms, faster than 8.65% of Java online submissions for Maximal Square.
     * Memory Usage: 43.9 MB, less than 64.71% of Java online submissions for Maximal Square.
     *
     * Copy from: https://leetcode.com/problems/maximal-square/solution/[Maximal Square solution - LeetCode]
     */
    public int maximalSquareMatrix(char[][] matrix) {
        if (Objects.isNull(matrix) || matrix.length == 0) {
            return 0;
        }
        int yLength = matrix.length;
        int xLength = matrix[0].length;
        int[][] dp = new int[yLength + 1][xLength + 1];
        int maxSideLength = 0;
        for (int y = 1; y <= yLength; y++) {
            for (int x = 1; x <= xLength; x++) {
                if (matrix[y - 1][x - 1] == '1') {
                    dp[y][x] = Math.min(Math.min(dp[y - 1][x - 1], dp[y - 1][x]), dp[y][x - 1]) + 1;
                    maxSideLength = Math.max(maxSideLength, dp[y][x]);
                }
            }
        }

        return maxSideLength * maxSideLength;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0221_MaximalSquare solution = new _0221_MaximalSquare();
        char[][] m1 = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        int r1 = solution.maximalSquare(m1);
        System.out.println((r1 == 4) + " : " + r1);
    }
}
