package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

/**
 * = 617. Merge Two Binary Trees
 *
 * https://leetcode.com/problems/merge-two-binary-trees/[Merge Two Binary Trees - LeetCode]
 *
 */
public class _0617_MergeTwoBinaryTrees_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-06-26 16:24:45
   */
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) {
      return null;
    }
    if (t1 != null && t2 == null) {
      return t1;
    }
    if (t1 == null && t2 != null) {
      return t2;
    }
    TreeNode root = new TreeNode(t1.val + t2.val);
    root.left = mergeTrees(t1.left, t2.left);
    root.right = mergeTrees(t1.right, t2.right);
    return root;
  }
  // end::answer[]
}
