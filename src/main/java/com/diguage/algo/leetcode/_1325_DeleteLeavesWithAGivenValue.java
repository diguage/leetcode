package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _1325_DeleteLeavesWithAGivenValue {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-22 23:48:19
   */
  public TreeNode removeLeafNodes(TreeNode root, int target) {
    if (root == null) {
      return null;
    }
    root.left = removeLeafNodes(root.left, target);
    root.right = removeLeafNodes(root.right, target);
    if (root.left == null && root.right == null && root.val == target) {
      return null;
    }
    return root;
  }
  // end::answer[]
}
