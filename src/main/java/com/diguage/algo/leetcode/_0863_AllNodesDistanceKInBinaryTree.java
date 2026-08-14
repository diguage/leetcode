package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0863_AllNodesDistanceKInBinaryTree {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-14 22:42:21
   */
  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    List<Integer> result = new ArrayList<>();
    List<TreeNode> path = findPath(root, target);
    for (int i = 0; i <= Math.min(path.size() - 1, k); i++) {
      dfs(path.get(i), result, k, i, path);
    }
    return result;
  }

  private List<TreeNode> findPath(TreeNode root, TreeNode target) {
    if (root == null) {
      return null;
    }
    if (root.val == target.val) {
      return new ArrayList<>(List.of(root));
    }
    List<TreeNode> left = findPath(root.left, target);
    if (left != null) {
      left.add(root);
      return left;
    }
    List<TreeNode> right = findPath(root.right, target);
    if (right != null) {
      right.add(root);
      return right;
    }
    return null;
  }

  private void dfs(TreeNode root, List<Integer> result,
                   int k, int depth, List<TreeNode> path) {
    if (root == null) {
      return;
    }
    if (depth == k) {
      result.add(root.val);
      return;
    }
    if (!path.contains(root.left)) {
      dfs(root.left, result, k, depth + 1, path);
    }
    if (!path.contains(root.right)) {
      dfs(root.right, result, k, depth + 1, path);
    }
  }
  // end::answer[]

  static void main() {
    new _0863_AllNodesDistanceKInBinaryTree()
      .distanceK(TreeNodes.buildTree(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)), new TreeNode(5), 2);
  }
}
