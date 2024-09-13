package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0230_KthSmallestElementInABst_3 {
  // tag::answer[]

  /**
   * Morris 中序遍历
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-13 22:09:21
   */
  public int kthSmallest(TreeNode root, int k) {
    TreeNode curr = root;
    while (curr != null) {
      TreeNode mostRight = curr.left;
      if (mostRight != null) {
        while (mostRight.right != null && mostRight.right != curr) {
          mostRight = mostRight.right;
        }
        if (mostRight.right == null) {
          mostRight.right = curr;
          curr = curr.left;
          continue;
        } else {
          mostRight.right = null;
        }
      }
      k--;
      if (k == 0) {
        return curr.val;
      }
      curr = curr.right;
    }
    // 不会走到这里，加这句话只是保证编译不报错
    return 0;
  }
  // end::answer[]
}
