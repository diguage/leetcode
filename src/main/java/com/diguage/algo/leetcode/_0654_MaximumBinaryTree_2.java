package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0654_MaximumBinaryTree_2 {
  // tag::answer[]
  /**
   * 递归实现
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-07 22:41:38
   */
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return constructMaximumBinaryTree(nums, 0, nums.length - 1);
  }

  private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
    if (start > end) {
      return null;
    }
    int index = start;
    for (int i = start; i <= end; i++) {
      if (nums[i] > nums[index]) {
        index = i;
      }
    }
    TreeNode root = new TreeNode(nums[index]);
    root.left = constructMaximumBinaryTree(nums, start, index - 1);
    root.right = constructMaximumBinaryTree(nums, index + 1, end);
    return root;
  }
  // end::answer[]
}
