package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class _0653_TwoSumIvInputIsABst {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-21 20:30:18
   */
  public boolean findTarget(TreeNode root, int k) {
    return dfs(root, k, new HashSet<>());
  }

  private boolean dfs(TreeNode root, int k, Set<Object> existed) {
    if (Objects.isNull(root)) {
      return false;
    }
    if (existed.contains(k - root.val)) {
      return true;
    }
    existed.add(root.val);
    return dfs(root.left, k, existed) || dfs(root.right, k, existed);
  }
  // end::answer[]
}
