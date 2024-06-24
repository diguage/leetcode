package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.PrintUtils;
import com.diguage.algorithm.util.TreeNode;

import java.util.*;

import static com.diguage.algorithm.util.TreeNodeUtils.buildTree;
import static java.util.Arrays.asList;

/**
 * = 107. Binary Tree Level Order Traversal II
 * <p>
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/[Binary Tree Level Order Traversal II - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-05 23:20
 */
public class _0107_BinaryTreeLevelOrderTraversalII_2 {

  /**
   *
   */
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<List<Integer>> result = new LinkedList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> level = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        level.add(node.val);
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      result.addFirst(level);
    }
    return result;
  }

  public static void main(String[] args) {
    _0107_BinaryTreeLevelOrderTraversalII_2 solution = new _0107_BinaryTreeLevelOrderTraversalII_2();
    List<List<Integer>> r1 = solution.levelOrderBottom(buildTree(asList(3, 9, 20, null, null, 15, 7)));
    PrintUtils.printMatrix(r1);
  }
}
