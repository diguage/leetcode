package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0101_SymmetricTree_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-16 17:51:17
   */
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return isSymmetric(root.left, root.right);
  }

  private boolean isSymmetric(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }
    if (left == null
      || right == null
      || left.val != right.val) {
      return false;
    }
    return isSymmetric(left.left, right.right)
      && isSymmetric(left.right, right.left);
  }
  // end::answer[]
}
