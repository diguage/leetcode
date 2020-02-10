package com.diguage.algorithm.leetcode;

import java.util.*;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-02-10 00:22
 */
public class _0133_CloneGraph {
    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    /**
     * Runtime: 26 ms, faster than 47.60% of Java online submissions for Clone Graph.
     * Memory Usage: 39.3 MB, less than 5.88% of Java online submissions for Clone Graph.
     */
    public Node cloneGraph(Node node) {
        if (Objects.isNull(node)) {
            return null;
        }
        Map<Node, Node> dolly = new HashMap<>();
        Deque<Node> deque = new LinkedList<>();
        deque.addLast(node);
        while (!deque.isEmpty()) {
            Node curr = deque.removeFirst();
            if (!dolly.containsKey(curr)) {
                dolly.put(curr, new Node(curr.val));
                List<Node> neighbors = curr.neighbors;
                if (Objects.nonNull(neighbors)) {
                    for (Node n : neighbors) {
                        if (!dolly.containsKey(n)) {
                            deque.addLast(n);
                        }
                    }
                }
            }
        }
        deque.addLast(node);
        Set<Node> done = new HashSet<>();
        while (!deque.isEmpty()) {
            Node curr = deque.removeFirst();
            if (!done.contains(curr)) {
                done.add(curr);
                List<Node> neighbors = curr.neighbors;
                List<Node> cn;
                Node copy = dolly.get(curr);
                if (Objects.nonNull(neighbors)) {
                    cn = new ArrayList<>(neighbors.size());
                    for (Node n : neighbors) {
                        if (!done.contains(n)) {
                            deque.addLast(n);
                        }
                        cn.add(dolly.get(n));
                    }
                    copy.neighbors = cn;
                }
            }
        }

        return dolly.get(node);
    }

    public static void main(String[] args) {
        _0133_CloneGraph solution = new _0133_CloneGraph();
        solution.cloneGraph(new Node(1));
    }
}
