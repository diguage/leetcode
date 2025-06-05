package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

import static com.diguage.algo.leetcode._0133_CloneGraph.Node;

public class _0133_CloneGraph_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-05 09:36:00
   */
  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    Map<Node, Node> map = new HashMap<>();
    return dfs(node, map);
  }

  private Node dfs(Node node, Map<Node, Node> map) {
    if (node == null) {
      return null;
    }
    if (map.containsKey(node)) {
      return map.get(node);
    }
    Node newNode = new Node(node.val);
    map.put(node, newNode);
    for (Node neighbor : node.neighbors) {
      newNode.neighbors.add(dfs(neighbor, map));
    }
    return newNode;
  }
  // end::answer[]

  public static void main(String[] args) {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(5);
    Node n6 = new Node(6);
    Node n7 = new Node(7);
    n1.neighbors.add(n2);
    n1.neighbors.add(n3);
    n2.neighbors.add(n4);
    n2.neighbors.add(n5);
    n3.neighbors.add(n6);
    n6.neighbors.add(n7);
    n7.neighbors.add(n1);
    new _0133_CloneGraph_2().cloneGraph(n1);
  }
}
