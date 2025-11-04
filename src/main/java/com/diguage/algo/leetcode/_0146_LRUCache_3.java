package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0146_LRUCache_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-04 19:44:13
   */
  class LRUCache {
    private final ListNode head;
    private final ListNode tail;
    private final int capacity;
    private Map<Integer, ListNode> map = new HashMap<>();

    public LRUCache(int capacity) {
      head = new ListNode();
      tail = new ListNode();
      head.next = tail;
      tail.prev = head;
      this.capacity = capacity;
      map = new HashMap<>();
    }

    public int get(int key) {
      if (!map.containsKey(key)) {
        return -1;
      }
      ListNode node = map.get(key);
      deleteNode(node);
      addAtHead(node);
      return node.value;
    }

    public void put(int key, int value) {
      ListNode node;
      if (map.containsKey(key)) {
        node = map.get(key);
        node.value = value;
        deleteNode(node);
      } else {
        node = new ListNode(key, value);
      }
      addAtHead(node);
      if (map.size() > capacity) {
        deleteNode(tail.prev);
      }
    }

    private void addAtHead(ListNode node) {
      node.prev = head;
      node.next = head.next;
      head.next = node;
      node.next.prev = node;
      map.put(node.key, node);
    }

    private void deleteNode(ListNode node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
      map.remove(node.key);
    }

    private static class ListNode {
      int key;
      int value;
      ListNode prev;
      ListNode next;

      public ListNode() {
      }

      public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
      }
    }
  }
  // end::answer[]
//
//  static void main() {
//    LRUCache cache = new LRUCache(2);
//    cache.put(1, 1);
//    cache.put(2, 2);
//    cache.get(1);
//    cache.put(3, 3);
//    cache.get(2);
//    cache.put(4, 4);
//    cache.get(1);
//    cache.get(3);
//    cache.get(4);
//  }
}
