package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import static com.diguage.algorithm.util.JsonUtils.toJson;

/**
 * = 106. Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/[Construct Binary Tree from Inorder and Postorder Traversal - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-06 21:56
 */
public class _0106_ConstructBinaryTreeFromInorderAndPostorderTraversal {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
     * Memory Usage: 41.3 MB, less than 14.54% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int instart, int inend, int postend) {
        if (postend < 0 || instart > inend) {
            return null;
        }
        int val = postorder[postend];
        int index = inend;
        for (; index >= instart; index--) {
            if (inorder[index] == val) {
                break;
            }
        }
        TreeNode result = new TreeNode(val);
        result.left = buildTree(inorder, postorder, instart, index - 1, postend - (inend - index) - 1);
        result.right = buildTree(inorder, postorder, index + 1, inend, postend - 1);
        return result;
    }

    public static void main(String[] args) {
        _0106_ConstructBinaryTreeFromInorderAndPostorderTraversal
                solution = new _0106_ConstructBinaryTreeFromInorderAndPostorderTraversal();
        TreeNode r1 = solution.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(toJson(r1));
    }
}
