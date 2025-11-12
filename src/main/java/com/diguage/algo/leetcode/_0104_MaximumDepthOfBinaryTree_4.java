package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0104_MaximumDepthOfBinaryTree_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-12 21:49:21
   */
  public int maxDepth(TreeNode root) {
    if (null == root) {
      return 0;
    }
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    return Math.max(left, right) + 1;
  }
  // end::answer[]
}
