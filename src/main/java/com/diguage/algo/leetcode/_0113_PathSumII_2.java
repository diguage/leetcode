package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.*;

import static com.diguage.util.TreeNodes.buildTree;
import static java.util.Arrays.asList;

/**
 * = 113. Path Sum II
 *
 * https://leetcode.com/problems/path-sum-ii/[Path Sum II - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-07 22:31
 */
public class _0113_PathSumII_2 {
  // tag::answer[]

    /**
     * 原始解法
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
      if (root == null) {
        return Collections.emptyList();
      }
      List<List<Integer>> result = new ArrayList<>();
      pathSum(root, sum, result, new ArrayList<>());
      return result;
    }

  private void pathSum(TreeNode root, int sum, List<List<Integer>> result, List<Integer> path) {
    if (root == null) {
      return;
    }
    int nextSum = sum - root.val;
    if (nextSum == 0 && root.left == null && root.right == null) {
      path.add(root.val);
      result.add(path);
    } else {
      // 这里每次都需要创建 List 对象，可以优化一下
      ArrayList<Integer> lp = new ArrayList<>(path);
      lp.add(root.val);
      pathSum(root.left, nextSum, result, lp);

      // 这里每次都需要创建 List 对象，可以优化一下
      ArrayList<Integer> rp = new ArrayList<>(path);
      rp.add(root.val);
      pathSum(root.right, nextSum, result, rp);
    }
  }

  // end::answer[]


    public static void main(String[] args) {
        _0113_PathSumII_2 solution = new _0113_PathSumII_2();
        List<List<Integer>> r1 = solution.pathSum(buildTree(asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1)), 22);
        System.out.println(r1);
    }
}
