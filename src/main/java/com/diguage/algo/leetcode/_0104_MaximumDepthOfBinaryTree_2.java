package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

/**
 * = 104. Maximum Depth of Binary Tree
 *
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/[Maximum Depth of Binary Tree - LeetCode]
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * *Note:* A leaf is a node with no children.
 *
 * *Example:*
 *
 * Given binary tree `[3,9,20,null,null,15,7]`,
 *
 * ----
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * ----
 *
 * return its depth = 3.
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-30 22:09:09
 */
public class _0104_MaximumDepthOfBinaryTree_2 {
  // tag::answer[]

    /**
     * 后根遍历既可以访问父节点，又可以从返回值中获取想要的信息，
     * 比如深度，子节点等等。
     */
    public int maxDepth(TreeNode root) {
      if (root == null) {
        return 0;
      }
      int left = maxDepth(root.left);
      int right = maxDepth(root.right);
      return Math.max(left, right) + 1;
    }
  // end::answer[]
}
