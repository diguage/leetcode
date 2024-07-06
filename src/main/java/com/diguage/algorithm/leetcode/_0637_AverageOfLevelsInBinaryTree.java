package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.*;

public class _0637_AverageOfLevelsInBinaryTree {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-06-14
   */
  public List<Double> averageOfLevels(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<Double> result = new ArrayList<>();
    Deque<TreeNode> levels = new LinkedList<>();
    levels.offer(root);
    while (!levels.isEmpty()) {
      int size = levels.size();
      double sum = 0.0;
      for (int i = 0; i < size; i++) {
        TreeNode node = levels.poll();
        sum += node.val;
        if (node.left != null) {
          levels.offer(node.left);
        }
        if (node.right != null) {
          levels.offer(node.right);
        }
      }
      result.add(sum / size);
    }
    return result;
  }
  // end::answer[]
}
