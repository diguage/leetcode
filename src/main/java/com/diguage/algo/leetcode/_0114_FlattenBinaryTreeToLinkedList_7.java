package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0114_FlattenBinaryTreeToLinkedList_7 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-10-20 22:44:41
   */
  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.left != null) {
      TreeNode mostRight = root.left;
      while (mostRight.right != null) {
        mostRight = mostRight.right;
      }
      mostRight.right = root.right;
      root.right = root.left;
      root.left = null;
    }
    flatten(root.right);
  }
  // end::answer[]
}
