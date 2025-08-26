package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0460_LfuCache {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-26 22:05:19
   */
  static class LFUCache {
    private int capacity;
    private Map<Integer, Node> keyToData;
    private final Node HEAD;
    private final Node TAIL;
    private Map<Integer, Node> countToNode;

    public LFUCache(int capacity) {
      this.capacity = capacity;
      this.keyToData = new HashMap<>();
      countToNode = new HashMap<>();
      HEAD = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
      TAIL = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE, 1);
      HEAD.next = TAIL;
      TAIL.prev = HEAD;
      countToNode.put(1, TAIL);
    }

    public int get(int key) {
      Node node = keyToData.get(key);
      if (node == null) {
        return -1;
      }
      updateList(node);
      return node.value;
    }

    public void put(int key, int value) {
      Node node = keyToData.get(key);
      if (node == null) {
        if (keyToData.size() == capacity) {
          deleteNode(TAIL.prev);
        }
        node = new Node(key, value);
      }
      node.value = value;
      updateList(node);
    }

    private void updateList(Node node) {
      Node prev = getPrevNode(node);
      if (node.next != null) {
        Node next = node.next;
        if (next.count == node.count) {
          countToNode.put(next.count, next);
        } else {
          countToNode.remove(node.count);
        }
      } else {
        countToNode.remove(node.count);
      }
      putAfter(prev, node);
    }

    private Node getPrevNode(Node node) {
      Node next = countToNode.get(node.count + 1);
      if (next == null) {
        next = countToNode.get(node.count);
      }
      return next.prev;
    }

    private void deleteNode(Node node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
      keyToData.remove(node.key);
      if (node.next != null) {
        if (node.next.count == node.count) {
          countToNode.put(node.next.count, node.next);
        } else {
          countToNode.remove(node.count);
        }
      }
    }

    private void putAfter(Node prev, Node node) {
      node.count++;
      node.time = System.currentTimeMillis();
      if (node.prev != null) {
        node.prev.next = node.next;
      }
      if (node.next != null) {
        node.next.prev = node.prev;
      }
      node.prev = prev;
      Node next = prev.next;
      node.next = next;
      next.prev = node;
      prev.next = node;
      keyToData.put(node.key, node);

      countToNode.put(node.count, node);
    }

    private static class Node {
      int key;
      int value;
      long time;
      int count;
      Node prev;
      Node next;

      public Node(int key, int value) {
        this(key, value, 0);
      }

      public Node(int key, int value, int count) {
        this.key = key;
        this.value = value;
        this.count = count;
        this.time = System.currentTimeMillis();
      }
    }
  }
  // end::answer[]

  public static void main(String[] args) {
    LFUCache cache = new LFUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);
    cache.put(3, 3);
    cache.get(2);
    cache.get(3);
    cache.put(4, 4);
    cache.get(1);
    cache.get(3);
    cache.get(4);

//    LFUCache cache = new LFUCache(3);
//    cache.put(1, 1);
//    cache.put(2, 2);
//    cache.put(3, 3);
//    cache.put(4, 4);
//    cache.get(4);
//    cache.get(3);
//    cache.get(2);
//    cache.get(1);
//    cache.put(5, 5);
//    cache.get(1);
//    cache.get(2);
//    cache.get(3);
//    cache.get(4);
//    cache.get(5);
  }
}
