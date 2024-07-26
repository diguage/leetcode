package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _1644_LowestCommonAncestorOfABinaryTreeII {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-26 20:00:58
   *
   * TODO 没有验证！
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    Result result = dfs(root, p, q);
    return result.findP && result.findQ ? result.node : null;
  }

  private Result dfs(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return new Result(null, false, false);
    }
    Result left = dfs(root.left, p, q);
    Result right = dfs(root.right, p, q);
    if (left.node != null && right.node != null) {
      return new Result(root, true, true);
    }
    if (root.val == p.val || root.val == q.val) {
      boolean findP = false;
      if (root.val == p.val) {
        findP = true;
      }
      boolean findQ = false;
      if (root.val == q.val) {
        findQ = true;
      }
      return new Result(root,
        findP || left.findP || right.findP,
        findQ || left.findQ || right.findQ);
    }


    return left.node != null ? left : right;
  }


  public static class Result {
    TreeNode node;
    boolean findP;
    boolean findQ;

    public Result() {
    }

    public Result(TreeNode node, boolean findP, boolean findQ) {
      this.node = node;
      this.findP = findP;
      this.findQ = findQ;
    }
  }
  // end::answer[]
}
