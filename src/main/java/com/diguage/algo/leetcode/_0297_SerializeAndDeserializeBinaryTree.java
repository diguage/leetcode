package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * = 297. Serialize and Deserialize Binary Tree
 * <p>
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/[Serialize and Deserialize Binary Tree - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-06-16 22:01
 */
public class _0297_SerializeAndDeserializeBinaryTree {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2020-06-16 22:01
   */
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return "#!";
    }
    String result = root.val + "!";
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      root = queue.poll();
      if (root.left != null) {
        result += root.left.val + "!";
        queue.offer(root.left);
      } else {
        result += "#!";
      }
      if (root.right != null) {
        result += root.right.val + "!";
        queue.offer(root.right);
      } else {
        result += "#!";
      }
    }
    return result;

  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String[] values = data.split("!");
    int index = 0;
    TreeNode head = generate(values[index++]);
    Queue<TreeNode> queue = new LinkedList<>();
    if (head != null) {
      queue.offer(head);
    }
    TreeNode node = null;
    while (!queue.isEmpty()) {
      node = queue.poll();
      node.left = generate(values[index++]);
      node.right = generate(values[index++]);
      if (node.left != null) {
        queue.offer(node.left);
      }
      if (node.right != null) {
        queue.offer(node.right);
      }
    }
    return head;
  }

  private TreeNode generate(String val) {
    if ("#".equals(val)) {
      return null;
    }
    return new TreeNode(Integer.parseInt(val));
  }
  // end::answer[]
}
