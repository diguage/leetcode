package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.Objects;

public class _0226_InvertBinaryTree_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-26 20:41:17
   */
  public TreeNode invertTree(TreeNode root) {
    if (Objects.isNull(root)) {
      return root;
    }
    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);
    root.left = right; // 交换左右子树
    root.right = left;
    return root;
  }
  // end::answer[]

}
