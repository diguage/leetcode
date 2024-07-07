package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-23 23:09:02
 */
public class _0100_SameTree_2 {
  // tag::answer[]
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if ((p == null && q != null)
      || (p != null && q == null)
      || p.val != q.val) {
      return false;
    }
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
  // end::answer[]
}
