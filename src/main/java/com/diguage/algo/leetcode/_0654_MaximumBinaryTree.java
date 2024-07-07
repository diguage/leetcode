package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;


public class _0654_MaximumBinaryTree {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-06-26 14:34:18
   */
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }
    return dfs(nums, 0, nums.length - 1);
  }

  private TreeNode dfs(int[] nums, int left, int right) {
    if (left > right) {
      return null;
    }
    int index = maxIndex(nums, left, right);
    TreeNode root = new TreeNode(nums[index]);
    root.left = dfs(nums, left, index - 1);
    root.right = dfs(nums, index + 1, right);
    return root;
  }

  private int maxIndex(int[] nums, int left, int right) {
    if (left == right) {
      return left;
    }
    int result = left;
    Integer max = nums[left];
    for (int i = left + 1; i <= right; i++) {
      if (max < nums[i]) {
        max = nums[i];
        result = i;
      }
    }
    return result;
  }
  // end::answer[]
}
