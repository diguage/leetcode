package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0114_FlattenBinaryTreeToLinkedList_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-03 20:38:46
   */
  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    while (root != null) {
      if (root.left != null) {
        TreeNode right = root.left;
        while (right.right != null) {
          right = right.right;
        }
        right.right = root.right;
        root.right = root.left;
        root.left = null;
      }
      root = root.right;
    }
  }
  // end::answer[]
}
