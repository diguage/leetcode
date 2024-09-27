package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class _1110_DeleteNodesAndReturnForest {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-27 15:06:39
   */
  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    List<TreeNode> result = new ArrayList<>();
    Set<Integer> deletes = Arrays.stream(to_delete)
      .boxed().collect(Collectors.toUnmodifiableSet());
    TreeNode tree = dfs(root, deletes, result);
    if (tree != null) {
      result.add(tree);
    }
    return result;
  }

  private TreeNode dfs(TreeNode root, Set<Integer> deletes, List<TreeNode> result) {
    if (root == null) {
      return null;
    }
    TreeNode left = dfs(root.left, deletes, result);
    TreeNode right = dfs(root.right, deletes, result);
    if (deletes.contains(root.val)) {
      if (left != null) {
        result.add(left);
      }
      if (right != null) {
        result.add(right);
      }
      return null;
    } else {
      if (left == null) {
        root.left = null;
      }
      if (right == null) {
        root.right = null;
      }
      return root;
    }
  }
  // end::answer[]
}
