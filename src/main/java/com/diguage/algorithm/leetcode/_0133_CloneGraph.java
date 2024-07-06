package com.diguage.algorithm.leetcode;

import java.util.*;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-10 00:22
 */
public class _0133_CloneGraph {
  // tag::answer[]
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
     * Runtime: 28 ms, faster than 34.86% of Java online submissions for Clone Graph.
     * Memory Usage: 38.8 MB, less than 5.88% of Java online submissions for Clone Graph.
     */
    public Node cloneGraphDfs(Node node) {
        Map<Node, Node> dict = new HashMap<>();
        return dfs(node, dict);
    }

    private Node dfs(Node node, Map<Node, Node> dict) {
        if (Objects.isNull(node)) {
            return null;
        }
        if (dict.containsKey(node)) {
            return dict.get(node);
        }
        Node clone = new Node(node.val, new ArrayList<>(node.neighbors.size()));
        dict.put(node, clone);
        for (Node n : node.neighbors) {
            clone.neighbors.add(dfs(n, dict));
        }
        return clone;
    }

    /**
     * Runtime: 26 ms, faster than 47.60% of Java online submissions for Clone Graph.
     * Memory Usage: 39.3 MB, less than 5.88% of Java online submissions for Clone Graph.
     */
    public Node cloneGraph(Node node) {
        if (Objects.isNull(node)) {
            return null;
        }
        Map<Node, Node> dict = new HashMap<>();
        dict.put(node, new Node(node.val, new ArrayList<>(node.neighbors.size())));
        Deque<Node> deque = new LinkedList<>();
        deque.addLast(node);
        while (!deque.isEmpty()) {
            Node curr = deque.removeFirst();
            for (Node n : curr.neighbors) {
                if (!dict.containsKey(n)) {
                    dict.put(n, new Node(n.val, new ArrayList<>(n.neighbors.size())));
                    deque.addLast(n);
                }
                dict.get(curr).neighbors.add(dict.get(n));
            }
        }

        return dict.get(node);
    }

  // end::answer[]


    public static void main(String[] args) {
        _0133_CloneGraph solution = new _0133_CloneGraph();
        solution.cloneGraph(new Node(1));
    }
}
