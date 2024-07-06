package com.diguage.algorithm.leetcode;

import com.diguage.util.Jsons;
import com.diguage.algorithm.util.TreeNode;

import java.util.Arrays;

import static com.diguage.util.TreeNodes.buildTree;

/**
 * = 114. Flatten Binary Tree to Linked List
 *
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/[Flatten Binary Tree to Linked List - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-27 23:18
 */
public class _0114_FlattenBinaryTreeToLinkedList_2 {
  // tag::answer[]
  /**
   * 参考 https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/solutions/17274/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26/[114. 二叉树展开为链表^] 的解法，自己实现的。
   */
  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    while (root != null) {
      if (root.left == null) {
        root = root.right;
      } else {
        TreeNode pre = root.left;
        while (pre.right != null) {
          pre = pre.right;
        }
        pre.right = root.right;
        root.right = root.left;
        root.left = null;
        root = root.right;
      }
    }
  }

  // end::answer[]


  public static void main(String[] args) {
    _0114_FlattenBinaryTreeToLinkedList_2 solution = new _0114_FlattenBinaryTreeToLinkedList_2();
    TreeNode t1 = buildTree(Arrays.asList(1, 2, 5, 3, 4, null, 6));
    solution.flatten(t1);
    System.out.println(Jsons.toJson(t1));
  }
}
