package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0124_BinaryTreeMaximumPathSum_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-01 10:57:14
   */
  int result = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    dfs(root);
    return result;
  }

  private int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    // 这里可以利用 Math.max(0, dfs(root.right)) 简化代码。
    // 但是，不简化可以击败 100%，简化后如一刷解法，却只能击败 49.84%
    int left = dfs(root.left);
    int right = dfs(root.right);
    // 对于左右子树，这里有如下几种组合
    // 1. root.val (left 和 right 都是负数)
    // 2. root.val + Math.max(left, right) (left 和 right 有一个是正数)
    // 3. left + root.val + right (left 和 right 都是正数)
    result = Math.max(result, Math.max(left + root.val + right,
      Math.max(Math.max(left, right) + root.val, root.val)));
    // 对于返回给父节点，这里有两种可能
    // 1. root.val (left 和 right 都是负数)
    // 2. root.val + Math.max(left, right) (left 和 right 有一个是正数)
    // 如果 max 方法支持传递多个参数，可以简写为：Math.max(0, left, right) + root.val
    return Math.max(root.val, Math.max(left, right) + root.val);
  }
  // end::answer[]

  public static void main(String[] args) {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(-1);
    new _0124_BinaryTreeMaximumPathSum_2().maxPathSum(root);
  }
}
