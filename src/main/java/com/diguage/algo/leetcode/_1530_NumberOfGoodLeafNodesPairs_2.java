package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.*;

public class _1530_NumberOfGoodLeafNodesPairs_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-15 20:15:50
   */
  private int result = 0;

  public int countPairs(TreeNode root, int distance) {
    dfs(root, distance);
    return result;
  }

  private List<Integer> dfs(TreeNode root, int distance) {
    if (Objects.isNull(root)) {
      return Collections.emptyList();
    }
    List<Integer> distances = new ArrayList<>();
    List<Integer> left = dfs(root.left, distance);
    List<Integer> right = dfs(root.right, distance);
    for (Integer d : left) {
      for (Integer rd : right) {
        if (d + rd + 2 <= distance) {
          result++;
        }
      }
      if (d + 1 > distance && !distances.isEmpty()) {
        continue;
      }
      distances.add(d + 1);
    }
    for (Integer d : right) {
      if (d + 1 > distance && !distances.isEmpty()) {
        continue;
      }
      distances.add(d + 1);
    }
    if (distances.isEmpty()) {
      distances.add(0);
    }
    return distances;
  }
  // end::answer[]
  static void main(String[] args) {
    new _1530_NumberOfGoodLeafNodesPairs_2()
      .countPairs(TreeNodes.buildTree(
        Arrays.asList(78, 15, 81, 73, 98, 36, null, 30, null, 63, 32)), 3);
  }
}
