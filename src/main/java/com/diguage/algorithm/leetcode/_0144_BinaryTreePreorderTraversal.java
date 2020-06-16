package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * = 144. Binary Tree Preorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-preorder-traversal/[Binary Tree Preorder Traversal - LeetCode]
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-06-16 10:59
 */
public class _0144_BinaryTreePreorderTraversal {

  /**
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
   * Memory Usage: 37.4 MB, less than 92.86% of Java online submissions for Binary Tree Preorder Traversal.
   */
  public List<Integer> preorderTraversal(TreeNode root) {
    if (Objects.isNull(root)) {
      return Collections.emptyList();
    }
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    List<Integer> result = new LinkedList<>();
    while (!stack.empty()) {
      TreeNode node = stack.pop();
      result.add(node.val);
      if (Objects.nonNull(node.right)) {
        stack.push(node.right);
      }
      if (Objects.nonNull(node.left)) {
        stack.push(node.left);
      }
    }
    return result;
  }
}
