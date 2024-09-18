package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.Objects;

import static com.diguage.util.TreeNodes.buildTree;
import static java.util.Arrays.asList;

/**
 * = 110. Balanced Binary Tree
 *
 * https://leetcode.com/problems/balanced-binary-tree/[LeetCode - Balanced Binary Tree]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-06 23:10
 */
public class _0110_BalancedBinaryTree {
  // tag::answer[]

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Balanced Binary Tree.
     * Memory Usage: 41.4 MB, less than 11.11% of Java online submissions for Balanced Binary Tree.
     *
     * @author D瓜哥 · https://www.diguage.com
     * @since 2020-02-06 23:10
     */
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int left = depth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = depth(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0110_BalancedBinaryTree solution = new _0110_BalancedBinaryTree();
        System.out.println(!solution.isBalanced(buildTree(asList(1, 2, 2, 3, null, null, 3, 4, null, null, 4))));
        System.out.println(solution.isBalanced(buildTree(asList(3, 9, 20, null, null, 15, 7))));
        System.out.println(!solution.isBalanced(buildTree(asList(1, 2, 2, 3, 3, null, null, 4, 4))));
    }
}
