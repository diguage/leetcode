package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-06 22:14
 */
public class _0094_BinaryTreeInorderTraversal_Recur {
  // tag::answer[]
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    inorderTraversal(root, result);
    return result;
  }

  public void inorderTraversal(TreeNode root, List<Integer> result) {
    if (root == null) {
      return;
    }
    inorderTraversal(root.left, result);
    result.add(root.val);
    inorderTraversal(root.right, result);
  }
  // end::answer[]
}
