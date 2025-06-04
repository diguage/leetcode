package com.diguage.algo.leetcode;

import java.util.Arrays;

import static com.diguage.algo.leetcode._0116_PopulatingNextRightPointersInEachNode.Node;
import static com.diguage.algo.leetcode._0116_PopulatingNextRightPointersInEachNode.build;

public class _0117_PopulatingNextRightPointersInEachNodeII_3 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-04 21:38:37
   */
  public Node connect(Node root) {
    if (root == null) {
      return root;
    }
    Node cur = root;
    Node mostLeft = root;
    Node prev = null;
    while (cur != null) {
      // 寻找下一层最左节点
      if (cur == mostLeft || mostLeft == null) {
        mostLeft = cur.left;
        if (mostLeft == null) {
          mostLeft = cur.right;
        }
      }
      if (prev != null) {
        if (cur.left != null) {
          prev.next = cur.left;
          prev = prev.next;
        }
        if (cur.right != null) {
          prev.next = cur.right;
          prev = prev.next;
        }
      } else {
        if (cur.left != null) {
          prev = cur.left;
        }
        if (cur.right != null) {
          if (prev != null) {
            prev.next = cur.right;
            prev = prev.next;
          } else {
            prev = cur.right;
          }
        }
      }
      if (cur.next != null) {
        cur = cur.next;
      } else {
        cur = mostLeft;
        prev = null;
      }
    }
    return root;
  }
  // end::answer[]
  public static void main(String[] args) {
    Node tree = build(Arrays.asList(1, 2, 3, 4, 5, null, 7));
    Node node = new _0117_PopulatingNextRightPointersInEachNodeII_3().connect(tree);
    System.out.println(node);
  }
}
