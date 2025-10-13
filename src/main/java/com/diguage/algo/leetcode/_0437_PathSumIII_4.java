package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class _0437_PathSumIII_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-13 21:21:14
   */
  public int pathSum(TreeNode root, int targetSum) {
    if (Objects.isNull(root)) {
      return 0;
    }
    Map<Long, Integer> counter = new HashMap<>();
    counter.put(0L, 1);
    int[] result = {0};
    backtrack(root, counter, targetSum, 0L, result);
    return result[0];
  }

  private void backtrack(TreeNode root, Map<Long, Integer> counter,
                         int target, long path, int[] result) {
    if (Objects.isNull(root)) {
      return;
    }
    path += root.val;
    result[0] += counter.getOrDefault(path - target, 0);
    Integer origin = counter.getOrDefault(path, 0);
    counter.put(path, origin + 1);
    backtrack(root.left, counter, target, path, result);
    backtrack(root.right, counter, target, path, result);
    counter.put(path, origin);
  }

  // end::answer[]
  static void main() {
    new _0437_PathSumIII_4().pathSum(TreeNodes.buildTree(0, 1, 1), 0);
  }
}
