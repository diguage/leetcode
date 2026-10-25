package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0098_ValidateBinarySearchTree_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-10-25 22:32:19
   */
  public boolean isValidBST(TreeNode root) {
    return dfs(root).valid;
  }

  private Record dfs(TreeNode root) {
    if (null == root) {
      return null;
    }
    Record left = dfs(root.left);
    if (left != null && !left.valid) {
      return left;
    }
    Record right = dfs(root.right);
    if (right != null && !right.valid) {
      return right;
    }
    if (left == null && right == null) {
      return new Record(true, root.val, root.val);
    } else if (left == null) {
      return new Record(root.val < right.min, root.val, right.max);
    } else if (right == null) {
      return new Record(left.max < root.val, left.min, root.val);
    } else {
      return new Record(left.max < root.val && root.val < right.min, left.min, right.max);
    }
  }

  private static class Record {
    boolean valid;
    Integer min;
    Integer max;

    public Record(boolean valid, Integer min, Integer max) {
      this.valid = valid;
      this.min = min;
      this.max = max;
    }
  }
  // end::answer[]
}
