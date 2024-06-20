package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.Arrays;

import static com.diguage.algorithm.util.TreeNodeUtils.buildTree;

/**
 * = 437. Path Sum III
 *
 * https://leetcode.com/problems/path-sum-iii/[Path Sum III - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-28 23:06
 */
public class _0437_PathSumIII_21 {
  /**
   */
  public int pathSum(TreeNode root, long sum) {
    if (root == null) {
      return 0;
    }
    return rootSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
  }

  public int rootSum(TreeNode root, long sum) {
    int result = 0;
    if (root == null) {
      return result;
    }
    int val = root.val;
    if (sum == val) {
      result++;
    }
    result += rootSum(root.left, sum - val);
    result += rootSum(root.right, sum - val);
    return result;
  }

  public static void main(String[] args) {
    _0437_PathSumIII_21 solution = new _0437_PathSumIII_21();
    long r1 = solution.pathSum(buildTree(Arrays.asList(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1)), 8);
    System.out.println((r1 == 3) + " : " + r1);
  }
}
