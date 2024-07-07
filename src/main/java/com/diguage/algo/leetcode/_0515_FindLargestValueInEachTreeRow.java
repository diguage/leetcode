package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.*;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-25 15:32:45
 */
public class _0515_FindLargestValueInEachTreeRow {
  // tag::answer[]
  public List<Integer> largestValues(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<Integer> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        max = Math.max(max, node.val);
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      result.add(max);
    }
    return result;
  }
  // end::answer[]
}
