package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class _0589_NAryTreePreorderTraversal_1a {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-25 21:05:45
   */
  public List<Integer> preorder(Node root) {
    List<Integer> result = new ArrayList<>();
    dfs(root, result);
    return result;
  }

  private void dfs(Node root, List<Integer> values) {
    if (Objects.isNull(root)) {
      return;
    }
    values.add(root.val);
    if (Objects.isNull(root.children)) {
      return;
    }
    for (Node child : root.children) {
      dfs(child, values);
    }
  }
  // end::answer[]
  private static class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }
}
