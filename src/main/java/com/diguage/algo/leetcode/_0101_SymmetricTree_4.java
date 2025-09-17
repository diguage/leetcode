package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.LinkedList;
import java.util.List;

public class _0101_SymmetricTree_4 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2020-01-24 20:40
   */
  public boolean isSymmetric(TreeNode root) {
    if (!isSymmetric(root.left, root.right)) {
      return false;
    }
    if (root.left == null) {
      return true;
    }
    List<TreeNode> level = new LinkedList<>();
    level.addFirst(root.left);
    level.addLast(root.right);
    List<TreeNode> nextLevel = new LinkedList<>();
    while (!level.isEmpty()) {
      TreeNode left = level.removeFirst();
      TreeNode right = level.removeLast();
      if (isSymmetric(left.left, right.right)) {
        if (left.left != null) {
          nextLevel.addFirst(left.left);
          nextLevel.addLast(right.right);
        }
      } else {
        return false;
      }
      if (isSymmetric(left.right, right.left)) {
        if (left.right != null) {
          nextLevel.addFirst(left.right);
          nextLevel.addLast(right.left);
        }
      } else {
        return false;
      }
      if (level.isEmpty()) {
        level = nextLevel;
        nextLevel = new LinkedList<>();
      }
    }
    return true;
  }

  private boolean isSymmetric(TreeNode left, TreeNode right) {
    return left == null && right == null
      || null != left && null != right && left.val == right.val;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0101_SymmetricTree_4().
      isSymmetric(TreeNodes.buildTree(1, 2, 2, 3, 4, 4, 3));
  }
}
