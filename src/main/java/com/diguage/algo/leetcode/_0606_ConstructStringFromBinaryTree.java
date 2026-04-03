package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.Objects;

public class _0606_ConstructStringFromBinaryTree {
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-03 08:56:49
   */
  public String tree2str(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    dfs(root, sb);
    return sb.toString();
  }

  private void dfs(TreeNode root, StringBuilder sb) {
    if (Objects.isNull(root)) {
      return;
    }
    sb.append(root.val);

    // 只要有子节点，都需要输出左子树对应的括号
    if (Objects.nonNull(root.left) || Objects.nonNull(root.right)) {
      sb.append("(");
      dfs(root.left, sb);
      sb.append(")");
    }

    if (Objects.nonNull(root.right)) {
      sb.append("(");
      dfs(root.right, sb);
      sb.append(")");
    }
  }
  // end::answer[]
}
