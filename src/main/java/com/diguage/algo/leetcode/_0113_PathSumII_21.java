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
public class _0113_PathSumII_21 {
  // tag::answer[]

    /**
     * 原始解法
     *
     * @author D瓜哥 · https://www.diguage.com
     * @since 2020-02-07 22:31
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
      if (root == null) {
        return Collections.emptyList();
      }
      List<List<Integer>> result = new ArrayList<>();
      Deque<Integer> path = new LinkedList<>();
      pathSum(root, sum, result, path);
      return result;
    }

  private void pathSum(TreeNode root, int sum, List<List<Integer>> result, Deque<Integer> path) {
    if (root == null) {
      return;
    }
    int nextSum = sum - root.val;
    // 用前添加
    path.addLast(root.val);
    if (nextSum == 0 && root.left == null && root.right == null) {
      result.add(new ArrayList<>(path));
    }
    pathSum(root.left, nextSum, result, path);

    pathSum(root.right, nextSum, result, path);

    // 用完删除，这不就是回溯吗？
    path.removeLast();
  }

  // end::answer[]


    public static void main(String[] args) {
        _0113_PathSumII_21 solution = new _0113_PathSumII_21();
        List<List<Integer>> r1 = solution.pathSum(buildTree(asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1)), 22);
        System.out.println(r1);
    }
}
