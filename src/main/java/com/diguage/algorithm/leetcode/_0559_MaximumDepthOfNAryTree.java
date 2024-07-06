package com.diguage.algorithm.leetcode;

import java.util.List;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-25 18:12:21
 */
public class _0559_MaximumDepthOfNAryTree {
  // tag::answer[]
  public int maxDepth(Node root) {
    if (root == null) {
      return 0;
    }
    if (root.children == null || root.children.isEmpty()) {
      return 1;
    }
    int maxDepth = Integer.MIN_VALUE;
    for (Node child : root.children) {
      maxDepth = Math.max(maxDepth, maxDepth(child));
    }
    return maxDepth + 1;
  }

  static class Node {
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
  // end::answer[]
}
