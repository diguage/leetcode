package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.Arrays;

import static com.diguage.util.TreeNodes.buildTree;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-23 16:38:11
 */
public class _0098_ValidateBinarySearchTree_2 {
  // tag::answer[]
  public boolean isValidBST(TreeNode root) {
    return dfs(root).valid;
  }

  private Record dfs(TreeNode node) {
    if (node == null) {
      return new Record(true, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    Record left = dfs(node.left);
    if (!left.valid) {
      return new Record(false, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    Record right = dfs(node.right);
    if (!right.valid) {
      return new Record(false, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    long max = Math.max(left.max, Math.max(node.val, right.max));
    long min = Math.min(left.min, Math.min(node.val, right.min));

    return new Record(left.valid && right.valid
      && left.max < node.val && node.val < right.min, max, min);
  }

  public static class Record {
    public boolean valid;
    public long max;
    public long min;

    public Record(boolean valid, long max, long min) {
      this.valid = valid;
      this.max = max;
      this.min = min;
    }
  }

  // end::answer[]


  public static void main(String[] args) {
    _0098_ValidateBinarySearchTree_2 solution = new _0098_ValidateBinarySearchTree_2();

    boolean r5 = solution.isValidBST(buildTree(Arrays.asList(2147483647)));
    System.out.println(r5);

    boolean r4 = solution.isValidBST(buildTree(Arrays.asList(3, 1, 5, 0, 2, 4, 6, null, null, null, 3)));
    System.out.println(r4);

    boolean r3 = solution.isValidBST(buildTree(Arrays.asList(10, 5, 15, null, null, 6, 20)));
    System.out.println(r3);

    boolean r1 = solution.isValidBST(buildTree(Arrays.asList(2, 1, 3)));
    System.out.println(r1);

    boolean r2 = solution.isValidBST(buildTree(Arrays.asList(5, 1, 4, null, null, 3, 6)));
    System.out.println(r2);
  }
}
