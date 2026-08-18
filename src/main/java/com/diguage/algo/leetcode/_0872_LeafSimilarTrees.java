package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class _0872_LeafSimilarTrees {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-18 21:33:57
   */
  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<TreeNode> first = getLeaves(root1);
    List<TreeNode> second = getLeaves(root2);
    if (first.size() != second.size()) {
      return false;
    }
    for (int i = 0; i < first.size(); i++) {
      if (first.get(i).val != second.get(i).val) {
        return false;
      }
    }
    return true;
  }

  private List<TreeNode> getLeaves(TreeNode root) {
    if (Objects.isNull(root)) {
      return new ArrayList<>();
    }
    List<TreeNode> result = new LinkedList<>(List.of(root));
    boolean hasNext = true;
    while (hasNext) {
      hasNext = false;
      List<TreeNode> next = new ArrayList<>();
      while (!result.isEmpty()) {
        TreeNode node = result.removeFirst();
        if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
          next.add(node);
        } else {
          if (Objects.nonNull(node.left)) {
            next.add(node.left);
          }
          if (Objects.nonNull(node.right)) {
            next.add(node.right);
          }
          hasNext = true;
        }
      }
      result = next;
    }
    return result;
  }
  // end::answer[]
}
