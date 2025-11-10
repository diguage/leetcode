package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.Arrays;

public class _0114_FlattenBinaryTreeToLinkedList_5 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-10 22:50:45
   */
  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    while (root != null) {
      // 直接判断 root.left 是否为 null，代码更简洁
      if (root.left != null) {
        TreeNode mostRight = mostRight(root.left);
        mostRight.right = root.right;
        root.right = root.left;
        root.left = null;
      }
      root = root.right;
    }
  }

  private TreeNode mostRight(TreeNode root) {
    TreeNode result = root;
    while (result != null && result.right != null) {
      result = result.right;
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _0114_FlattenBinaryTreeToLinkedList_5()
      .flatten(TreeNodes.buildTree(Arrays.asList(1, 2, 5, 3, 4, null, 6)));
  }
}
