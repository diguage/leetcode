package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0654_MaximumBinaryTree_1 {
  // tag::answer[]
  /**
   * 参考 https://leetcode.cn/problems/maximum-binary-tree/solutions/1762400/zhua-wa-mou-si-by-muse-77-myd7/[654. 最大二叉树 - 图解LeetCode^]
   *
   * TODO: 为什么执行效率非常低啊？
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-06-26 14:34:18
   */
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }
    Deque<TreeNode> deque = new ArrayDeque<>();
    for (int i = 0; i < nums.length; i++) {
      TreeNode node = new TreeNode(nums[i]);
      while (!deque.isEmpty()) {
        TreeNode topNode = deque.peekLast();
        if (topNode.val > node.val) {
          deque.addLast(node);
          topNode.right = node;
          break;
        } else {
          deque.removeLast();
          node.left = topNode;
        }
      }
      if (deque.isEmpty()) {
        deque.addLast(node);
      }
    }
    return deque.peek();
  }
  // end::answer[]
}
