package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0110_BalancedBinaryTree_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-18 22:28:21
   */
  public boolean isBalanced(TreeNode root) {
    return dfs(root) >= 0;
  }

  private int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = dfs(root.left);
    if (left < 0) {
      return left;
    }
    int right = dfs(root.right);
    if (right < 0) {
      return right;
    }
    return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
  }
  // end::answer[]
}
