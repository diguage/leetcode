package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class _0662_MaximumWidthOfBinaryTree_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-12-26 16:00:20
   */
  public int widthOfBinaryTree(TreeNode root) {
    Map<Integer, Long> min = new HashMap<>();
    Map<Integer, Long> max = new HashMap<>();
    dfs(root, min, max, 1L, 1);
    long result = 0;
    for (int i = 1; i <= min.size(); i++) {
      result = Math.max(result, max.get(i) - min.get(i) + 1);
    }
    return (int) result;
  }

  private void dfs(TreeNode root, Map<Integer, Long> min,
                   Map<Integer, Long> max, Long step, int levle) {
    if (Objects.isNull(root)) {
      return;
    }
    min.put(levle, min.containsKey(levle) ? Math.min(min.get(levle), step) : step);
    max.put(levle, max.containsKey(levle) ? Math.max(max.get(levle), step) : step);
    dfs(root.left, min, max, 2 * step, levle + 1);
    dfs(root.right, min, max, 2 * step + 1, levle + 1);
  }
  // end::answer[]
}
