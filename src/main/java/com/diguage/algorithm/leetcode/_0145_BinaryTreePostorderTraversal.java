package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

import static com.diguage.algorithm.util.TreeNodeUtils.buildTree;

/**
 * = 145. Binary Tree Postorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-postorder-traversal/[Binary Tree Postorder Traversal - LeetCode]
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-06-16 11:24
 */
public class _0145_BinaryTreePostorderTraversal {

  public List<Integer> postorderTraversal(TreeNode head) {
    if (Objects.isNull(head)) {
      return Collections.emptyList();
    }
    List<Integer> result = new LinkedList<>();
    Stack<TreeNode> s1 = new Stack<>();
    Stack<TreeNode> s2 = new Stack<>();
    s1.push(head);
    TreeNode c = null;
    while (!s1.empty()) {
      head = s1.pop();
      s2.push(head);
      if (Objects.nonNull(head.left)) {
        s1.push(head.left);
      }
      if (Objects.nonNull(head.right)) {
        s1.push(head.right);
      }
    }
    while (!s2.empty()) {
      result.add(s2.pop().val);
    }
    return result;
  }

  public List<Integer> postorderTraversal1(TreeNode root) {
    if (Objects.isNull(root)) {
      return Collections.emptyList();
    }
    List<Integer> result = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    Set<TreeNode> deal = new HashSet<>();
    while (!stack.empty()) {
      boolean updated = false;
      TreeNode node = stack.peek();
      if (!deal.contains(node)) {
        if (Objects.nonNull(node.right)) {
          stack.push(node.right);
          updated = true;
        }
        if (Objects.nonNull(node.left)) {
          stack.push(node.left);
          updated = true;
        }
        deal.add(node);
        if (updated) {
          continue;
        }
      }
      node = stack.pop();
      result.add(node.val);
    }
    return result;

  }

  public static void main(String[] args) {
    TreeNode tree = buildTree(Arrays.asList(1, null, 2, null, null, 3));
    _0145_BinaryTreePostorderTraversal solution = new _0145_BinaryTreePostorderTraversal();
    List<Integer> result = solution.postorderTraversal(tree);
    System.out.println(result);
  }
}
