package com.diguage.algo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import static com.diguage.algo.leetcode._0116_PopulatingNextRightPointersInEachNode.Node;


public class _0117_PopulatingNextRightPointersInEachNodeII_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-06-25 17:26:18
   */
  public Node connect(Node root) {
    if (root == null) {
      return null;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      Node pre = null;
      for (int i = 0; i < size; i++) {
        Node cur = queue.poll();
        if (pre != null) {
          pre.next = cur;
        }
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
        pre = cur;
      }
    }
    return root;
  }
  // end::answer[]
}
