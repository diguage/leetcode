package com.diguage.algorithm.leetcode;

import java.util.Arrays;

import static com.diguage.algorithm.leetcode._0116_PopulatingNextRightPointersInEachNode.Node;
import static com.diguage.algorithm.leetcode._0116_PopulatingNextRightPointersInEachNode.build;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-25 17:26:18
 */
public class _0117_PopulatingNextRightPointersInEachNodeII_21 {
  // tag::answer[]

  public Node connect(Node root) {
    if (root == null) {
      return null;
    }
    Node mostLeft = root;
    while (mostLeft != null) {
      Node cur = mostLeft;
      mostLeft = null;
      Node prev = null;
      while (cur != null) {
        if (cur.left != null) {
          // 不能保证左子树的最节点就一定有值
          // 所以，在运动中，寻找最左节点
          if (mostLeft == null) {
            mostLeft = cur.left;
          }
          // 由于不是完全二叉树，
          // 所以需要在运动中寻找不为空的节点
          if (prev != null) {
            prev.next = cur.left;
            prev = prev.next;
          } else {
            prev = cur.left;
          }
        }
        if (cur.right != null) {
          // 不能保证左子树的最节点就一定有值
          // 所以，在运动中，寻找最左节点
          if (mostLeft == null) {
            mostLeft = cur.right;
          }
          // 由于不是完全二叉树，
          // 所以需要在运动中寻找不为空的节点
          if (prev != null) {
            prev.next = cur.right;
            prev = prev.next;
          } else {
            prev = cur.right;
          }
        }
        cur = cur.next;
      }
    }
    return root;
  }

  // end::answer[]


  public static void main(String[] args) {
    Node tree = build(Arrays.asList(1, 2, 3, 4, 5, null, 7));
    _0117_PopulatingNextRightPointersInEachNodeII_21 solution = new _0117_PopulatingNextRightPointersInEachNodeII_21();
    solution.connect(tree);
    System.out.println(tree);
  }
}
