package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.*;

public class _0145_BinaryTreePostorderTraversal_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-07 07:48:14
   */
  public List<Integer> postorderTraversal(TreeNode root) {
    if (null == root) {
      return Collections.emptyList();
    }
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode peek = stack.peek();
      if (peek.left == null && peek.right == null) {
        stack.pop();
        result.add(peek.val);
      } else if (peek.left != null) {
        TreeNode left = peek.left;
        peek.left = null;
        stack.push(left);
      }else {
        TreeNode right = peek.right;
        peek.right = null;
        stack.push(right);
      }
    }
    return result;
  }
  // end::answer[]
}
