package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0235_LowestCommonAncestorOfABinarySearchTree_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-18 22:02:24
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if ((p.val <= root.val && root.val <= q.val)
      || (q.val <= root.val && root.val <= p.val)) {
      return root;
    } else if (p.val <= root.val && q.val <= root.val) {
      return lowestCommonAncestor(root.left, p, q);
    } else {
      return lowestCommonAncestor(root.right, p, q);
    }
  }
  // end::answer[]
}
