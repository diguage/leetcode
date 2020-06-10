package com.diguage.algorithm.ciqas;

import com.diguage.algorithm.util.TreeNode;

/**
 * {@link com.diguage.algorithm.leetcode._0105_ConstructBinaryTreeFromPreorderAndInorderTraversal}
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-04-25 20:41
 */
public class Test07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, 0, preorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int index, int start, int end) {
        if (end < start) {
            return null;
        }
        int root = preorder[index];
        TreeNode result = new TreeNode(root);
        int i = start;
        while (inorder[i] != root) {
            i++;
        }
        result.left = buildTree(preorder, inorder, index + 1, start, i - 1);
        result.right = buildTree(preorder, inorder, index + (i - start) + 1, i + 1, end);
        return result;
    }

    public static void main(String[] args) {
        Test07 solution = new Test07();
        TreeNode r1 = solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(r1);
    }
}
