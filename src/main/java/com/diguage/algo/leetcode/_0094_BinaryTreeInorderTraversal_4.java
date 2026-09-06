package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _0094_BinaryTreeInorderTraversal_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-06 21:39:41
   */
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode curr = root;
    while (curr != null || !stack.isEmpty()) {
      if (curr != null) {
        stack.push(curr);
        TreeNode left = curr.left;
        curr.left = null;
        curr = left;
      } else {
        curr = stack.pop();
        result.add(curr.val);
        TreeNode right = curr.right;
        curr.right = null;
        curr = right;
      }
    }
    return result;
  }
  // end::answer[]
}
