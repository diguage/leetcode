package com.diguage.algorithm.leetcode;

import com.diguage.algorithm.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

import static com.diguage.algorithm.util.TreeNodeUtils.buildTree;
import static java.util.Arrays.asList;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-09 23:17
 */
public class _0117_PopulatingNextRightPointersInEachNodeII {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(int x) {
            this.val = x;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }


    /**
     * Runtime: 1 ms, faster than 49.14% of Java online submissions for Populating Next Right Pointers in Each Node II.
     * Memory Usage: 41.4 MB, less than 100.00% of Java online submissions for Populating Next Right Pointers in Each Node II.
     *
     * Copy from: https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-28/[详细通俗的思路分析，多解法 - 填充每个节点的下一个右侧节点指针 II - 力扣（LeetCode）]
     */
    public Node connect(Node root) {
        Node curr = root;
        while (Objects.nonNull(curr)) {
            Node dummy = new Node(0);
            Node tail = dummy;
            while (Objects.nonNull(curr)) {
                if (Objects.nonNull(curr.left)) {
                    tail.next = curr.left;
                    tail = tail.next;
                }
                if (Objects.nonNull(curr.right)) {
                    tail.next = curr.right;
                    tail = tail.next;
                }
                curr = curr.next;
            }
            curr = dummy.next;
        }
        return root;
    }

    /**
     * Runtime: 1 ms, faster than 49.14% of Java online submissions for Populating Next Right Pointers in Each Node II.
     * Memory Usage: 40.8 MB, less than 100.00% of Java online submissions for Populating Next Right Pointers in Each Node II.
     */
    public Node connectDeque(Node root) {
        if (Objects.isNull(root)) {
            return null;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.addLast(root);
        Node prev = null;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node curr = deque.removeFirst();
                if (Objects.nonNull(curr.left)) {
                    deque.addLast(curr.left);
                }
                if (Objects.nonNull(curr.right)) {
                    deque.addLast(curr.right);
                }
                if (i > 0) {
                    prev.next = curr;
                }
                prev = curr;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        _0117_PopulatingNextRightPointersInEachNodeII solution = new _0117_PopulatingNextRightPointersInEachNodeII();
        TreeNode treeNode = buildTree(asList(1, 2, 3, 4, 5, null, 7));
        Node node = convert(treeNode);
        Node r1 = solution.connect(node);
        System.out.println(r1);
    }

    private static Node convert(TreeNode treeNode) {
        if (Objects.isNull(treeNode)) {
            return null;
        }
        Node node = new Node(treeNode.val);
        node.left = convert(treeNode.left);
        node.right = convert(treeNode.right);
        return node;
    }
}
