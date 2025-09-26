package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _0437_PathSumIII_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-26 21:53:27
   */
  int result = 0;

  public int pathSum(TreeNode root, int targetSum) {
    Map<Long, Integer> numToCounter = new HashMap<>();
    backtrack(root, targetSum, 0L, numToCounter);
    return result;
  }

  private void backtrack(TreeNode root, int targetSum,
                         long prefix, Map<Long, Integer> numToCounter) {
    if (root == null) {
      return;
    }
    prefix += root.val;
    if (prefix == targetSum) {
      result++;
    }
    result += numToCounter.getOrDefault(prefix - targetSum, 0);
    Integer original = numToCounter.getOrDefault(prefix, 0);
    numToCounter.put(prefix, original + 1);
    backtrack(root.left, targetSum, prefix, numToCounter);
    backtrack(root.right, targetSum, prefix, numToCounter);
    numToCounter.put(prefix, original);
  }
  // end::answer[]
}
