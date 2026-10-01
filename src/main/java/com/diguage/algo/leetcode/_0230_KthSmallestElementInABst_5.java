package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0230_KthSmallestElementInABst_5 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-10-01 23:01:53
   */
  public int kthSmallest(TreeNode root, int k) {
    TreeNode curr = root;
    while (curr != null) {
      TreeNode mostRight = curr.left;
      if (mostRight != null) {
        while (mostRight.right != null && mostRight.right != curr) {
          mostRight = mostRight.right;
        }
        if (mostRight.right == null) {
          mostRight.right = curr;
          curr = curr.left;
          continue;
        } else {
          mostRight.right = null;
        }
      }
      k--;
      if (k == 0) {
        return curr.val;
      }
      curr = curr.right;
    }
    return -1;
  }
  // end::answer[]
}
