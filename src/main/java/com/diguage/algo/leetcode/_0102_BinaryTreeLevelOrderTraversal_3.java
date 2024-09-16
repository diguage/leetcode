package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.*;

public class _0102_BinaryTreeLevelOrderTraversal_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-06-25 11:27
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> nums = new ArrayList<>(size);
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        nums.add(node.val);
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      result.add(nums);
    }
    return result;
  }
  // end::answer[]
}
