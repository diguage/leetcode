package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.*;

import static com.diguage.algorithm.util.TreeNodeUtils.buildTree;

/**
 * = 102. Binary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/[Binary Tree Level Order Traversal - LeetCode]
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
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
 * return its level order traversal as:
 *
 * ----
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-24 20:40
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * Runtime: 3 ms, faster than 5.15% of Java online submissions for Binary Tree Level Order Traversal.
     *
     * Memory Usage: 40.2 MB, less than 5.33% of Java online submissions for Binary Tree Level Order Traversal.
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();

        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        while (!level.isEmpty()) {
            List<TreeNode> temp = new ArrayList<>();
            List<Integer> values = new ArrayList<>(level.size());
            for (TreeNode node : level) {
                values.add(node.val);
                if (Objects.nonNull(node.left)) {
                    temp.add(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    temp.add(node.right);
                }
            }
            result.add(values);
            level = temp;
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> r1 = solution.levelOrder(buildTree(Arrays.asList(3, 9, 20, null, null, 15, 7)));
        System.out.println(r1);
    }
}
