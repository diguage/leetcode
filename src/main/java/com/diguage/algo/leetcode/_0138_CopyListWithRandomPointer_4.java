package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0138_CopyListWithRandomPointer_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-10-13 23:10:52
   */
  public Node copyRandomList(Node head) {
    Node dummy = new Node(0);
    Map<Node, Node> o2n = new HashMap<Node, Node>();
    Node curr = head;
    Node prev = dummy;
    while (curr != null) {
      Node n = new Node(curr.val);
      o2n.put(curr, n);
      prev.next = n;
      prev = n;
      curr = curr.next;
    }
    curr = head;
    Node cn = dummy.next;
    while (curr != null) {
      cn.random = o2n.get(curr.random);
      curr = curr.next;
      cn = cn.next;
    }
    return dummy.next;
  }
  // end::answer[]

  static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }
}

