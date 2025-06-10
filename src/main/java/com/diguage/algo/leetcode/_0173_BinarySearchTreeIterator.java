package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _0173_BinarySearchTreeIterator {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-10 20:13:13
   */
  class BSTIterator {
    Deque<TreeNode> stack = new LinkedList<>();

    public BSTIterator(TreeNode root) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
    }

    public int next() {
      TreeNode node = stack.pop();
      TreeNode curr = node.right;
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      return node.val;
    }

    public boolean hasNext() {
      return !stack.isEmpty();
    }
  }
  // end::answer[]
  public static void main(String[] args) {
    BSTIterator iterator = new _0173_BinarySearchTreeIterator()
      .new BSTIterator(TreeNodes.buildTree(Arrays.asList(4, 2, 6, 1, 3, 5, 7)));
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
