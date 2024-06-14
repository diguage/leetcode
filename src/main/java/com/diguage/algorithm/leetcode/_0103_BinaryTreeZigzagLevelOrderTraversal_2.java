package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.*;

import static com.diguage.algorithm.util.TreeNodeUtils.buildTree;

/**
 * = 103. Binary Tree Zigzag Level Order Traversal
 * <p>
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/[Binary Tree Zigzag Level Order Traversal - LeetCode]
 * <p>
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
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
 * return its zigzag level order traversal as:
 * <p>
 * ----
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * ----
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-24 21:12
 */
public class _0103_BinaryTreeZigzagLevelOrderTraversal_2 {

  /**
   *
   */
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean reversed = false;
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> list = new LinkedList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (reversed) {
          list.addFirst(node.val);
        } else {
          list.addLast(node.val);
        }
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      result.add(list);
      reversed = !reversed;
    }
    return result;
  }

  public static void main(String[] args) {
    _0103_BinaryTreeZigzagLevelOrderTraversal_2 solution = new _0103_BinaryTreeZigzagLevelOrderTraversal_2();
    List<List<Integer>> r2 = solution.zigzagLevelOrder(buildTree(Arrays.asList(1, 2, 3, 4, null, null, 5)));
    System.out.println(r2);

    List<List<Integer>> r1 = solution.zigzagLevelOrder(buildTree(Arrays.asList(3, 9, 20, null, null, 15, 7)));
    System.out.println(r1);
  }
}
