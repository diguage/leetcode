package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-26 14:34:18
 */
public class _0700_SearchInABinarySearchTree {
  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return null;
    }
    if (root.val == val) {
      return root;
    }
    return searchBST(val > root.val ? root.right : root.left, val);
  }
}
