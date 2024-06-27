package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.Arrays;
import java.util.Objects;

import static com.diguage.util.TreeNodes.buildTree;

/**
 * = 104. Maximum Depth of Binary Tree
 *
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/[Maximum Depth of Binary Tree - LeetCode]
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * *Note:* A leaf is a node with no children.
 *
 * *Example:*
 *
 * Given binary tree `[3,9,20,null,null,15,7]`,
 *
 * ----
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * ----
 *
 * return its depth = 3.
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-24 22:17
 */
public class _0104_MaximumDepthOfBinaryTree {

    /**
     * Runtime: 1 ms, faster than 14.28% of Java online submissions for Maximum Depth of Binary Tree.
     *
     * Memory Usage: 40.7 MB, less than 5.38% of Java online submissions for Maximum Depth of Binary Tree.
     */
    public int maxDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int left = 0;
        if (Objects.nonNull(root.left)) {
            left = maxDepth(root.left);
        }
        int right = 0;
        if (Objects.nonNull(root.right)) {
            right = maxDepth(root.right);
        }
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        _0104_MaximumDepthOfBinaryTree solution = new _0104_MaximumDepthOfBinaryTree();
        int r1 = solution.maxDepth(buildTree(Arrays.asList(3, 9, 20, null, null, 15, 7)));
        System.out.println((r1 == 3) + " : " + r1);
    }
}
