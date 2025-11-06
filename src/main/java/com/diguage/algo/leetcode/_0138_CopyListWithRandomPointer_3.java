package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0138_CopyListWithRandomPointer_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-06 22:27:13
   */
  public Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }
    Map<Node, Node> map = new HashMap<>();
    Node curr = head;
    while (curr != null) {
      map.put(curr, new Node(curr.val));
      curr = curr.next;
    }
    curr = head;
    while (curr != null) {
      Node node = map.get(curr);
      node.next = map.get(curr.next);
      node.random = map.get(curr.random);
      curr = curr.next;
    }
    return map.get(head);
  }

  // end::answer[]
  private static class Node {
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
