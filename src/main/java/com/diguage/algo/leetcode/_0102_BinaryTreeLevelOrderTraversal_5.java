package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.*;

public class _0102_BinaryTreeLevelOrderTraversal_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-10-23 22:58:38
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    if (Objects.isNull(root)) {
      return Collections.emptyList();
    }
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> list = new ArrayList<>(size);
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        list.add(node.val);
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      result.add(list);
    }
    return result;
  }

  // end::answer[]

}
