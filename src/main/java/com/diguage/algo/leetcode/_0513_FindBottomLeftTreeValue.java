package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-25 20:55:53
 */
public class _0513_FindBottomLeftTreeValue {
  // tag::answer[]
  int curHeight = 0;

  int curValue = 0;

  /**
   * 尝试一下深度优先
   */
  public int findBottomLeftValue(TreeNode root) {
    dfs(root, 0);
    return curValue;
  }

  private void dfs(TreeNode root, int height) {
    if (root == null) {
      return;
    }
    height++;
    dfs(root.left, height);
    dfs(root.right, height);
    if (height > curHeight) {
      curHeight = height;
      curValue = root.val;
    }
  }
  // end::answer[]
}
