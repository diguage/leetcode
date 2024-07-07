package com.diguage.algo.leetcode;

import com.diguage.util.Jsons;
import com.diguage.algo.util.TreeNode;

import java.util.Objects;

/**
 * = 108. Convert Sorted Array to Binary Search Tree
 *
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/[Convert Sorted Array to Binary Search Tree - LeetCode]
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * .Example:
 * [source]
 * ----
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-24 22:28
 */
public class _0108_ConvertSortedArrayToBinarySearchTree {
  // tag::answer[]

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
     *
     * Memory Usage: 47 MB, less than 5.16% of Java online submissions for Convert Sorted Array to Binary Search Tree.
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return null;
        }
        int high = nums.length;
        int mid = high / 2;
        TreeNode root = new TreeNode(nums[mid]);
        build(root, true, nums, 0, mid - 1);
        build(root, false, nums, mid + 1, high - 1);
        return root;
    }

    private void build(TreeNode root, boolean isLeft, int[] nums, int low, int high) {
        if (low > high) {
            return;
        }
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        if (isLeft) {
            root.left = node;
        } else {
            root.right = node;
        }
        build(node, true, nums, low, mid - 1);
        build(node, false, nums, mid + 1, high);
    }

  // end::answer[]


    public static void main(String[] args) {
        _0108_ConvertSortedArrayToBinarySearchTree solution = new _0108_ConvertSortedArrayToBinarySearchTree();
        int[] n1 = {-10, -3, 0, 5, 9};
        TreeNode r1 = solution.sortedArrayToBST(n1);
        System.out.println(Jsons.toJson(r1));
    }
}
