package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.*;

/**
 * = 94. Binary Tree Inorder Traversal
 * <p>
 * https://leetcode.com/problems/binary-tree-inorder-traversal/[Binary Tree Inorder Traversal - LeetCode]
 * <p>
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * .Example:
 * [source]
 * ----
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [1,3,2]
 * ----
 * <p>
 * *Follow up:* Recursive solution is trivial, could you do it iteratively?
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-06 22:14
 */
public class _0094_BinaryTreeInorderTraversal_Stack {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode head = root;
    while (head != null || !stack.isEmpty()) {
      if (head != null) {
        stack.push(head);
        head = head.left;
      } else {
        head = stack.pop();
        result.add(head.val);
        head = head.right;
      }
    }
    return result;
  }
}
