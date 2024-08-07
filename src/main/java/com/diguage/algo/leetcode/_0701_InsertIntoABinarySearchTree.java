package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0701_InsertIntoABinarySearchTree {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-06-26 19:33:15
   */
  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }
    TreeNode curr = root;
    while (curr != null) {
      if (val < curr.val) {
        if (curr.left == null) {
          curr.left = new TreeNode(val);
          break;
        } else {
          curr = curr.left;
        }
      } else {
        if (curr.right == null) {
          curr.right = new TreeNode(val);
          break;
        } else {
          curr = curr.right;
        }
      }
    }
    return root;
  }
  // end::answer[]
}
