package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;


public class _0530_MinimumAbsoluteDifferenceInBST {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-06-26 17:07:39
   */
  public int getMinimumDifference(TreeNode root) {
    int result = Integer.MAX_VALUE;
    TreeNode cur = root;
    TreeNode mostRight;
    TreeNode pre = null;
    while (cur != null) {
      mostRight = cur.left;
      if (mostRight != null) {
        while (mostRight.right != null && mostRight.right != cur) {
          mostRight = mostRight.right;
        }
        if (mostRight.right == null) {
          mostRight.right = cur;
          cur = cur.left;
          continue;
        } else {
          mostRight.right = null;
        }
      }
      if (pre != null) {
        result = Math.min(result, cur.val - pre.val);
      }
      pre = cur;
      cur = cur.right;
    }
    return result;
  }
  // end::answer[]
}
