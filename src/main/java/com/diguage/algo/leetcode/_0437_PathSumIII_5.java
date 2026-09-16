package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _0437_PathSumIII_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-16 21:15:44
   */
  int result = 0;

  public int pathSum(TreeNode root, int targetSum) {
    Map<Long, Integer> counter = new HashMap<>();
    counter.put(0L, 1);
    backtrack(root, targetSum, counter, 0L);
    return result;
  }

  private void backtrack(TreeNode root, int target,
                         Map<Long, Integer> counter, long path) {
    if (root == null) {
      return;
    }
    path += root.val;
    result += counter.getOrDefault(path - target, 0);
    // 注意：这里存 origin 是因为在向下遍历时，可能增加了很多次。而不仅仅只加 1
    Integer origin = counter.getOrDefault(path, 0);
    counter.put(path, origin + 1);
    backtrack(root.left, target, counter, path);
    backtrack(root.right, target, counter, path);
    // 所以，这里要将原来的计数放回去
    counter.put(path, origin);
  }
  // end::answer[]

}
