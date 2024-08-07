package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

/**
 */
public class _0538_ConvertBSTToGreaterTree {
  // tag::answer[]
  int sum = 0;
  /**
   * 逆向中根遍历
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-06-26 20:50:34
   */
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
  // end::answer[]
}
