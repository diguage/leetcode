package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.diguage.util.TreeNodes.buildTree;
import static java.util.Arrays.asList;

public class _0113_PathSumII_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-06-20 18:48
   */
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> result = new LinkedList<>();
    List<Integer> path = new ArrayList<>();
    backtrack(root, targetSum, result, path);
    return result;
  }

  private void backtrack(TreeNode root, int targetSum,
                         List<List<Integer>> result, List<Integer> path) {
    if (root == null) {
      return;
    }
    int nextSum = targetSum - root.val;
    path.add(root.val);
    if (nextSum == 0 && root.left == null && root.right == null) {
      result.add(new ArrayList(path));
    }
    backtrack(root.left, nextSum, result, path);
    backtrack(root.right, nextSum, result, path);
    path.remove(path.size() - 1);
  }
  // end::answer[]

  public static void main(String[] args) {
    _0113_PathSumII_3 solution = new _0113_PathSumII_3();
    List<List<Integer>> r1 = solution.pathSum(buildTree(asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1)), 22);
    System.out.println(r1);
  }
}
