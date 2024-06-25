package com.diguage.algorithm.leetcode;

import java.util.*;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-25 15:17:45
 */
public class _0429_NAryTreeLevelOrderTraversal {
  public List<List<Integer>> levelOrder(Node root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<List<Integer>> result = new ArrayList<>();
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> level = new ArrayList<>(size);
      for (int i = 0; i < size; i++) {
        Node node = queue.poll();
        level.add(node.val);
        if (node.children != null) {
          node.children.forEach(queue::offer);
        }
      }
      result.add(level);
    }
    return result;
  }

  static class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }
}
