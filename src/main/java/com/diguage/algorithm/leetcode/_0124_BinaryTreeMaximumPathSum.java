package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.Arrays;
import java.util.Objects;

import static com.diguage.algorithm.util.TreeNodeUtils.buildTree;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-04-01 23:09
 */
public class _0124_BinaryTreeMaximumPathSum {

    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        suforder(root);
        return result;
    }

    private int suforder(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int right = Math.max(0, suforder(root.right));
        int left = Math.max(0, suforder(root.left));
        result = Math.max(result, left + root.val + right);
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        _0124_BinaryTreeMaximumPathSum solution = new _0124_BinaryTreeMaximumPathSum();
        int r1 = solution.maxPathSum(buildTree(Arrays.asList(1, 2, 3)));
        System.out.println((r1 == 6) + " : " + r1);

        int r2 = solution.maxPathSum(buildTree(Arrays.asList(-10, 9, 20, null, null, 15, 7)));
        System.out.println((r2 == 42) + " : " + r2);
    }
}
