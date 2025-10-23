package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.Objects;

public class _0236_LowestCommonAncestorOfABinaryTree_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-23 20:52:53
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (Objects.isNull(root) || root == p || root == q) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    // 左右子树返回值都不为空，则 p 和 q 分别在左右子树上
    if (left != null && right != null) {
      return root;
    }
    // 如果只有左子树找到，就返回左子树的返回值
    // 如果只有右子树找到，就返回右子树的返回值
    // 如果左右子树都没有找到，就返回 null（注意此时 right = null）
    return left != null ? left : right;
  }
  // end::answer[]
}
