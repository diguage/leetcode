package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * = 145. Binary Tree Postorder Traversal
 * <p>
 * https://leetcode.com/problems/binary-tree-postorder-traversal/[Binary Tree Postorder Traversal - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-06-16 11:24
 */
public class _0145_BinaryTreePostorderTraversal_Stack {
  // tag::answer[]

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode prev = null;
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      if (root.right == null || root.right == prev) {
        result.add(root.val);
        prev = root;
        root = null;
      } else {
        stack.push(root);
        root = root.right;
      }
    }
    return result;
  }
  // end::answer[]
}
