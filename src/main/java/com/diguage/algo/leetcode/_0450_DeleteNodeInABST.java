package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0450_DeleteNodeInABST {
  // tag::answer[]
  /**
   * 参考 https://leetcode.cn/problems/delete-node-in-a-bst/solutions/1529700/shan-chu-er-cha-sou-suo-shu-zhong-de-jie-n6vo/[450. 删除二叉搜索树中的节点 - 官方题解^]
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-06-26 20:35
   */
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    if (key < root.val) {
      root.left = deleteNode(root.left, key);
      return root;
    }
    if (root.val < key) {
      root.right = deleteNode(root.right, key);
      return root;
    }
    if (root.val == key) {
      if (root.left == null && root.right == null) {
        return null;
      }
      if (root.left == null) {
        return root.right;
      }
      if (root.right == null) {
        return root.left;
      }
      TreeNode successor = root.right;
      while (successor.left != null) {
        successor = successor.left;
      }
      root.right = deleteNode(root.right, successor.val);
      // 注意“嫁接”左右子树
      successor.right = root.right;
      successor.left = root.left;
      return successor;
    }
    return root;
  }
  // end::answer[]
}
