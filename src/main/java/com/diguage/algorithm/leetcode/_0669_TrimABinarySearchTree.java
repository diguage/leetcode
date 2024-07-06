package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

public class _0669_TrimABinarySearchTree {
  // tag::answer[]
  /**
   * 参考 https://leetcode.cn/problems/trim-a-binary-search-tree/solutions/1813384/xiu-jian-er-cha-sou-suo-shu-by-leetcode-qe7q1/[669. 修剪二叉搜索树 - 官方题解^]
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-06-26 21:19:52
   */
  public TreeNode trimBST(TreeNode root, int low, int high) {
    if (root == null) {
      return null;
    }
    if (root.val < low) {
      return trimBST(root.right, low, high);
    } else if (high < root.val) {
      return trimBST(root.left, low, high);
    } else {
      root.left = trimBST(root.left, low, high);
      root.right = trimBST(root.right, low, high);
      return root;
    }
  }
  // end::answer[]
}
