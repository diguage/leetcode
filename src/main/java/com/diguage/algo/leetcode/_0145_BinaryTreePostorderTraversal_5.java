package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _0145_BinaryTreePostorderTraversal_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2020-06-16 11:24
   */
  public List<Integer> postorderTraversal(TreeNode head) {
    List<Integer> result = new ArrayList<>();
    TreeNode curr = head, mostRight = null;
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
          mostRight.right = null;
          result.addAll(getEdge(curr.left));
        }
      }
      curr = curr.right;
    }
    result.addAll(getEdge(head));
    return result;
  }

  private List<Integer> getEdge(TreeNode head) {
    TreeNode tail = reverseEdge(head);
    TreeNode curr = tail;
    List<Integer> result = new ArrayList<>();
    while (curr != null) {
      result.add(curr.val);
      curr = curr.right;
    }
    return result;
  }

  private TreeNode reverseEdge(TreeNode head) {
    TreeNode prev = null;
    TreeNode curr = head;
    while (curr != null) {
      TreeNode next = curr.right;
      curr.right = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
  // end::answer[]
}
