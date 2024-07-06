package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.Arrays;

import static com.diguage.util.TreeNodes.buildTree;

/**
 * = 437. Path Sum III
 *
 * https://leetcode.com/problems/path-sum-iii/[Path Sum III - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-28 23:06
 */
public class _0437_PathSumIII_2 {
  // tag::answer[]
    /**
     * Runtime: 23 ms, faster than 10.40% of Java online submissions for Path Sum III.
     * Memory Usage: 39.1 MB, less than 90.91% of Java online submissions for Path Sum III.
     *
     * Copy from: https://leetcode-cn.com/problems/path-sum-iii/solution/leetcode-437-path-sum-iii-by-li-xin-lei/[LeetCode 437 Path Sum III - 路径总和 III - 力扣（LeetCode）]
     */
//    public int pathSum(TreeNode root, int sum) {
//      if (root == null) {
//        return 0;
//      }
//      int nextSum = sum - root.val;
//      if (nextSum == 0) {
//        return 1 + pathSum(root.left, sum) + pathSum(root.right, sum);
//      } else {
//        return pathSum(root.left, sum) + pathSum(root.left, nextSum) +
//          pathSum(root.right, sum) + pathSum(root.right, nextSum);
//      }
//    }
public int pathSum(TreeNode root, int sum) {
  int result = 0;
  if (root == null) {
    return result;
  }
  if (sum == root.val) {
    result++;
  }
  // TODO 哪里错误？
  result += pathSum(root.left, sum - root.val);
  result += pathSum(root.right, sum - root.val);
  result += pathSum(root.left, sum);
  result += pathSum(root.right, sum);
  return result;
}

//  public int pathSum(TreeNode root, long targetSum) {
//    if (root == null) {
//      return 0;
//    }
//
//    int ret = rootSum(root, targetSum);
//    ret += pathSum(root.left, targetSum);
//    ret += pathSum(root.right, targetSum);
//    return ret;
//  }
//
//  public int rootSum(TreeNode root, long targetSum) {
//    int ret = 0;
//    if (root == null) {return 0;}
//    int val = root.val;
//    if (val == targetSum) {
//      ret++;
//    }
//    ret += rootSum(root.left, targetSum - val);
//    ret += rootSum(root.right, targetSum - val);
//    return ret;
//  }


  // end::answer[]


    public static void main(String[] args) {
        _0437_PathSumIII_2 solution = new _0437_PathSumIII_2();
        int r1 = solution.pathSum(buildTree(Arrays.asList(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1)), 8);
        System.out.println((r1 == 3) + " : " + r1);
    }
}
