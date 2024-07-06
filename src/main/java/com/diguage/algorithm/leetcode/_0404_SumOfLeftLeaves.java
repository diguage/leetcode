package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.Arrays;

public class _0404_SumOfLeftLeaves {
  // tag::answer[]
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int sum = 0;
    if (root.left != null
      && root.left.left == null
      && root.left.right == null) {
      sum += root.left.val;
    }
    int left = sumOfLeftLeaves(root.left);
    int right = sumOfLeftLeaves(root.right);
    return sum + left + right;
  }

  // end::answer[]


  public static void main(String[] args) {
    TreeNode root = TreeNodes.buildTree(Arrays.asList(3, 9, 20, null, null, 15, 7));
    _0404_SumOfLeftLeaves solution = new _0404_SumOfLeftLeaves();
    int result = solution.sumOfLeftLeaves(root);
    System.out.println(result + " : " + (result == 24));
  }
}
