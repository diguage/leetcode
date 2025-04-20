package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class _0662_MaximumWidthOfBinaryTree {
  // tag::answer[]
  /**
   * 通过 94 / 116 个测试用例，但超时了。
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-20 21:13:45
   */
  public int widthOfBinaryTree(TreeNode root) {
    final TreeNode DUMMY = new TreeNode(Integer.MAX_VALUE);
    Deque<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int result = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      result = Math.max(result, size);
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (node.left != null) {
          queue.offer(node.left);
        } else {
          queue.offer(DUMMY);
        }
        if (node.right != null) {
          queue.offer(node.right);
        } else {
          queue.offer(DUMMY);
        }
      }
      while (!queue.isEmpty() && queue.peek() == DUMMY) {
        queue.poll();
      }
      while (!queue.isEmpty() && queue.peekLast() == DUMMY) {
        queue.pollLast();
      }
    }
    return result;
  }
  // end::answer[]
}
