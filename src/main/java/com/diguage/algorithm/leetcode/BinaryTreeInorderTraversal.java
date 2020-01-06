package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;
import com.diguage.algorithm.util.TreeNodeUtils;

import java.util.*;

/**
 * = 94. Binary Tree Inorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/[Binary Tree Inorder Traversal - LeetCode]
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * .Example:
 * [source]
 * ----
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 * ----
 *
 * *Follow up:* Recursive solution is trivial, could you do it iteratively?
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-06 22:14
 */
public class BinaryTreeInorderTraversal {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
     *
     * Memory Usage: 34.8 MB, less than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        while (Objects.nonNull(current) || !stack.isEmpty()) {
            while (Objects.nonNull(current)) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
     *
     * Memory Usage: 34.7 MB, less than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
     */
    public List<Integer> inorderTraversalRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    public void inorderTraversal(TreeNode root, List<Integer> result) {
        if (Objects.isNull(root)) {
            return;
        }
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();
        TreeNode a1 = TreeNodeUtils.buildTree(Arrays.asList(1, null, 2, null, null, 3));
        List<Integer> r1 = solution.inorderTraversal(a1);
        System.out.println(Arrays.toString(r1.toArray()));
    }
}
