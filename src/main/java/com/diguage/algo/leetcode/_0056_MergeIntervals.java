package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

import static com.diguage.util.Printers.printMatrix;

/**
 * = 56. Merge Intervals
 *
 * https://leetcode.com/problems/merge-intervals/[Merge Intervals - LeetCode]
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * ----
 *
 * *NOTE:* input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2019-10-23 12:27
 */
public class _0056_MergeIntervals {
    // tag::answer[]
    /**
     * @author D瓜哥 · https://www.diguage.com
     * @since 2019-10-23 12:27
     */
    public int[][] merge(int[][] intervals) {
        if (Objects.isNull(intervals) || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (index < 0 || intervals[index][1] < intervals[i][0]) {
                intervals[index + 1] = intervals[i];
                index++;
            } else {
                intervals[index][1] = Math.max(intervals[i][1], intervals[index][1]);
            }
        }
        return Arrays.copyOf(intervals, index + 1);
    }
    // end::answer[]


    public static void main(String[] args) {
        _0056_MergeIntervals solution = new _0056_MergeIntervals();
        int[][] matrix = {{8, 10}, {2, 6}, {15, 18}, {1, 3}};
        printMatrix(matrix);
        int[][] r1 = solution.merge(matrix);
        printMatrix(r1);

        int[][] matrix2 = {{1, 4}, {4, 5}};
        printMatrix(matrix2);
        int[][] r2 = solution.merge(matrix2);
        printMatrix(r2);

        int[][] matrix3 = {{1, 9}, {2, 5}, {19, 20}, {10, 11}, {12, 20}, {0, 3}, {0, 1}, {0, 2}};
        printMatrix(matrix3);
        int[][] r3 = solution.merge(matrix3);
        printMatrix(r3);
    }
}
