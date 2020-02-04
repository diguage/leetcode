package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.JsonUtils;
import com.diguage.algorithm.util.TreeNode;

import java.util.Arrays;
import java.util.Objects;

import static com.diguage.algorithm.util.TreeNodeUtils.buildTree;

/**
 * = 226. Invert Binary Tree
 *
 * https://leetcode.com/problems/invert-binary-tree/[Invert Binary Tree - LeetCode]
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-28 11:33
 */
public class _0226_InvertBinaryTree {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
     * Memory Usage: 37.1 MB, less than 5.10% of Java online submissions for Invert Binary Tree.
     */
    public TreeNode invertTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

    public static void main(String[] args) {
        _0226_InvertBinaryTree solution = new _0226_InvertBinaryTree();
        TreeNode r1 = solution.invertTree(buildTree(Arrays.asList(4, 2, 7, 1, 3, 6, 9)));
        System.out.println(JsonUtils.toJson(r1));
    }
}
