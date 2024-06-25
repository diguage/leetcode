package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.*;

import static com.diguage.algorithm.util.TreeNodeUtils.buildTree;

/**
 * = 103. Binary Tree Zigzag Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/[Binary Tree Zigzag Level Order Traversal - LeetCode]
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
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
 * return its zigzag level order traversal as:
 *
 * ----
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-24 21:12
 */
public class _0103_BinaryTreeZigzagLevelOrderTraversal {

    /**
     * Runtime: 1 ms, faster than 75.19% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
     *
     * Memory Usage: 41.5 MB, less than 5.77% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        boolean isReverse = false;
        while (!level.isEmpty()) {
            List<TreeNode> temp = new ArrayList<>();
            List<Integer> values = new ArrayList<>(level.size());
            for (TreeNode node : level) {
                if (isReverse) {
                    values.add(0, node.val);
                } else {
                    values.add(node.val);
                }
                if (Objects.nonNull(node.left)) {
                    temp.add(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    temp.add(node.right);
                }
            }
            result.add(values);
            level = temp;
            isReverse = !isReverse;
        }
        return result;
    }

    public static void main(String[] args) {
        _0103_BinaryTreeZigzagLevelOrderTraversal solution = new _0103_BinaryTreeZigzagLevelOrderTraversal();
        List<List<Integer>> r2 = solution.zigzagLevelOrder(buildTree(Arrays.asList(1, 2, 3, 4, null, null, 5)));
        System.out.println(r2);

        List<List<Integer>> r1 = solution.zigzagLevelOrder(buildTree(Arrays.asList(3, 9, 20, null, null, 15, 7)));
        System.out.println(r1);
    }
}
