package com.diguage.algorithm.leetcode;

/**
 * = 378. Kth Smallest Element in a Sorted Matrix
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/[Kth Smallest Element in a Sorted Matrix - LeetCode]
 *
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * .Example:
 * [source]
 * ----
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * return 13.
 * ----
 *
 * *Note:*
 *
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 *
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-23 18:08
 */
public class _0378_KthSmallestElementInASortedMatrix {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
     *
     * Memory Usage: 56.2 MB, less than 5.41% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
     *
     * Copy from: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code[Share my thoughts and Clean Java Code - LeetCode Discuss]
     */
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0];
        int length = matrix.length;
        int high = matrix[length - 1][length - 1];
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            int j = length - 1;
            for (int i = 0; i < length; i++) {
                while (j >= 0 && mid < matrix[i][j]) {
                    j--;
                }
                count += (j + 1);
            }
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        _0378_KthSmallestElementInASortedMatrix solution = new _0378_KthSmallestElementInASortedMatrix();
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int r1 = solution.kthSmallest(matrix, 8);
        System.out.println((r1 == 13) + " : " + r1);
    }
}
