package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.*;

/**
 * = 230. Kth Smallest Element in a BST
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/[Kth Smallest Element in a BST - LeetCode]
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 * ----
 *
 * *Follow up:*
 *
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-22 08:27
 */
public class _0230_KthSmallestElementInABst {

    /**
     * Runtime: 1 ms, faster than 57.26% of Java online submissions for Kth Smallest Element in a BST.
     *
     * Memory Usage: 46.1 MB, less than 5.51% of Java online submissions for Kth Smallest Element in a BST.
     *
     * Copy from: https://leetcode.com/problems/kth-smallest-element-in-a-bst/solution/[Kth Smallest Element in a BST solution - LeetCode]
     */
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (true) {
            while (Objects.nonNull(root)) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }


    /**
     * Runtime: 4 ms, faster than 8.53% of Java online submissions for Kth Smallest Element in a BST.
     *
     * Memory Usage: 49.7 MB, less than 5.51% of Java online submissions for Kth Smallest Element in a BST.
     */
    public int kthSmallestRecursion(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(k - 1);
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (Objects.nonNull(root.left)) {
            inorder(root.left, list);
        }
        list.add(root.val);
        if (Objects.nonNull(root.right)) {
            inorder(root.right, list);
        }
    }

    public static void main(String[] args) {
        _0230_KthSmallestElementInABst solution = new _0230_KthSmallestElementInABst();
        TreeNode t1 = TreeNodes.buildTree(Arrays.asList(3, 1, 4, null, 2));
        int r1 = solution.kthSmallest(t1, 1);
        System.out.println((r1 == 1) + " : " + r1);

        TreeNode t2 = TreeNodes.buildTree(Arrays.asList(5, 3, 6, 2, 4, null, null, 1));
        int r2 = solution.kthSmallest(t2, 3);
        System.out.println((r2 == 3) + " : " + r2);
    }
}
