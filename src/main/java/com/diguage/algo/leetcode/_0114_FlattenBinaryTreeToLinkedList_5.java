package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

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
    Deque<TreeNode> stack = new LinkedList<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      // 直接判断 node.left 是否为 null，代码更简洁
      if (node.left != null) {
        TreeNode mostRight = mostRight(node.left);
        mostRight.right = node.right;
        node.right = node.left;
        node.left = null;
      }
      if (node.right != null) {
        stack.push(node.right);
      }
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
