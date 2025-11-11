package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0108_ConvertSortedArrayToBinarySearchTree_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-11 20:33:36
   */
  public TreeNode sortedArrayToBST(int[] nums) {
    return dfs(nums, 0, nums.length - 1);
  }

  public TreeNode dfs(int[] nums, int low, int high) {
    if (low > high) {
      return null;
    }
    int mid = low + (high - low) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = dfs(nums, low, mid - 1);
    root.right = dfs(nums, mid + 1, high);
    return root;
  }
  // end::answer[]
}
