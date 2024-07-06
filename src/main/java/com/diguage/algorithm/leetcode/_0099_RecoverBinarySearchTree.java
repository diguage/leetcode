package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-23 22:21:59
 */
public class _0099_RecoverBinarySearchTree {
  // tag::answer[]
  /**
   * 使用 Morris 遍历找出错误节点，然后交换其值
   */
  public void recoverTree(TreeNode root) {
    if (root == null) return;
    TreeNode curr = root;
    TreeNode mostRight = null;
    TreeNode[] errorNodes = new TreeNode[2];
    TreeNode prior = null;
    while (curr != null) {
      mostRight = curr.left;
      if (mostRight != null) {
        while (mostRight.right != null && mostRight.right != curr) {
          mostRight = mostRight.right;
        }
        if (mostRight.right == null) {
          mostRight.right = curr;
          curr = curr.left;
          continue;
        } else {
          mostRight.right = null;
        }
      }
      if (prior != null) {
        if (prior.val > curr.val) {
          if (errorNodes[0] == null) {
            errorNodes[0] = curr;
            errorNodes[1] = prior;
          } else {
            errorNodes[0] = curr;
          }
        }
      }
      prior = curr;
      curr = curr.right;
    }
    int temp = errorNodes[0].val;
    errorNodes[0].val = errorNodes[1].val;
    errorNodes[1].val = temp;
  }
  // end::answer[]
}
