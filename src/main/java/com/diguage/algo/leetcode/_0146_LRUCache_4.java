package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0146_LRUCache_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-29 23:22:19
   */
  public class LRUCache {
    private int capacity;
    private final Node header;
    private final Node footer;
    private Map<Integer, Node> nodes;
    private int size;

    public LRUCache(int capacity) {
      this.capacity = capacity;
      header = new Node();
      footer = new Node();
      header.next = footer;
      footer.pre = header;
      nodes = new HashMap<>();
      size = 0;
    }

    public int get(int key) {
      Node node = nodes.get(key);
      if (node == null) {
        return -1;
      }
      // 一个优化点：node.pre是header，就不用在操作了。
      if (node.pre == header) {
        return node.value;
      }
      delete(node);
      insert(node);
      return node.value;
    }

    public void put(int key, int value) {
      Node node = nodes.get(key);
      if (node == null) {
        size++;
        node = new Node(key, value);
        nodes.put(key, node);
        insert(node);
        if (size > capacity) {
          Node deleted = footer.pre;
          nodes.remove(deleted.key);
          delete(deleted);
          size--;
        }
      } else {
        node.value = value;
        delete(node);
        insert(node);
      }
    }

    private void insert(Node node) {
      node.next = header.next;
      node.pre = header;
      header.next = node;
      node.next.pre = node;
    }

    private void delete(Node node) {
      node.pre.next = node.next;
      node.next.pre = node.pre;
    }

    private static class Node {
      int key;
      int value;
      Node pre;
      Node next;

      public Node() {
      }

      public Node(int key, int value) {
        this.key = key;
        this.value = value;
      }
    }
  }
  // end::answer[]
}
