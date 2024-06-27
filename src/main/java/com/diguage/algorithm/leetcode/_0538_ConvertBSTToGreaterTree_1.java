package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.Arrays;

public class _0538_ConvertBSTToGreaterTree_1 {

  /**
   * 基于 Morris 的倒序中根遍历
   */
  public TreeNode convertBST(TreeNode root) {
    int sum = 0;
    // 反向 Morris
    TreeNode cur = root;
    TreeNode mostLeft = null;
    while (cur != null) {
      mostLeft = cur.right;
      if (mostLeft != null) {
        while (mostLeft.left != null && mostLeft.left != cur) {
          mostLeft = mostLeft.left;
        }
        if (mostLeft.left == null) {
          mostLeft.left = cur;
          cur = cur.right;
          continue;
        } else {
          mostLeft.left = null;
        }
      }
      sum += cur.val;
      cur.val = sum;
      cur = cur.left;
    }
    return root;
  }

  public static void main(String[] args) {
    TreeNode tree = TreeNodes.buildTree(Arrays.asList(4, 2, 6, 1, 3, 5, 7));
    _0538_ConvertBSTToGreaterTree_1 solution = new _0538_ConvertBSTToGreaterTree_1();
    solution.convertBST(tree);
  }
}
