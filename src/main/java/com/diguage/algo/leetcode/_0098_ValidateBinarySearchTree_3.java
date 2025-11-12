package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.Arrays;
import java.util.Objects;

public class _0098_ValidateBinarySearchTree_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-12 22:00:35
   */
  public boolean isValidBST(TreeNode root) {
    if (null == root) {
      return true;
    }
    return dfs(root).valid;
  }

  private Record dfs(TreeNode root) {
    if (Objects.isNull(root)) {
      return null;
    }
    Record left = dfs(root.left);
    if (Objects.nonNull(left) && (!left.valid || root.val <= left.max)) {
      left.valid = false;
      return left;
    }
    Record right = dfs(root.right);
    if (Objects.nonNull(right) && (!right.valid || right.min <= root.val)) {
      right.valid = false;
      return right;
    }
    Record record = new Record();
    record.min = Objects.isNull(left) ? root.val : left.min;
    record.max = Objects.isNull(right) ? root.val : right.max;
    record.valid = true;
    return record;
  }

  private static class Record {
    int min;
    int max;
    boolean valid;

    public Record() {
    }

    public Record(int min, int max, boolean valid) {
      this.min = min;
      this.max = max;
      this.valid = valid;
    }
  }
  // end::answer[]

  static void main() {
    new _0098_ValidateBinarySearchTree_3()
      .isValidBST(TreeNodes.buildTree(Arrays.asList(1, null, 1)));
  }
}
