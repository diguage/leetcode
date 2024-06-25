package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * = 145. Binary Tree Postorder Traversal
 * <p>
 * https://leetcode.com/problems/binary-tree-postorder-traversal/[Binary Tree Postorder Traversal - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-06-16 11:24
 */
public class _0145_BinaryTreePostorderTraversal_Recur {

  public List<Integer> postorderTraversal(TreeNode head) {
    List<Integer> result = new ArrayList<>();
    postorderTraversal(head, result);
    return result;
  }

  private void postorderTraversal(TreeNode head, List<Integer> result) {
    if (head == null) {
      return;
    }
    postorderTraversal(head.left, result);
    postorderTraversal(head.right, result);
    result.add(head.val);
  }
}
