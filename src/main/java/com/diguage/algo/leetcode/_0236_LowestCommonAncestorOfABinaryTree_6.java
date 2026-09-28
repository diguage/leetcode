package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0236_LowestCommonAncestorOfABinaryTree_6 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2020-01-13 20:28
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    return dfs(root, p, q);
  }

  private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    if (root == p || root == q) {
      return root;
    }
    TreeNode left = dfs(root.left, p, q);
    TreeNode right = dfs(root.right, p, q);
    if (left == null) {
      return right;
    }
    if (right == null) {
      return left;
    }
    if (left != right) {
      return root;
    }
    return null;
  }
  // end::answer[]
}

