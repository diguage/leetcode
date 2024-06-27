package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.Objects;

import static com.diguage.util.TreeNodes.*;
import static java.util.Arrays.*;

/**
 * = 112. Path Sum
 *
 * https://leetcode.com/problems/path-sum/[Path Sum - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-07 21:53
 */
public class _0112_PathSum {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Path Sum.
     * Memory Usage: 39.1 MB, less than 5.88% of Java online submissions for Path Sum.
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (Objects.isNull(root)) {
            return false;
        }
        sum -= root.val;
        if (  Objects.isNull(root.left) && Objects.isNull(root.right)) {
            return sum == 0;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    public static void main(String[] args) {
        _0112_PathSum solution = new _0112_PathSum();
        boolean r1 = solution.hasPathSum(buildTree(asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1)), 22);
        System.out.println(r1);
    }
}
