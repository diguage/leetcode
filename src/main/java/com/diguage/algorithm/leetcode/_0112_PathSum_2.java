package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.Objects;

import static com.diguage.algorithm.util.TreeNodeUtils.buildTree;
import static java.util.Arrays.asList;

/**
 * = 112. Path Sum
 *
 * https://leetcode.com/problems/path-sum/[Path Sum - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-20 15:15:50
 */
public class _0112_PathSum_2 {

    public boolean hasPathSum(TreeNode root, int sum) {
      if (Objects.isNull(root)) {
        return false;
      }
      if (root.val == sum && root.left == null && root.right == null) {
        return true;
      }
      return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        _0112_PathSum_2 solution = new _0112_PathSum_2();
        boolean r1 = solution.hasPathSum(buildTree(asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1)), 22);
        System.out.println(r1);
    }
}
