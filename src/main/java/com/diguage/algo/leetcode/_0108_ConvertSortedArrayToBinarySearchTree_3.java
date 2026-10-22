package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _0108_ConvertSortedArrayToBinarySearchTree_3 {

  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-10-22 21:41:36
   */
  public TreeNode sortedArrayToBST(int[] nums) {
    return dfs(nums, 0, nums.length - 1);
  }

  private TreeNode dfs(int[] nums, int low, int high) {
    if (low > high) {
      return null;
    }
    if (low == high) {
      return new TreeNode(nums[low]);
    }
    int mid = low + (high - low) / 2;
    TreeNode left = dfs(nums, low, mid - 1);
    TreeNode right = dfs(nums, mid + 1, high);
    TreeNode root = new TreeNode(nums[mid]);
    root.left = left;
    root.right = right;
    return root;
  }
  // end::answer[]
}
