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
public class _0114_FlattenBinaryTreeToLinkedList_3rec {
  // tag::answer[]
  /**
   * 递归解决方案
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-06 17:32:56
   */
  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    flatten(root.left);
    flatten(root.right);

    TreeNode left = root.left;
    TreeNode right = root.right;

    root.left = null;
    root.right = left;

    TreeNode mostRight = root;
    while (mostRight.right != null) {
      mostRight = mostRight.right;
    }
    mostRight.right = right;
  }
  // end::answer[]
}
