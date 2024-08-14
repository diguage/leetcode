package com.diguage.algo.leetcode;

import java.util.Objects;

public class _1650_LowestCommonAncestorOfABinaryTreeIII {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-26 20:00:58
   */
  public Node lowestCommonAncestor(Node p, Node q) {
    if (Objects.isNull(p) || Objects.isNull(q)) {
      return null;
    }
    Node a = p;
    Node b = q;
    while (a != b) {
      if (a == null) {
        a = q;
      } else {
        a = a.parent;
      }
      if (b == null) {
        b = p;
      } else {
        b = b.parent;
      }
    }
    return a;
  }
  // end::answer[]

  public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;

    public Node() {
    }

    public Node(int x) {
      val = x;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Node node = (Node) o;
      return val == node.val;
    }

    @Override
    public int hashCode() {
      return Objects.hash(val);
    }
  }
}
