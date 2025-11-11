package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0105_ConstructBinaryTreeFromPreorderAndInorderTraversal_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-11 21:37:06
   */
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return dfs(preorder, 0, preorder.length - 1,
      inorder, 0, inorder.length - 1);
  }

  private TreeNode dfs(int[] preorder, int preStart, int preEnd,
                       int[] inorder, int inStart, int inEnd) {
    if (preStart > preEnd || inStart > inEnd) {
      return null;
    }
    int value = preorder[preStart];
    TreeNode root = new TreeNode(value);
    int index = inStart;
    for (; index <= inEnd; index++) {
      if (inorder[index] == value) {
        break;
      }
    }
    root.left = dfs(preorder, preStart + 1, preStart + (index - inStart),
                    inorder, inStart, index - 1);
    root.right = dfs(preorder, preStart + (index - inStart) + 1, preEnd,
                     inorder, index + 1, inEnd);
    return root;
  }
  // end::answer[]
  static void main() {
    new _0105_ConstructBinaryTreeFromPreorderAndInorderTraversal_3()
      .buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
  }
}
