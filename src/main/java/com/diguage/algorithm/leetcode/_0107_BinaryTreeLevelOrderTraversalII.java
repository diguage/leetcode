package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.PrintUtils;
import com.diguage.algorithm.util.TreeNode;

import java.util.*;

import static com.diguage.algorithm.util.TreeNodeUtils.buildTree;
import static java.util.Arrays.asList;

/**
 * = 107. Binary Tree Level Order Traversal II
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/[Binary Tree Level Order Traversal II - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-05 23:20
 */
public class _0107_BinaryTreeLevelOrderTraversalII {

    /**
     * Runtime: 1 ms, faster than 86.28% of Java online submissions for Binary Tree Level Order Traversal II.
     * Memory Usage: 38.8 MB, less than 5.00% of Java online submissions for Binary Tree Level Order Traversal II.
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> nums = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.removeFirst();
                nums.add(node.val);
                if (Objects.nonNull(node.left)) {
                    deque.addLast(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    deque.addLast(node.right);
                }
            }
            result.add(nums);
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        _0107_BinaryTreeLevelOrderTraversalII solution = new _0107_BinaryTreeLevelOrderTraversalII();
        List<List<Integer>> r1 = solution.levelOrderBottom(buildTree(asList(3, 9, 20, null, null, 15, 7)));
        PrintUtils.printMatrix(r1);
    }
}
