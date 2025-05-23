package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * = 144. Binary Tree Preorder Traversal
 * <p>
 * https://leetcode.com/problems/binary-tree-preorder-traversal/[Binary Tree Preorder Traversal - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-06-16 10:59
 */
public class _0144_BinaryTreePreorderTraversal_Morris {
  // tag::answer[]
  /**
   * 有一种巧妙的方法可以在线性时间内，只占用常数空间来实现前序遍历。
   * 这种方法由 J. H. Morris 在 1979 年的论文「Traversing Binary Trees Simply and Cheaply」
   * 中首次提出，因此被称为 Morris 遍历。
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-09 20:32:20
   */
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    TreeNode cur = root;
    TreeNode mostRight = null;
    while (cur != null) {
      mostRight = cur.left;
      if (mostRight != null) {
        while (mostRight.right != null && mostRight.right != cur) {
          mostRight = mostRight.right;
        }
        if (mostRight.right == null) {
          result.add(cur.val);
          mostRight.right = cur;
          cur = cur.left;
          continue;
        } else {
          mostRight.right = null;
        }
      } else {
        result.add(cur.val);
      }
      cur = cur.right;
    }
    return result;
  }

  // end::answer[]
}
