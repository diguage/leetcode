package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static com.diguage.util.TreeNodes.buildTree;
import static java.util.Arrays.asList;

/**
 * = 111. Minimum Depth of Binary Tree
 *
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/[Minimum Depth of Binary Tree - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-07 21:26
 */
public class _0111_MinimumDepthOfBinaryTree_BFS {
  // tag::answer[]

  /**
   * 参考左程云《程序员代码面试指南》的解法
   */
  public int minDepth(TreeNode head) {
    if (head == null) {
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(head);
    int depth = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      depth++;
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (node.left == null && node.right == null) {
          return depth;
        } else {
          if (node.left != null) {
            queue.offer(node.left);
          }
          if (node.right != null) {
            queue.offer(node.right);
          }
        }
      }
    }
    return depth;
  }

  // end::answer[]


  public static void main(String[] args) {
    _0111_MinimumDepthOfBinaryTree_BFS solution = new _0111_MinimumDepthOfBinaryTree_BFS();
    int r1 = solution.minDepth(buildTree(asList(3, 9, 20, null, null, 15, 7)));
    System.out.println((r1 == 2) + " : " + r1);
  }
}
