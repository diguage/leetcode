package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0865_SmallestSubtreeWithAllTheDeepestNodes {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-30 20:23:16
   */
  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    return (TreeNode) dfs(root)[0];
  }

  private Object[] dfs(TreeNode root) {
    if (root == null) {
      Object[] result = new Object[2];
      result[0] = root;
      result[1] = 0;
      return result;
    }
    Object[] left = dfs(root.left);
    Object[] right = dfs(root.right);
    if (left[1].equals(right[1])) {
      return new Object[]{root, (Integer) left[1] + 1};
    } else if ((Integer) left[1] < (Integer) right[1]) {
      right[1] = (Integer) right[1] + 1;
      return right;
    } else {
      left[1] = (Integer) left[1] + 1;
      return left;
    }
  }
  // end::answer[]
}
