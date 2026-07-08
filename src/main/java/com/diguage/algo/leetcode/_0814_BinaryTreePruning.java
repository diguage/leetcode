package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.Arrays;

public class _0814_BinaryTreePruning {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-08 23:09:15
   */
  public TreeNode pruneTree(TreeNode root) {
    boolean result = dfs(root);
    return result ? null : root;
  }

  private boolean dfs(TreeNode root) {
    if (root == null) {
      return true;
    }
    boolean left = dfs(root.left);
    boolean right = dfs(root.right);
    if (left) {
      root.left = null;
    }
    if (right) {
      root.right = null;
    }
    return left && right && root.val == 0;
  }
  // end::answer[]

  static void main() {
    new _0814_BinaryTreePruning().pruneTree(TreeNodes.buildTree(Arrays.asList(1, 0, 1, 0, 0, 0, 1)));
  }
}
