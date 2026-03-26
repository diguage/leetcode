package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class _0590_NAryTreePostorderTraversal_1a {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-26 20:24:47
   */
  public List<Integer> postorder(Node root) {
    List<Integer> result = new ArrayList<>();
    dfs(root, result);
    return result;
  }

  private void dfs(Node root, List<Integer> result) {
    if (Objects.isNull(root)) {
      return;
    }
    if (Objects.nonNull(root.children)) {
      for (Node child : root.children) {
        dfs(child, result);
      }
    }
    result.add(root.val);
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
