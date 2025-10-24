package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.Arrays;

public class _0230_KthSmallestElementInABst_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-24 18:08:06
   */
  int k = 0;

  public int kthSmallest(TreeNode root, int k) {
    this.k = k;
    return dfs(root);
  }

  private Integer dfs(TreeNode root) {
    if (root == null) {
      return null;
    }
    Integer left = dfs(root.left);
    if (left != null) {
      return left;
    }
    if (k == 1) {
      return root.val;
    } else {
      k--;
    }
    Integer right = dfs(root.right);
    if (right != null) {
      return right;
    }
    return null;
  }

  // end::answer[]
  static void main() {
    new _0230_KthSmallestElementInABst_4()
      .kthSmallest(TreeNodes.buildTree(Arrays.asList(5, 3, 6, 2, 4, null, null, 1)), 4);
  }
}
