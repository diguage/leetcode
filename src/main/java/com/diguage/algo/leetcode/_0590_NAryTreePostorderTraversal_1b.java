package com.diguage.algo.leetcode;

import java.util.*;

public class _0590_NAryTreePostorderTraversal_1b {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-26 20:27
   */
  public List<Integer> postorder(Node root) {
    if (Objects.isNull(root)) {
      return Collections.emptyList();
    }
    List<Integer> result = new ArrayList<>();
    Deque<Node> stack = new ArrayDeque<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      Node head = stack.peek();
      List<Node> children = head.children;
      if (Objects.isNull(children) || children.isEmpty()) {
        Node node = stack.pop();
        result.add(node.val);
      } else {
        // 打断它的层级链接
        // 如果不破坏树的结构，也可以入栈更多信息（比如用数组包含层级等）
        head.children = null;
        for (int i = children.size() - 1; i >= 0; i--) {
          stack.push(children.get(i));
        }
      }
    }
    return result;
  }
  // end::answer[]
  private static class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  static void main() {
    Node root = new Node(1, Arrays.asList(new Node(3,
      Arrays.asList(new Node(5), new Node(6))),
      new Node(2), new Node(4)));
    List<Integer> result = new _0590_NAryTreePostorderTraversal_1b().postorder(root);
    System.out.println(Arrays.toString(result.toArray()));
  }
}
