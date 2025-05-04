package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0199_BinaryTreeRightSideView_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-04 21:45:49
   */
  public List<Integer> rightSideView(TreeNode root) {
    Map<Integer, Integer> levelToNode = new HashMap<>();
    dfs(root, 0, levelToNode);
    return new ArrayList<>(levelToNode.values());
  }

  private void dfs(TreeNode root, int level, Map<Integer, Integer> levelToNode) {
    if (root == null) {
      return;
    }
    levelToNode.put(level, root.val);
    dfs(root.left, level + 1, levelToNode);
    dfs(root.right, level + 1, levelToNode);
  }
  // end::answer[]
}
