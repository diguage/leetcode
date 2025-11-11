package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.Arrays;

public class _0114_FlattenBinaryTreeToLinkedList_6 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-11 20:07:06
   */
  private TreeNode head;

  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    flatten(root.right);
    flatten(root.left);
    root.left = null;
    root.right = head;
    head = root;
  }

  // end::answer[]
  static void main() {
    new _0114_FlattenBinaryTreeToLinkedList_6()
      .flatten(TreeNodes.buildTree(Arrays.asList(1, 2, 5, 3, 4, null, 6)));
  }
}
