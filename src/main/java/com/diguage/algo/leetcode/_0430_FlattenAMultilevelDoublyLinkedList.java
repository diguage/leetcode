package com.diguage.algo.leetcode;

public class _0430_FlattenAMultilevelDoublyLinkedList {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-13 22:12:36
   */
  public Node flatten(Node head) {
    Node dummy = new Node();
    dummy.next = head;
    while (head != null) {
      if (head.child == null) {
        head = head.next;
      } else {
        Node temp = head.next;
        // 由于 flatten 返回 head，导致每个子元素最多要被访问 h 次
        // 可以优化一下，返回 tail，这样每个元素只需要访问一次。
        Node chead = flatten(head.child);
        head.next = chead;
        chead.prev = head;
        head.child = null;
        while (head.next != null) {
          head = head.next;
        }
        head.next = temp;
        if (temp != null) {
          temp.prev = head;
        }
        head = temp;
      }
    }
    return dummy.next;
  }
  // end::answer[]
  public static class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }
  }

  public static void main(String[] args) {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    n1.next = n2;
    n2.prev = n1;
    Node n3 = new Node(3);
    n2.next = n3;
    n3.prev = n2.prev;
    Node n4 = new Node(4);
    n3.next = n4;
    n4.prev = n3;
    Node n5 = new Node(5);
    n4.next = n5;
    n5.prev = n4;
    Node n6 = new Node(6);
    n5.next = n6;
    n6.prev = n5;
    Node n7 = new Node(7);
    n3.child = n7;
    Node n8 = new Node(8);
    n7.next = n8;
    n8.prev = n7;
    Node n9 = new Node(9);
    n8.next = n9;
    n9.prev = n8;
    Node n10 = new Node(10);
    n9.next = n10;
    n10.prev = n9;
    Node n11 = new Node(11);
    n8.child = n11;
    Node n12 = new Node(12);
    n11.child = n12;
    n12.prev = n11;
    new _0430_FlattenAMultilevelDoublyLinkedList().flatten(n1);
  }
}
