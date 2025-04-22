package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0530_MinimumAbsoluteDifferenceInBst_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-06-26 17:07:39
   */
  public int getMinimumDifference(TreeNode root) {
    int result = Integer.MAX_VALUE;
    TreeNode prev = null;
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
      if (prev != null) {
        result = Math.min(result, curr.val - prev.val);
      }
      prev = curr;
      curr = curr.right;
    }

    return result;
  }
  // end::answer[]
}
