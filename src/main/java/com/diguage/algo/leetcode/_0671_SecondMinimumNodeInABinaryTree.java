package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _0671_SecondMinimumNodeInABinaryTree {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-01 21:29:51
   */
  PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

  public int findSecondMinimumValue(TreeNode root) {
    dfs(root);
    return queue.isEmpty() || queue.size() == 1 ? -1 : queue.poll();
  }

  private void dfs(TreeNode root) {
    if (root == null) {
      return;
    }
    if (queue.isEmpty()
      || (queue.peek() != root.val && !queue.contains(root.val))) {
      queue.offer(root.val);
    }
    if (queue.size() > 2) {
      queue.poll();
    }
    dfs(root.left);
    dfs(root.right);
  }
  // end::answer[]

  static void main() {
    new _0671_SecondMinimumNodeInABinaryTree()
      .findSecondMinimumValue(TreeNodes.buildTree(Arrays.asList(1, 1, 3, 1, 1, 3, 4, 3, 1, 1, 1, 3, 8, 4, 8, 3, 3, 1, 6, 2, 1)));
  }
}
