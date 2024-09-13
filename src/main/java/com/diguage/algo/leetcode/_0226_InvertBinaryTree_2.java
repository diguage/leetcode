package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0226_InvertBinaryTree_2 {
  // tag::answer[]
  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
   * Memory Usage: 37.1 MB, less than 5.10% of Java online submissions for Invert Binary Tree.
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-13 23:03:35
   */
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return root;
    }
    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);
    root.left = right;
    root.right = left;
    return root;
  }
  // end::answer[]
}
