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
    private final Node<Integer> head;
    private final Node<Integer> tail;
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
      Node<Integer> node = data.get(key);
      if (node == null) {
        return -1;
      }
      siftUp(node);
      return node.item;
    }

    public void put(int key, int value) {
      Node<Integer> node;
      if (data.containsKey(key)) {
        node = data.get(key);
        node.item = value;
        siftUp(node);
      } else {
        node = new Node<>(key, value);
        data.put(key, node);
        addNode(node);
      }
      if (data.size() > capacity) {
        Node<Integer> removing = tail.prev;
        removeNode(removing);
        data.remove(removing.key);
      }
    }

    private void siftUp(Node<Integer> node) {
      // 如果是第一个节点，则不需要处理
      if (head == node.prev) {
        return;
      }
      // 将当前访问节点放在链表最前面
      // 先删除
      removeNode(node);
      // 再添加
      addNode(node);
    }

    private void addNode(Node<Integer> node) {
      node.next = head.next;
      node.prev = head;

      head.next.prev = node;
      head.next = node;
    }

    private void removeNode(Node<Integer> node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
      node.prev = null;
      node.next = null;
    }

    static class Node<E> {
      E key;
      E item;
      Node<E> next;
      Node<E> prev;

      Node() {
      }

      Node(E key, E element) {
        this.key = key;
        this.item = element;
      }
    }
  }
  // end::answer[]
}
