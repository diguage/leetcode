package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-26 20:50:34
 */
public class _0538_ConvertBSTToGreaterTree {
  int sum = 0;

  public TreeNode convertBST(TreeNode root) {
    if (null == root) {
      return null;
    }
    convertBST(root.right);
    sum += root.val;
    root.val = sum;
    convertBST(root.left);
    return root;
  }
}
