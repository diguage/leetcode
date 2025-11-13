package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.*;

public class _0094_BinaryTreeInorderTraversal_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-13 23:12:08
   */
  public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new LinkedList<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode peek = stack.peek();
      if (peek.left != null) {
        stack.push(peek.left);
        peek.left = null;
      } else {
        TreeNode pop = stack.pop();
        result.add(pop.val);
        if (pop.right != null) {
          stack.push(pop.right);
          pop.right = null;
        }
      }
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _0094_BinaryTreeInorderTraversal_3()
      .inorderTraversal(TreeNodes.buildTree(Arrays.asList(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9)));
  }

//  }
//  public List<Integer> inorderTraversal(TreeNode root) {
//    if (root == null) {
//      return Collections.emptyList();
//    }
//    List<Integer> result = new ArrayList<>();
//    inorder(root, result);
//    return result;
//  }
//
//  private void inorder(TreeNode root, List<Integer> result) {
//    if (root == null) {
//      return;
//    }
//    inorder(root.left, result);
//    result.add(root.val);
//    inorder(root.right, result);
//  }
}
