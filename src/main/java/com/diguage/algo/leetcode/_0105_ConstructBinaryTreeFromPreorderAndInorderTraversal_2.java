package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0105_ConstructBinaryTreeFromPreorderAndInorderTraversal_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-06-25 11:27
   */
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return buildTree(preorder, inorder, 0, 0, preorder.length);
  }

  private TreeNode buildTree(int[] preorder, int[] inorder, int pre, int in, int length) {
    if (length <= 0) {
      return null;
    }
    int val = preorder[pre];
    TreeNode root = new TreeNode(val);
    int inIdx = in;
    while (inIdx < in + length) {
      if (inorder[inIdx] == val) {
        break;
      }
      inIdx++;
    }
    root.left = buildTree(preorder, inorder, pre + 1, in, inIdx - in);
    root.right = buildTree(preorder, inorder, pre + 1 + (inIdx - in), inIdx + 1, length - 1 - (inIdx - in));
    return root;
  }
  // end::answer[]
}
