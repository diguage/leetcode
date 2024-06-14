package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.*;

import static com.diguage.algorithm.util.TreeNodeUtils.buildTree;

/**
 * = 102. Binary Tree Level Order Traversal
 * <p>
 * https://leetcode.com/problems/binary-tree-level-order-traversal/[Binary Tree Level Order Traversal - LeetCode]
 * <p>
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree `[3,9,20,null,null,15,7]`,
 * <p>
 * ----
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * ----
 * <p>
 * return its level order traversal as:
 * <p>
 * ----
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-24 20:40
 */
public class _0102_BinaryTreeLevelOrderTraversal_2 {

  /**
   * Runtime: 3 ms, faster than 5.15% of Java online submissions for Binary Tree Level Order Traversal.
   * <p>
   * Memory Usage: 40.2 MB, less than 5.33% of Java online submissions for Binary Tree Level Order Traversal.
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> topQueue = new LinkedList<>();

    topQueue.add(root);
    while (!topQueue.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      Queue<TreeNode> bottomQueue = new LinkedList<>();
      while (!topQueue.isEmpty()) {
        TreeNode top = topQueue.poll();
        level.add(top.val);
        if (top.left != null) {
          bottomQueue.add(top.left);
        }
        if (top.right != null) {
          bottomQueue.add(top.right);
        }
      }
      result.add(level);
      topQueue = bottomQueue;
    }
    return result;
  }

  public static void main(String[] args) {
    _0102_BinaryTreeLevelOrderTraversal_2 solution = new _0102_BinaryTreeLevelOrderTraversal_2();
    List<List<Integer>> r1 = solution.levelOrder(buildTree(Arrays.asList(3, 9, 20, null, null, 15, 7)));
    System.out.println(r1);
  }
}
