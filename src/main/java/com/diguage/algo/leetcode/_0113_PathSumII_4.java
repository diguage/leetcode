package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _0113_PathSumII_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-25 22:46:05
   */
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    backtrack(root, targetSum, result, path);
    return result;
  }

  private void backtrack(TreeNode root, int targetSum,
                         List<List<Integer>> result,
                         List<Integer> path) {
    if (root == null) {
      return;
    }
    path.add(root.val);
    int nextTarget = targetSum - root.val;
    if (nextTarget == 0 && root.left == null && root.right == null) {
      result.add(new ArrayList<>(path));
    }
    backtrack(root.left, nextTarget, result, path);
    backtrack(root.right, nextTarget, result, path);
    path.removeLast();
  }
  // end::answer[]
}
