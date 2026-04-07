package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0623_AddOneRowToTree {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-07 20:24:16
   */
  public TreeNode addOneRow(TreeNode root, int val, int depth) {
    if (depth == 1) {
      TreeNode result = new TreeNode(val);
      result.left = root;
      return result;
    }
    dfs(root, val, depth - 1);
    return root;
  }

  private void dfs(TreeNode root, int val, int depth) {
    if (root == null) {
      return;
    }
    if (depth == 1) {
      TreeNode left = new TreeNode(val);
      left.left = root.left;
      root.left = left;
      TreeNode right = new TreeNode(val);
      right.right = root.right;
      root.right = right;
      return;
    }
    dfs(root.left, val, depth - 1);
    dfs(root.right, val, depth - 1);
  }
  // end::answer[]
}
