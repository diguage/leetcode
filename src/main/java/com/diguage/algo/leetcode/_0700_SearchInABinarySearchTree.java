package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0700_SearchInABinarySearchTree {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-06-26 14:34:18
   */
  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return null;
    }
    if (root.val == val) {
      return root;
    }
    return searchBST(val > root.val ? root.right : root.left, val);
  }
  // end::answer[]
}
