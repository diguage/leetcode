package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-25 20:55:53
 */
public class _0513_FindBottomLeftTreeValue {
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
}
