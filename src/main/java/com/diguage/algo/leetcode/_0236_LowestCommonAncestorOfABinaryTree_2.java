package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

/**
 * = 236. Lowest Common Ancestor of a Binary Tree
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/[Lowest Common Ancestor of a Binary Tree - LeetCode]
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to https://en.wikipedia.org/wiki/Lowest_common_ancestor[the definition of LCA on Wikipedia]: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow **a node to be a descendant of itself**).”
 *
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * .Example 1:
 * [source]
 * ----
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * ----
 *
 *
 * Note:
 *
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-24 21:08:59
 */
public class _0236_LowestCommonAncestorOfABinaryTree_2 {
  // tag::answer[]
  /**
   * 参考 左程云《程序员代码面试指南》的解法
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-06-24 21:08:59
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left != null && right != null) {
      return root;
    }
    return left != null ? left : right;
  }
  // end::answer[]
}
