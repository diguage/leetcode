package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.JsonUtils;
import com.diguage.algorithm.util.TreeNode;

/**
 * = 105. Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/[Construct Binary Tree from Preorder and Inorder Traversal - LeetCode]
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * *Note:*
 *
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * ----
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * ----
 *
 * Return the following binary tree:
 *
 * ----
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-04 20:25
 */
public class _0105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    /**
     * Runtime: 10 ms, faster than 34.14% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
     *
     * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
     *
     * Copy from: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34538/My-Accepted-Java-Solution[My Accepted Java Solution - LeetCode Discuss]
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, inorder.length);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        int value = preorder[preStart];
        int index = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == value) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(value);
        root.left = build(preorder, inorder, preStart + 1, inStart, index - 1);
        root.right = build(preorder, inorder, preStart + (index - inStart) + 1, index + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        _0105_ConstructBinaryTreeFromPreorderAndInorderTraversal solution = new _0105_ConstructBinaryTreeFromPreorderAndInorderTraversal();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode tree = solution.buildTree(preorder, inorder);
        System.out.println(JsonUtils.toJson(tree));
    }
}
