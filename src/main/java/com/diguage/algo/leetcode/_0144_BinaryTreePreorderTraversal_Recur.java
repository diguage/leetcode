package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * = 144. Binary Tree Preorder Traversal
 * <p>
 * https://leetcode.com/problems/binary-tree-preorder-traversal/[Binary Tree Preorder Traversal - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-14 11:30
 */
public class _0144_BinaryTreePreorderTraversal_Recur {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-06-14 11:30
   */
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    preorderTraversal(root, result);
    return result;
  }

  private void preorderTraversal(TreeNode root, List<Integer> result) {
    if (root == null) {
      return;
    }
    result.add(root.val);
    preorderTraversal(root.left, result);
    preorderTraversal(root.right, result);
  }
  // end::answer[]
}
