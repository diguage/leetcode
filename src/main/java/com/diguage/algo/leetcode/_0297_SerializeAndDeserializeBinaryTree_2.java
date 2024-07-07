package com.diguage.algo.leetcode;

import com.diguage.util.Jsons;
import com.diguage.algo.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * = 297. Serialize and Deserialize Binary Tree
 *
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/[Serialize and Deserialize Binary Tree - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-20 11:39:45
 */
public class _0297_SerializeAndDeserializeBinaryTree_2 {
  // tag::answer[]

  /**
   * 参考左程云
   */
  public String serialize(TreeNode root) {
    if (root == null) {
      return "#!";
    }
    String result = root.val + "!";
    result += serialize(root.left);
    result += serialize(root.right);
    return result;
  }

  public TreeNode deserialize(String data) {
    if (data == null || data.isEmpty()) {
      return null;
    }
    String[] values = data.split("!");
    Queue<String> queue = new LinkedList<>();
    for (String value : values) {
      queue.offer(value);
    }
    return deserialize(queue);
  }

  private TreeNode deserialize(Queue<String> queue) {
    if (queue.isEmpty()) {
      return null;
    }
    String value = queue.poll();
    if (value.equals("#")) {
      return null;
    }
    TreeNode head = new TreeNode(Integer.parseInt(value));
    head.left = deserialize(queue);
    head.right = deserialize(queue);
    return head;
  }

  // end::answer[]


  public static void main(String[] args) {
    TreeNode root = TreeNodes.buildTree(Arrays.asList(0, 1, 2, 3, null, null, 6, 7, null, null, null, null, null, null, 14));
    _0297_SerializeAndDeserializeBinaryTree_2 solution = new _0297_SerializeAndDeserializeBinaryTree_2();
    String data = solution.serialize(root);
    System.out.println(data);
    TreeNode tree = solution.deserialize(data);
    System.out.println(Jsons.toJson(tree));
  }
}
