package com.diguage.algo.leetcode;

public class _0707_DesignLinkedList {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-22 14:50:41
   */
  static class MyLinkedList {
    private final ListNode HEAD;
    private final ListNode TAIL;
    private int size;

    public MyLinkedList() {
      HEAD = new ListNode(0);
      TAIL = new ListNode(0);
      HEAD.next = TAIL;
      TAIL.prev = HEAD;
      size = 0;
    }

    public int get(int index) {
      ListNode node = getNode(index, false);
      if (node == null) {
        return -1;
      } else {
        return node.val;
      }
    }

    public void addAtHead(int val) {
      addNode(HEAD, val);
      size++;
    }

    public void addAtTail(int val) {
      addNode(TAIL.prev, val);
      size++;
    }

    public void addAtIndex(int index, int val) {
      ListNode node = getNode(index, true);
      if (node != null) {
        addNode(node.prev, val);
        size++;
      }
    }

    public void deleteAtIndex(int index) {
      ListNode node = getNode(index, false);
      if (node != null) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
      }
    }

    private ListNode getNode(int index, boolean lager) {
      if (index < 0 || lager ? index > size : index >= size) {
        return null;
      }
      // 如果索引等于链表大小，则直接返回尾部
      if (index == size) {
        return TAIL;
      }
      ListNode cur = null;
      if (index > size / 2) {
        cur = TAIL.prev;
        for (int i = 0; i < size - index - 1; i++) {
          cur = cur.prev;
        }
      } else {
        cur = HEAD.next;
        for (int i = 0; i < index; i++) {
          cur = cur.next;
        }
      }
      return cur;
    }

    private void addNode(ListNode prev, int val) {
      ListNode node = new ListNode(val);
      ListNode next = prev.next;
      node.next = next;
      node.prev = prev;
      prev.next = node;
      next.prev = node;
    }

    private static class ListNode {
      public int val;
      public ListNode next;
      public ListNode prev;

      public ListNode(int x) {
        val = x;
      }
    }
  }

  // end::answer[]
  public static void main(String[] args) {
    MyLinkedList list = new MyLinkedList();
    // "addAtHead","addAtIndex","get","addAtHead","addAtTail","get","addAtTail","get","addAtHead","get","addAtHead"
    //  [5],        [1,2],       [1],  [6],        [2],        [3],  [1],        [5],  [2],        [2],  [6]
    list.addAtHead(5);
    list.addAtIndex(1, 2);
    list.get(1);
    list.addAtHead(6);
    list.addAtTail(2);
    list.get(3);
    list.addAtTail(1);
    list.get(5);
    list.addAtHead(2);
    list.get(2);
    list.addAtHead(6);

//    // "addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"
//    //  [7],        [2],        [1],        [3,0],       [2],            [6],        [4],        [4],  [4],        [5,0],       [6]]
//    list.addAtHead(7);
//    list.addAtHead(2);
//    list.addAtHead(1);
//    list.addAtIndex(3, 0);
//    list.deleteAtIndex(2);
//    list.addAtHead(6);
//    list.addAtTail(4);
//    list.get(4);
//    list.addAtHead(4);
//    list.addAtIndex(5, 0);
//    list.addAtHead(6);
  }
}
