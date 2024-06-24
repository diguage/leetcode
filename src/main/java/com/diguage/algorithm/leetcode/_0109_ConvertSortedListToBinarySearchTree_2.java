package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.JsonUtils;
import com.diguage.algorithm.util.ListNode;
import com.diguage.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.diguage.algorithm.util.ListNodeUtils.build;
import static java.util.Arrays.asList;

/**
 * = 109. Convert Sorted List to Binary Search Tree
 *
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/[LeetCode - Convert Sorted List to Binary Search Tree]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-24 15:03:55
 */
public class _0109_ConvertSortedListToBinarySearchTree_2 {

    /**
     * 使用递归，将其逐步分解成左树，根节点，右树三部分，然后将其组成一棵树即可。
     */
    public TreeNode sortedListToBST(ListNode head) {
      if (head == null) {
        return null;
      }
      // 这里偷懒了，也可以使用快慢指针将一个数组分解成两部分
      List<Integer> nums = new ArrayList<>();
      while (head != null) {
        nums.add(head.val);
        head = head.next;
      }
      return buildTree(nums, 0, nums.size() - 1);
    }

  private TreeNode buildTree(List<Integer> nums, int left, int right) {
    if (left > right) {
      return null;
    }
    if (left == right) {
      return new TreeNode(nums.get(left));
    }
    int mid = left + (right - left) / 2;
    TreeNode root = new TreeNode(nums.get(mid));
    root.left = buildTree(nums, left, mid - 1);
    root.right = buildTree(nums, mid + 1, right);
    return root;
  }

    public static void main(String[] args) {
        _0109_ConvertSortedListToBinarySearchTree_2 solution = new _0109_ConvertSortedListToBinarySearchTree_2();
        TreeNode r1 = solution.sortedListToBST(build(asList(-10, -3, 0, 5, 9)));
        System.out.println(JsonUtils.toJson(r1));
    }
}
