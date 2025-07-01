package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-28 12:21
 */
public class _0222_CountCompleteTreeNodes {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2020-01-28 12:21
   */
  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    // countLevel 方法统计的是最节点的深度
    int left = countLevel(root.left);
    int right = countLevel(root.right);
    if (left == right) {
      return countNodes(root.right) + (1 << left);
    } else {
      return countNodes(root.left) + (1 << right);
    }
  }

  private int countLevel(TreeNode root) {
    int result = 0;
    while (root != null) {
      // 注意：这里是 left 节点
      root = root.left;
      result++;
    }
    return result;
  }
  // end::answer[]
}
