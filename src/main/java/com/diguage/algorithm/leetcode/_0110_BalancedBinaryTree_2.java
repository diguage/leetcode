package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import static com.diguage.util.TreeNodes.buildTree;
import static java.util.Arrays.asList;

/**
 * = 110. Balanced Binary Tree
 *
 * https://leetcode.com/problems/balanced-binary-tree/[LeetCode - Balanced Binary Tree]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-06 23:10
 */
public class _0110_BalancedBinaryTree_2 {
  // tag::answer[]

  /**
   * 使用“树形 DP 套路”
   */
  public boolean isBalanced(TreeNode root) {
    return dfs(root).balance;
  }

  public Record dfs(TreeNode root) {
    if (root == null) {
      return new Record(true, 0);
    }
    Record left = dfs(root.left);
    Record right = dfs(root.right);
    boolean balance = left.balance && right.balance && Math.abs(left.height - right.height) <= 1;
    return new Record(balance, Math.max(left.height, right.height) + 1);
  }

  public static class Record {
    public boolean balance;
    public int height;

    public Record(boolean balance, int height) {
      this.balance = balance;
      this.height = height;
    }
  }

  // end::answer[]


  public static void main(String[] args) {
    _0110_BalancedBinaryTree_2 solution = new _0110_BalancedBinaryTree_2();
    System.out.println(!solution.isBalanced(buildTree(asList(1, 2, 2, 3, null, null, 3, 4, null, null, 4))));
    System.out.println(solution.isBalanced(buildTree(asList(3, 9, 20, null, null, 15, 7))));
    System.out.println(!solution.isBalanced(buildTree(asList(1, 2, 2, 3, 3, null, null, 4, 4))));
  }
}
