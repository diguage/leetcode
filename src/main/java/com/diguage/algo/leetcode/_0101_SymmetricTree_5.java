package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.Objects;

public class _0101_SymmetricTree_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-10-24 22:19:57
   */
  public boolean isSymmetric(TreeNode root) {
    return dfs(root.left, root.right);
  }

  private boolean dfs(TreeNode left, TreeNode right) {
    if (Objects.isNull(left) && Objects.isNull(right)) {
      return true;
    } else if (Objects.isNull(left) || Objects.isNull(right) || left.val != right.val) {
      return false;
    }
    return dfs(left.left, right.right) && dfs(left.right, right.left);
  }
  // end::answer[]
}
