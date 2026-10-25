package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0098_ValidateBinarySearchTree_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-10-25 22:32:19
   */
  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean isValidBST(TreeNode root, long min, long max) {
    if (root == null) {
      return true;
    }
    return min < root.val && root.val < max
      && isValidBST(root.left, min, root.val)
      && isValidBST(root.right, root.val, max);
  }
  // end::answer[]
}
