package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.*;

public class _0652_FindDuplicateSubtrees {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-20 22:08:01
   */
  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    Map<String, List<TreeNode>> numToNode = new HashMap<>();
    Set<TreeNode> result = new HashSet<>();
    // 先按层级进行分流
    dfs(root, numToNode);
    // 同一层级内的相互比较
    for (List<TreeNode> value : numToNode.values()) {
      if (value.size() == 1) {
        continue;
      }
      // 添加过就直接跳过，不再参与计算
      boolean[] used = new boolean[value.size()];
      for (int i = 0; i < value.size(); i++) {
        if (used[i]) {
          continue;
        }
        for (int j = i + 1; j < value.size(); j++) {
          if (used[j]) {
            continue;
          }
          if (isSame(value.get(i), value.get(j))) {
            used[i] = true;
            used[j] = true;
            result.add(value.get(i));
          }
        }
      }
    }
    return new ArrayList<>(result);
  }

  private int dfs(TreeNode root, Map<String, List<TreeNode>> numToNode) {
    if (Objects.isNull(root)) {
      return 0;
    }
    int ll = dfs(root.left, numToNode);
    int rl = dfs(root.right, numToNode);
    int level = Math.max(ll, rl) + 1;
    numToNode.computeIfAbsent(level + "/" + root.val, _ -> new ArrayList<>())
      .add(root);
    return level;
  }

  private boolean isSame(TreeNode root, TreeNode node) {
    if (Objects.isNull(root) && Objects.isNull(node)) {
      return true;
    }
    if ((Objects.nonNull(root) && Objects.nonNull(node) && root.val != node.val)
      || Objects.isNull(root)
      || Objects.isNull(node)) {
      return false;
    }
    boolean left = isSame(root.left, node.left);
    if (!left) {
      return false;
    }
    return isSame(root.right, node.right);
  }
  // end::answer[]
}
