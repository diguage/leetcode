package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.Objects;

public class _0572_SubtreeOfAnotherTree {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-20 21:13:02
   */
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (Objects.isNull(root)) {
      return false;
    }
    return isSameTree(root, subRoot)
      || isSubtree(root.left, subRoot)
      || isSubtree(root.right, subRoot);
  }

  private boolean isSameTree(TreeNode a, TreeNode b) {
    if (Objects.isNull(a) || Objects.isNull(b)) {
      return a == b;
    }
    return a.val == b.val
      && isSameTree(a.left, b.left)
      && isSameTree(a.right, b.right);
  }
  // end::answer[]
}
