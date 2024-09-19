package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

import static com.diguage.algo.leetcode._0138_CopyListWithRandomPointer.Node;

public class _0138_CopyListWithRandomPointer_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-19 15:56:51
   */
  public Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }
    Map<Node, Node> nodeToRandomMap = new HashMap<>();
    Map<Node, Node> oldToNewMap = new HashMap<>();
    Node dummy = new Node(0);
    Node curr = head;
    Node tail = dummy;
    while (curr != null) {
      Node newNode = new Node(curr.val);
      oldToNewMap.put(curr, newNode);
      if (curr.random != null) {
        nodeToRandomMap.put(curr, curr.random);
      }
      tail.next = newNode;
      tail = newNode;
      curr = curr.next;
    }
    curr = head;
    while (curr != null) {
      if (curr.random != null) {
        Node newNode = oldToNewMap.get(curr);
        newNode.random = oldToNewMap.get(nodeToRandomMap.get(curr));
      }
      curr = curr.next;
    }
    return dummy.next;
  }
  // end::answer[]
}
