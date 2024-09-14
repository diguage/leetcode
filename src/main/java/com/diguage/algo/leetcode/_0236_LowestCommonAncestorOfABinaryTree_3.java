package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0236_LowestCommonAncestorOfABinaryTree_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-14 21:42:37
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root.val == p.val || root.val == q.val) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    return left == null ? (right == null ? null : right) : left;
  }
  // end::answer[]
}
