package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _0094_BinaryTreeInorderTraversal_5 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-07 22:20:31
   */
  public List<Integer> inorderTraversal(TreeNode root) {
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
          curr = curr.left;
          continue;
        } else {
          // 中根遍历：第二次遇见才“捕获”
          result.add(curr.val);
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
