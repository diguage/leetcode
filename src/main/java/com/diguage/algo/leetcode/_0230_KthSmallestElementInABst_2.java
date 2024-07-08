package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

/**
 * = 230. Kth Smallest Element in a BST
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/[Kth Smallest Element in a BST - LeetCode]
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 * ----
 *
 * *Follow up:*
 *
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-22 08:27
 */
public class _0230_KthSmallestElementInABst_2 {
  // tag::answer[]
  /**
   * Morris 中序遍历
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-08 14:51:44
   */
  public int kthSmallest(TreeNode root, int k) {
    TreeNode cur = root;
    TreeNode mostRight = null;
    TreeNode result = null;
    while (cur != null) {
      mostRight = cur.left;
      if (mostRight != null) {
        while (mostRight.right != null && mostRight.right != cur) {
          mostRight = mostRight.right;
        }
        if (mostRight.right == null) {
          mostRight.right = cur;
          cur = cur.left;
          continue;
        }else {
          mostRight.right = null;
        }
      }
      k--;
      if (k == 0) {
        result = cur;
        break;
      }
      System.out.println(cur.val);
      cur = cur.right;
    }
    return result.val;
  }
  // end::answer[]
}
