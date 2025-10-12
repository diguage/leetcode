package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;
import com.diguage.util.TreeNodes;

public class _0543_DiameterOfBinaryTree_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-12 22:06:10
   */
  private int result = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    dfs(root);
    return result;
  }

  private int dfs(TreeNode root) {
    if (root == null) {
      return -1; // 对于叶子来说，链长就是 -1+1=0
    }
    int left = dfs(root.left) + 1; // 左子树最大链长+1
    int right = dfs(root.right) + 1; // 右子树最大链长+1
    result = Math.max(result, left + right); // 两条链拼成路径
    return Math.max(left, right); // 当前子树最大链长
  }

  // end::answer[]
  static void main() {
    new _0543_DiameterOfBinaryTree_2()
      .diameterOfBinaryTree(TreeNodes.buildTree(1, 2));
  }
}
