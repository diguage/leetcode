package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-26 18:55:44
 */
public class _0501_FindModeInBinarySearchTree {
  // tag::answer[]
  /**
   * 根据相同数字出现在一起的提示，写出来的。
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-06-26 18:55:44
   */
  public int[] findMode(TreeNode root) {
    if (root == null) {
      return new int[0];
    }
    List<Integer> result = new ArrayList<>();
    TreeNode baseNode = null;
    int count = 0;
    int maxCount = Integer.MIN_VALUE;
    TreeNode cur = root;
    TreeNode mostRight = null;
    while (cur != null) {
      mostRight = cur.left;
      if (mostRight != null) {
        while (mostRight.right != null && mostRight.right != cur) {
          mostRight = mostRight.right;
        }
        if (mostRight.right == null) {
          mostRight.right = cur;
          cur = cur.left;
          continue;
        } else {
          mostRight.right = null;
        }
      }
      // 在这里，利用二叉搜索树中序遍历，序列是有序的特性
      // 相同的数字就会出现在一起，这是统计每个数字的出现次数
      // baseNode == null 第一次遍历到这里
      // baseNode.val != cur.val 进行到下一个数字
      if (baseNode == null || baseNode.val != cur.val) {
        baseNode = cur;
        count = 1;
      } else {
        count++;
      }
      if (count > maxCount) {
        result.clear();
        result.add(cur.val);
        maxCount = count;
      } else if (count == maxCount) {
        result.add(cur.val);
      }
      cur = cur.right;
    }
    int[] nums = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      nums[i] = result.get(i);
    }
    return nums;
  }

  // end::answer[]


  public static void main(String[] args) {
    TreeNode tree = TreeNodes.buildTree(Arrays.asList(3, 2, 3, 1, 2));
    _0501_FindModeInBinarySearchTree solution = new _0501_FindModeInBinarySearchTree();
    int[] mode = solution.findMode(tree);
    System.out.println(Arrays.toString(mode));
  }
}
