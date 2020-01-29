package com.diguage.algorithm.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * = 406. Queue Reconstruction by Height
 *
 * https://leetcode.com/problems/queue-reconstruction-by-height/[Queue Reconstruction by Height - LeetCode]
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-29 17:20
 */
public class QueueReconstructionByHeight {
    /**
     * Runtime: 8 ms, faster than 39.43% of Java online submissions for Queue Reconstruction by Height.
     * Memory Usage: 42.6 MB, less than 89.36% of Java online submissions for Queue Reconstruction by Height.
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> queue = new LinkedList<>();
        for (int[] person : people) {
            queue.add(person[1], person);
        }
        int length = people.length;
        return queue.toArray(new int[length][2]);
    }

    public static void main(String[] args) {
        QueueReconstructionByHeight solution = new QueueReconstructionByHeight();
        int[][] p1 = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] r1 = solution.reconstructQueue(p1);
        System.out.println(Arrays.deepToString(p1));
    }
}
