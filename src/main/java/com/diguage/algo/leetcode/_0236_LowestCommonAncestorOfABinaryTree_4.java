package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0236_LowestCommonAncestorOfABinaryTree_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-10 21:09:37
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    if (root.val == p.val || root.val == q.val) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left != null && right != null) {
      return root;
    } else {
      return left != null ? left : right;
    }
  }
  // end::answer[]
}
