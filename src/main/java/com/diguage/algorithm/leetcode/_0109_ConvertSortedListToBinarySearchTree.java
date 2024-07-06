package com.diguage.algorithm.leetcode;

import com.diguage.util.Jsons;
import com.diguage.algorithm.util.ListNode;
import com.diguage.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.diguage.util.ListNodes.build;
import static java.util.Arrays.asList;

/**
 * = 109. Convert Sorted List to Binary Search Tree
 *
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/[LeetCode - Convert Sorted List to Binary Search Tree]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-06 22:42
 */
public class _0109_ConvertSortedListToBinarySearchTree {
  // tag::answer[]

    /**
     * Runtime: 1 ms, faster than 68.60% of Java online submissions for Convert Sorted List to Binary Search Tree.
     * Memory Usage: 41.1 MB, less than 5.26% of Java online submissions for Convert Sorted List to Binary Search Tree.
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        List<Integer> nums = new ArrayList<>();
        while (Objects.nonNull(head)) {
            nums.add(head.val);
            head = head.next;
        }
        return buildTree(nums, 0, nums.size());
    }

    private TreeNode buildTree(List<Integer> nums, int start, int end) {
        if (start > end || start >= nums.size()) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = buildTree(nums, start, mid - 1);
        root.right = buildTree(nums, mid + 1, end);
        return root;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0109_ConvertSortedListToBinarySearchTree solution = new _0109_ConvertSortedListToBinarySearchTree();
        TreeNode r1 = solution.sortedListToBST(build(asList(-10, -3, 0, 5, 9)));
        System.out.println(Jsons.toJson(r1));
    }
}
