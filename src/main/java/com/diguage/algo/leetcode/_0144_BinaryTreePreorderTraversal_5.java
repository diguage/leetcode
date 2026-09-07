package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _0144_BinaryTreePreorderTraversal_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-07 22:32:09
   */
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    TreeNode curr = root, mostRight = null;
    while (curr != null) {
      mostRight = curr.left;
      if (mostRight != null) {
        while (mostRight.right != null && mostRight.right != curr) {
          mostRight = mostRight.right;
        }
        if (mostRight.right == null) {
          mostRight.right = curr;
          // 前根遍历：第一次遇见就“捕获”
          result.add(curr.val);
          curr = curr.left;
          continue;
        } else {
          mostRight.right = null;
        }
      } else {
        // 只遍历一次的元素，看见就“捕获”
        result.add(curr.val);
      }
      curr = curr.right;
    }
    return result;
  }
  // end::answer[]
}
