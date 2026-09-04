package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _0919_CompleteBinaryTreeInserter {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-05 00:14:07
   */
  class CBTInserter {
    private TreeNode root;
    private Queue<TreeNode> queue = new LinkedList<>();

    public CBTInserter(TreeNode root) {
      this.root = root;
    }

    public int insert(int val) {
      if (queue.isEmpty()) {
        queue.offer(root);
        while (true) {
          int size = queue.size();
          Queue<TreeNode> next = new LinkedList<>();
          for (int i = 0; i < size; i++) {
            TreeNode node = queue.peek();
            if (node.left == null || node.right == null) {
              break;
            } else {
              queue.poll();
              next.offer(node.left);
              next.offer(node.right);
            }
          }
          if (queue.isEmpty()) {
            queue.addAll(next);
          } else {
            break;
          }
        }
      }
      TreeNode peek = queue.peek();
      if (peek.left == null) {
        peek.left = new TreeNode(val);
      } else {
        peek.right = new TreeNode(val);
        queue.poll();
      }
      return peek.val;
    }

    public TreeNode get_root() {
      return root;
    }
  }
  // end::answer[]
//  static void main() {
//    CBTInserter tree = new CBTInserter(TreeNodes.buildTree(1, 2));
//    System.out.println(tree.insert(3));
//    System.out.println(tree.insert(4));
//    System.out.println(tree.get_root().val);
//  }
}
