package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.*;

import static com.diguage.util.TreeNodes.buildTree;
import static java.util.Arrays.asList;

/**
 * = 113. Path Sum II
 *
 * https://leetcode.com/problems/path-sum-ii/[Path Sum II - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-07 22:31
 */
public class _0113_PathSumII {
  // tag::answer[]

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Path Sum II.
     * Memory Usage: 41.8 MB, less than 6.06% of Java online submissions for Path Sum II.
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(root, sum, result, new ArrayDeque<>());
        return result;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> result, Deque<Integer> current) {
        if (Objects.isNull(root)) {
            return;
        }
        sum -= root.val;
        current.addLast(root.val);
        if (sum == 0 && Objects.isNull(root.left) && Objects.isNull(root.right)) {
            result.add(new ArrayList<>(current));
        }
        dfs(root.left, sum, result, current);
        dfs(root.right, sum, result, current);
        current.removeLast();
    }

  // end::answer[]


    public static void main(String[] args) {
        _0113_PathSumII solution = new _0113_PathSumII();
        List<List<Integer>> r1 = solution.pathSum(buildTree(asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1)), 22);
        System.out.println(r1);
    }
}
