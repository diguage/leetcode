package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0543_DiameterOfBinaryTree_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-17 22:32:40
   */
  int result = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    dfs(root);
    return result;
  }

  private int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = dfs(root.left);
    int right = dfs(root.right);
    result = Math.max(result, left + right);
    return Math.max(left, right) + 1;
  }
  // end::answer[]
}
