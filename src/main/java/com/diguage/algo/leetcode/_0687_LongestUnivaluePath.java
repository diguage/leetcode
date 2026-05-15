package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.Arrays;

public class _0687_LongestUnivaluePath {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-15 22:22:35
   */
  private int result = 0;

  public int longestUnivaluePath(TreeNode root) {
    dfs(root);
    return result;
  }

  private int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = dfs(root.left);
    int right = dfs(root.right);
    int temp = 0;
    int path = 0;
    if (root.left != null && root.left.val == root.val) {
      temp += left + 1;
      path = Math.max(path, left + 1);
    }
    if (root.right != null && root.right.val == root.val) {
      temp += right + 1;
      path = Math.max(path, right + 1);
    }
    result = Math.max(result, temp);
    return path;
  }

  // end::answer[]
  static void main() {
    new _0687_LongestUnivaluePath().longestUnivaluePath(
      TreeNodes.buildTree(Arrays.asList(1, null, 1, 1, 1, 1, 1, 1)));
  }
}
