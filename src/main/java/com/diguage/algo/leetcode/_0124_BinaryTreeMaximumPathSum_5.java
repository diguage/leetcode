package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.Objects;

public class _0124_BinaryTreeMaximumPathSum_5 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-10-17 23:27:47
   */
  int result = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    dfs(root);
    return result;
  }

  private int dfs(TreeNode root) {
    if (Objects.isNull(root)) {
      return 0;
    }
    int left = dfs(root.left);
    int right = dfs(root.right);
    result = Math.max(result, Math.max(0, left) + Math.max(0, right) + root.val);
    return root.val + Math.max(0, Math.max(left, right));
  }
  // end::answer[]
}
