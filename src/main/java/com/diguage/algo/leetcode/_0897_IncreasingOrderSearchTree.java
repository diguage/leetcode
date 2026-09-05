package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _0897_IncreasingOrderSearchTree {

  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-05 21:58:39
   */
  public TreeNode increasingBST(TreeNode root) {
    List<TreeNode> list = new ArrayList<>();
    dfs(root, list);
    TreeNode result = list.getFirst();
    TreeNode pre = null;
    for (int i = 0; i < list.size(); i++) {
      TreeNode node = list.get(i);
      node.left = null;
      node.right = null;
      if(pre != null) {
        pre.right = node;
      }
      pre = node;
    }
    return result;
  }

  private void dfs(TreeNode root, List<TreeNode> list) {
    if (root == null) {
      return;
    }
    dfs(root.left, list);
    list.add(root);
    dfs(root.right, list);
  }
  // end::answer[]
}
