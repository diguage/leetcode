package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import static com.diguage.algorithm.util.TreeNodeUtils.buildTree;
import static java.util.Arrays.asList;

/**
 * = 110. Balanced Binary Tree
 *
 * https://leetcode.com/problems/balanced-binary-tree/[LeetCode - Balanced Binary Tree]
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-02-06 23:10
 */
public class _0110_BalancedBinaryTree_21 {

  /**
   * 看了论坛中大家的讨论，做了提前结束递归的优化。
   */
  public boolean isBalanced(TreeNode root) {
    return dfs(root) >= 0;
  }

  public int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = dfs(root.left);
    // 发现不平衡即提前结束递归
    if (left < 0) {
      return -1;
    }
    int right = dfs(root.right);
    // 发现不平衡即提前结束递归
    if (right < 0) {
      return -1;
    }
    return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
  }

  public static void main(String[] args) {
    _0110_BalancedBinaryTree_21 solution = new _0110_BalancedBinaryTree_21();
    System.out.println(!solution.isBalanced(buildTree(asList(1, 2, 2, 3, null, null, 3, 4, null, null, 4))));
    System.out.println(solution.isBalanced(buildTree(asList(3, 9, 20, null, null, 15, 7))));
    System.out.println(!solution.isBalanced(buildTree(asList(1, 2, 2, 3, 3, null, null, 4, 4))));
  }
}
