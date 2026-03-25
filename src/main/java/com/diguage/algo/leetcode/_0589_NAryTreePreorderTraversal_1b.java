package com.diguage.algo.leetcode;

import java.util.*;

public class _0589_NAryTreePreorderTraversal_1b {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-25 21:11
   */
  public List<Integer> preorder(Node root) {
    if (Objects.isNull(root)) {
      return Collections.emptyList();
    }
    List<Integer> result = new ArrayList<>();
    Deque<Node> stack = new ArrayDeque<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      Node node = stack.pop();
      result.add(node.val);
      if (Objects.nonNull(node.children)) {
        for (int i = node.children.size() - 1; i >= 0; i--) {
          stack.push(node.children.get(i));
        }
      }
    }
    return result;
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
