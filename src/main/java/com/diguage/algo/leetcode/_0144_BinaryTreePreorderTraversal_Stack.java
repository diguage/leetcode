package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * = 144. Binary Tree Preorder Traversal
 * <p>
 * https://leetcode.com/problems/binary-tree-preorder-traversal/[Binary Tree Preorder Traversal - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-06-16 10:59
 */
public class _0144_BinaryTreePreorderTraversal_Stack {
  // tag::answer[]

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode head = root;
    while (head != null || !stack.isEmpty()) {
      if (head != null) {
        result.add(head.val);
        if (head.right != null) {
          stack.push(head.right);
        }
        head = head.left;
      } else {
        head = stack.pop();
      }
    }
    return result;
  }
  // end::answer[]
}
