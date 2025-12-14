package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.Objects;

public class _0124_BinaryTreeMaximumPathSum_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-14 22:15:08
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
    int left = Math.max(0, dfs(root.left));
    int right = Math.max(0, dfs(root.right));
    result = Math.max(result, left + right + root.val);
    return Math.max(left, right) + root.val;
  }
  // end::answer[]
}
