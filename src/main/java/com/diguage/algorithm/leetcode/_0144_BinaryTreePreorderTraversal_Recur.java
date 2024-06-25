package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * = 144. Binary Tree Preorder Traversal
 * <p>
 * https://leetcode.com/problems/binary-tree-preorder-traversal/[Binary Tree Preorder Traversal - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-06-16 10:59
 */
public class _0144_BinaryTreePreorderTraversal_Recur {

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
}
