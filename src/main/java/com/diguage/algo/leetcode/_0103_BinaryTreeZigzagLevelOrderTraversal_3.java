package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _0103_BinaryTreeZigzagLevelOrderTraversal_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-19 22:15:19
   */
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<List<Integer>> result = new LinkedList<>();
    List<TreeNode> stack = new LinkedList<>();
    stack.add(root);
    boolean flag = true;
    while (!stack.isEmpty()) {
      int size = stack.size();
      List<Integer> nums = new LinkedList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = stack.removeFirst();
        if (flag) {
          nums.addLast(node.val);
        } else {
          nums.addFirst(node.val);
        }
        if (node.left != null) {
          stack.add(node.left);
        }
        if (node.right != null) {
          stack.add(node.right);
        }
      }
      flag = !flag;
      result.add(nums);
    }
    return result;
  }
  // end::answer[]
}
