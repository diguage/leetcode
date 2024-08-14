package com.diguage.algo.leetcode;

import java.util.Objects;

public class _1650_LowestCommonAncestorOfABinaryTreeIII {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-26 20:00:58
   */
  public TreeNode lowestCommonAncestor(TreeNode p, TreeNode q) {
    if (Objects.isNull(p) || Objects.isNull(q)) {
      return null;
    }
    TreeNode a = p;
    TreeNode b = q;
    while (a != b) {
      if (a == null) {
        a = q;
      } else {
        a = a.parent;
      }
      if (b == null) {
        b = p;
      } else {
        b = b.parent;
      }
    }
    return a;
  }
  // end::answer[]

  public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    public TreeNode() {
    }

    public TreeNode(int x) {
      val = x;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      TreeNode treeNode = (TreeNode) o;
      return val == treeNode.val;
    }

    @Override
    public int hashCode() {
      return Objects.hash(val);
    }
  }
}
