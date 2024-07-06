package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.Objects;

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
public class _0111_MinimumDepthOfBinaryTree {
  // tag::answer[]

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Depth of Binary Tree.
     * Memory Usage: 40.1 MB, less than 48.44% of Java online submissions for Minimum Depth of Binary Tree.
     */
    public int minDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        if (Objects.nonNull(root.left)) {
            min = Math.min(minDepth(root.left), min);
        }
        if (Objects.nonNull(root.right)) {
            min = Math.min(minDepth(root.right), min);
        }
        return min + 1;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0111_MinimumDepthOfBinaryTree solution = new _0111_MinimumDepthOfBinaryTree();
        int r1 = solution.minDepth(buildTree(asList(3, 9, 20, null, null, 15, 7)));
        System.out.println((r1 == 2) + " : " + r1);
    }
}
