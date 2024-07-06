package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

/**
 * = 114. Flatten Binary Tree to Linked List
 *
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/[Flatten Binary Tree to Linked List - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-27 23:18
 */
public class _0114_FlattenBinaryTreeToLinkedList_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-06 17:12:19
   */
  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    while (root != null) {
      if (root.left != null) {
        TreeNode mostRight = root.left;
        while (mostRight.right != null) {
          mostRight = mostRight.right;
        }
        mostRight.right = root.right;
        root.right = root.left;
        root.left = null;
      }
      root = root.right;
    }
  }
  // end::answer[]
}
