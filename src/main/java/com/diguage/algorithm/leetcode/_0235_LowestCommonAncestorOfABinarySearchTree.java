package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-24 18:21:20
 */
public class _0235_LowestCommonAncestorOfABinarySearchTree {
  /**
   * 要充分利用二叉搜索树的特性
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode result = root;
    while (result != null) {
      if (p.val < result.val && q.val < result.val) {
        root = root.left;
      } else if (p.val > result.val && q.val > result.val) {
        result = result.right;
      } else {
        break;
      }
    }
    return result;
  }
}
