package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

public class _0101_SymmetricTree_2 {
  // tag::answer[]
  public boolean isSymmetric(TreeNode root) {
    return root == null || isSymmetric(root.left, root.right);
  }

  private boolean isSymmetric(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }
    // 前面已经判断都为null的情况了，
    // 这里为了简单，只需要判断一个不为空即可
    if (left == null
      || right == null
      || left.val != right.val) {
      return false;
    }
    // 使用 && 会自动中断后续的递归判断
    return isSymmetric(left.left, right.right)
      && isSymmetric(left.right, right.left);
  }

  // end::answer[]
}
