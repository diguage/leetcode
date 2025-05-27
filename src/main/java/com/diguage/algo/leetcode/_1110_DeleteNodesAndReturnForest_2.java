package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.*;

public class _1110_DeleteNodesAndReturnForest_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-27 21:06:27
   */
  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    Set<Integer> set = new HashSet<>(to_delete.length);
    Arrays.stream(to_delete).forEach(set::add);
    List<TreeNode> result = new ArrayList<>();
    dfs(root, set, result, null, true);
    return result;
  }

  private void dfs(TreeNode node, Set<Integer> set,
                   List<TreeNode> result, TreeNode parent, boolean left) {
    if (node == null) {
      return;
    }
    if (set.contains(node.val)) {
      if (parent != null) {
        if (left) {
          parent.left = null;
        } else {
          parent.right = null;
        }
      }
      dfs(node.left, set, result, null, true);
      dfs(node.right, set, result, null, false);
    } else {
      if (parent == null) {
        result.add(node);
      }
      dfs(node.left, set, result, node, true);
      dfs(node.right, set, result, node, false);
    }
  }
  // end::answer[]
}
