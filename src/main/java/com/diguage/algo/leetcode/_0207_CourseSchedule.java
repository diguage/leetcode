package com.diguage.algo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * = 207. Course Schedule
 *
 * https://leetcode.com/problems/course-schedule/[Course Schedule - LeetCode]
 *
 * There are a total of n courses you have to take, labeled from `0` to `n-1`.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: `[0,1]`
 *
 * Given the total number of courses and a list of prerequisite *pairs*, is it possible for you to finish all courses?
 *
 * .Example 1:
 * [source]
 * ----
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 * ----
 *
 * *Note:*
 *
 * * The input prerequisites is a graph represented by *a list of edges*, not adjacency matrices. Read more about https://www.khanacademy.org/computing/computer-science/algorithms/graph-representation/a/representing-graphs[how a graph is represented].
 * * You may assume that there are no duplicate edges in the input prerequisites.
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-26 16:36
 */
public class _0207_CourseSchedule {
  // tag::answer[]
    /**
     * Runtime: 20 ms, faster than 36.81% of Java online submissions for Course Schedule.
     *
     * Memory Usage: 74.1 MB, less than 5.39% of Java online submissions for Course Schedule.
     *
     * Copy from: https://leetcode.com/problems/course-schedule/discuss/58516/Easy-BFS-Topological-sort-Java[Easy BFS Topological sort, Java - LeetCode Discuss]
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        for (int[] prere : prerequisites) {
            int latter = prere[0];
            int formmer = prere[1];
            matrix[formmer][latter]++;
            indegree[latter]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            Integer course = queue.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return count == numCourses;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0207_CourseSchedule solution = new _0207_CourseSchedule();
        int[][] p1 = {{1, 0}};
        boolean r1 = solution.canFinish(2, p1);
        System.out.println(r1);

        int[][] p2 = {{1, 0}, {0, 1}};
        boolean r2 = solution.canFinish(2, p2);
        System.out.println(!r2);
    }
}
