package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.Objects;

import static com.diguage.algorithm.util.TreeNodeUtils.buildTree;
import static java.util.Arrays.asList;

/**
 * = 543. Diameter of Binary Tree
 *
 * https://leetcode.com/problems/diameter-of-binary-tree/[Diameter of Binary Tree - LeetCode]
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-29 23:31
 */
public class _0543_DiameterOfBinaryTree {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Diameter of Binary Tree.
     * Memory Usage: 39 MB, less than 19.48% of Java online submissions for Diameter of Binary Tree.
     */
    private int result;
    public int diameterOfBinaryTree(TreeNode root) {
        result = 1;
        dfs(root);
        return result - 1;
    }

    private int dfs(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        result = Math.max(result, left + right + 1);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        _0543_DiameterOfBinaryTree solution = new _0543_DiameterOfBinaryTree();
        int r1 = solution.diameterOfBinaryTree(buildTree(asList(1, 2, 3, 4, 5)));
        System.out.println((r1 == 3) + " : " + r1);
    }
}
