package com.diguage.algo.leetcode;

import com.diguage.util.Jsons;
import com.diguage.algo.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Queue;

import static com.diguage.util.TreeNodes.buildTree;

/**
 * = 114. Flatten Binary Tree to Linked List
 *
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/[Flatten Binary Tree to Linked List - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-27 23:18
 */
public class _0114_FlattenBinaryTreeToLinkedList {
  // tag::answer[]
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Flatten Binary Tree to Linked List.
     * Memory Usage: 38.4 MB, less than 40.00% of Java online submissions for Flatten Binary Tree to Linked List.
     *
     * Copy from: https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26/[详细通俗的思路分析，多解法 - 二叉树展开为链表 - 力扣（LeetCode）]
     */
    private TreeNode pre;
    public void flatten(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

    /**
     * Runtime: 3 ms, faster than 29.55% of Java online submissions for Flatten Binary Tree to Linked List.
     * Memory Usage: 39.8 MB, less than 10.91% of Java online submissions for Flatten Binary Tree to Linked List.
     */
    public void flattenQueue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        preorder(root, queue);
        TreeNode current = queue.poll();
        while (!queue.isEmpty()) {
            current.right = queue.poll();
            current.left = null;
            current = current.right;
            if (Objects.nonNull(current)) {
                current.left = null;
            }
        }
    }

    private void preorder(TreeNode root, Queue<TreeNode> queue) {
        if (Objects.isNull(root)) {
            return;
        }
        queue.add(root);
        preorder(root.left, queue);
        preorder(root.right, queue);
    }

  // end::answer[]


    public static void main(String[] args) {
        _0114_FlattenBinaryTreeToLinkedList solution = new _0114_FlattenBinaryTreeToLinkedList();
        TreeNode t1 = buildTree(Arrays.asList(1, 2, 5, 3, 4, null, 6));
        solution.flatten(t1);
        System.out.println(Jsons.toJson(t1));
    }
}
