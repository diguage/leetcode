package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0104_MaximumDepthOfBinaryTree_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-20 23:45:16
   */
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }
  // end::answer[]
}
