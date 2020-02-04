package com.diguage.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * = 138. Copy List with Random Pointer
 *
 * https://leetcode.com/problems/copy-list-with-random-pointer/[Copy List with Random Pointer - LeetCode]
 *
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 * The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 *
 * * `val`: an integer representing `Node.val`
 * * `random_index`: the index of the node (range from `0` to `n-1`) where random pointer points to, or `null` if it does not point to any node.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 * ----
 *
 * .Example 3:
 * [source]
 * ----
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 * ----
 *
 * .Example 4:
 * [source]
 * ----
 * Input: head = []
 * Output: []
 * Explanation: Given linked list is empty (null pointer), so return null.
 * ----
 *
 * *Constraints:*
 *
 * * `-10000 <= Node.val <= 10000`
 * * `Node.random` is null or pointing to a node in the linked list.
 * * Number of Nodes will not exceed 1000.
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-07 22:21
 */
public class _0138_CopyListWithRandomPointer {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Copy List with Random Pointer.
     *
     * Memory Usage: 40.6 MB, less than 5.61% of Java online submissions for Copy List with Random Pointer.
     *
     * Copy from: https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43488/Java-O(n)-solution[Java O(n) solution - LeetCode Discuss]
     */
    public Node copyRandomList(Node head) {
        if (Objects.isNull(head)) {
            return null;
        }
        Map<Node, Node> dadToChildMap = new HashMap<>();
        Node current = head;
        while (Objects.nonNull(current)) {
            dadToChildMap.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;
        while (Objects.nonNull(current)) {
            dadToChildMap.get(current).next = dadToChildMap.get(current.next);
            dadToChildMap.get(current).random = dadToChildMap.get(current.random);
            current = current.next;
        }

        return dadToChildMap.get(head);
    }
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Copy List with Random Pointer.
     *
     * Memory Usage: 39.2 MB, less than 5.61% of Java online submissions for Copy List with Random Pointer.
     *
     * Copy form: https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43491/A-solution-with-constant-space-complexity-O(1)-and-linear-time-complexity-O(N)[A solution with constant space complexity O(1) and linear time complexity O(N) - LeetCode Discuss]
     */
    public Node copyRandomListLink(Node head) {
        if (Objects.isNull(head)) {
            return null;
        }
        // 第一步：把原始链表和结果链表混编起来。
        Node acNode = head;
        while (Objects.nonNull(acNode)) {
            Node node = new Node(acNode.val);
            node.next = acNode.next;
            acNode.next = node;
            acNode = node.next;
        }
        // 第二步：复制 random 指针
        acNode = head;
        while (Objects.nonNull(acNode)) {
            Node random = acNode.random;
            if (Objects.nonNull(random)) {
                Node next = acNode.next;
                next.random = random.next;
            }
            acNode = acNode.next.next;
        }

        // 第三步：拆分出结果链表
        // Node result = head.next;
        // Node rcNode = result;
        // acNode = head;
        // while (Objects.nonNull(rcNode)) {
        //     if (Objects.nonNull(rcNode.next)) {
        //         acNode.next = rcNode.next;
        //         rcNode.next = rcNode.next.next;
        //         acNode = acNode.next;
        //     }
        //     rcNode = rcNode.next;
        // }
        // acNode.next = null;

        Node prefixHead = new Node(0);
        Node rcNode = prefixHead;
        acNode = head;
        while (Objects.nonNull(acNode)) {
            rcNode.next = acNode.next;
            acNode.next = acNode.next.next;
            acNode = acNode.next;
            rcNode = rcNode.next;
        }

        return prefixHead.next;
    }

    public static void main(String[] args) {
        _0138_CopyListWithRandomPointer solution = new _0138_CopyListWithRandomPointer();
        Integer[][] a1 = {{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};
        Node l1 = build(a1);
        Node r1 = solution.copyRandomList(l1);

        Integer[][] a2 = {{1, 1}, {2, 1}};
        Node l2 = build(a2);
        Node r2 = solution.copyRandomList(l2);
    }

    public static Node build(Integer[][] array) {
        Node restult = new Node(array[0][0]);
        Node current = restult;
        for (int i = 1; i < array.length; i++) {
            Node next = new Node(array[i][0]);
            current.next = next;
            current = next;
        }

        current = restult;
        for (int i = 0; i < array.length; i++) {
            Integer[] ints = array[i];
            if (Objects.nonNull(ints[1])) {
                Node random = restult;
                for (int j = 0; j < ints[1]; j++) {
                    random = random.next;
                }
                current.random = random;
            }
            current = current.next;
        }

        return restult;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
