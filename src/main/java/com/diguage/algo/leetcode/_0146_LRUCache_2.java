package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0146_LRUCache_2 {
  // tag::answer[]

  /**
   * 最近最少使用缓存
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-01 23:28:56
   */
  class LRUCache {

    private Map<Integer, Node<Integer>> data;
    private Node<Integer> head;
    private Node<Integer> tail;
    private int capacity;

    public LRUCache(int capacity) {
      head = new Node<>();
      tail = new Node<>();
      head.next = tail;
      tail.prev = head;
      data = new HashMap<>(capacity);
      this.capacity = capacity;
    }

    public int get(int key) {
      Node<Integer> node = data.getOrDefault(key, null);
      if (node == null) {
        return -1;
      }
      siftUp(node);
      return node.item;
    }

    private void siftUp(Node<Integer> node) {
      // 将当前访问节点放在链表最前面
      node.prev.next = node.next;
      node.next.prev = node.prev;

      node.next = head.next;
      node.prev = head;

      head.next.prev = node;
      head.next = node;

    }

    public void put(int key, int value) {
      Node<Integer> node;
      if (data.containsKey(key)) {
        node = data.get(key);
        node.item = value;
        siftUp(node);
      } else {
        node = new Node<>(head, key, value, head.next);
        data.put(key, node);
        head.next.prev = node;
        head.next = node;
      }
      if (data.size() > capacity) {
        Node<Integer> removing = tail.prev;
        removing.prev.next = tail;
        tail.prev = removing.prev;

        removing.prev = null;
        removing.next = null;

        data.remove(removing.key);
      }
    }

    static class Node<E> {
      E key;
      E item;
      Node<E> next;
      Node<E> prev;

      Node() {
      }

      Node(Node<E> prev, E key, E element, Node<E> next) {
        this.key = key;
        this.item = element;
        this.next = next;
        this.prev = prev;
      }
    }
  }
  // end::answer[]
}
