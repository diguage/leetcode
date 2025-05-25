package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.Arrays;

public class _1022_SumOfRootToLeafBinaryNumbers {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-25 23:02:00
   */
  int sum = 0;

  public int sumRootToLeaf(TreeNode root) {
    dfs(root, 0);
    return sum;
  }

  private void dfs(TreeNode root, int head) {
    if (root == null) {
      return;
    }
    int num = 2 * head + root.val;
    if (root.left == null && root.right == null) {
      sum += num;
      return;
    }
    dfs(root.left, num);
    dfs(root.right, num);
  }

  // end::answer[]
  public static void main(String[] args) {
    new _1022_SumOfRootToLeafBinaryNumbers()
      .sumRootToLeaf(TreeNodes.buildTree(Arrays.asList(1, 0, 1, 0, 1, 0, 1)));
  }
}
