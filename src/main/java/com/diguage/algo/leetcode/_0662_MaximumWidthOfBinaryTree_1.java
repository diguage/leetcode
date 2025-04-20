package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class _0662_MaximumWidthOfBinaryTree_1 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-20 21:37:22
   */
  public int widthOfBinaryTree(TreeNode root) {
    Deque<Pair<TreeNode, Integer>> nodes = new LinkedList<>();
    int result = 0;
    nodes.add(new Pair<>(root, 1));
    while (!nodes.isEmpty()) {
      result = Math.max(result,
        nodes.getLast().value - nodes.getFirst().value + 1);
      int size = nodes.size();
      for (int i = 0; i < size; i++) {
        Pair<TreeNode, Integer> pair = nodes.poll();
        if (pair.key.left != null) {
          nodes.offer(new Pair<>(pair.key.left, pair.value * 2));
        }
        if (pair.key.right != null) {
          nodes.offer(new Pair<>(pair.key.right, pair.value * 2 + 1));
        }
      }
    }
    return result;
  }

  private static class Pair<K, V> {
    K key;
    V value;

    public Pair(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }
  // end::answer[]
}
