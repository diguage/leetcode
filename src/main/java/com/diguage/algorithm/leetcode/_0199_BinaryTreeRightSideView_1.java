package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.*;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-25 14:44:16
 */
public class _0199_BinaryTreeRightSideView_1 {
  /**
   * 参考 https://leetcode.cn/problems/binary-tree-right-side-view/solutions/2015061/ru-he-ling-huo-yun-yong-di-gui-lai-kan-s-r1nc/[199. 二叉树的右视图 - 【视频】如何灵活运用递归？^]
   */
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    dfs(root, 0, result);
    return result;
  }

  private void dfs(TreeNode root, int level, List<Integer> result) {
    if (root == null) {
      return;
    }
    // 这个深度首次遇到
    if (level == result.size()) {
      result.add(root.val);
    }
    // 先递归右子树，保证首次遇到的一定是最右边的节点
    dfs(root.right, level + 1, result);
    dfs(root.left, level + 1, result);
  }
}
