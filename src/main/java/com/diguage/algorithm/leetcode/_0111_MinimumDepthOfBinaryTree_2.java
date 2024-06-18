package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.Objects;

import static com.diguage.algorithm.util.TreeNodeUtils.buildTree;
import static java.util.Arrays.asList;

/**
 * = 111. Minimum Depth of Binary Tree
 *
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/[Minimum Depth of Binary Tree - LeetCode]
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-02-07 21:26
 */
public class _0111_MinimumDepthOfBinaryTree_2 {

    public int minDepth(TreeNode root) {
      if (Objects.isNull(root)) {
        return 0;
      }
      if (root.left == null && root.right == null) {
        return 1;
      }
      int result = Integer.MAX_VALUE;
      if (Objects.nonNull(root.left)) {
        result = Math.min(result, minDepth(root.left));
      }
      if (Objects.nonNull(root.right)) {
        result = Math.min(result, minDepth(root.right));
      }
      return result + 1;
    }

    public static void main(String[] args) {
        _0111_MinimumDepthOfBinaryTree_2 solution = new _0111_MinimumDepthOfBinaryTree_2();
        int r1 = solution.minDepth(buildTree(asList(3, 9, 20, null, null, 15, 7)));
        System.out.println((r1 == 2) + " : " + r1);
    }
}
