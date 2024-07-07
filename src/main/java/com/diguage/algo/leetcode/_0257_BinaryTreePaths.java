package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
  * @author D瓜哥 · https://www.diguage.com
  * @since 2024-06-25 20:59:38
  */
public class _0257_BinaryTreePaths {
  // tag::answer[]

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();
    backtrack(root, result, new ArrayList<>());
    return result;
  }

  private void backtrack(TreeNode root, List<String> result, List<Integer> chars) {
    if (root == null) {
      return;
    }
    chars.add(root.val);
    if (root.left == null && root.right == null) {
      result.add(chars.stream().map(String::valueOf)
        .collect(Collectors.joining("->")));
    }
    backtrack(root.left, result, chars);
    backtrack(root.right, result, chars);
    chars.remove(chars.size() - 1);
  }
  // end::answer[]
}
