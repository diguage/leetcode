package com.diguage.util;

import com.diguage.algo.util.TreeNode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-02 00:25
 */
public class TreeNodes {
  public static TreeNode buildTree(int... nums) {
    List<Integer> list = new ArrayList<>(nums.length);
    for (int num : nums) {
      list.add(num);
    }
    return buildTree(list);
  }

  public static TreeNode buildTree(List<Integer> nums) {
    List<TreeNode> nodes = new ArrayList<>();
    for (int i = 0; i < nums.size(); i++) {
      Integer num = nums.get(i);
      if (num != null) {
        nodes.add(new TreeNode(num));
      } else {
        nodes.add(null);
      }
    }
    for (int i = 0; i < nums.size(); i++) {
      TreeNode node = nodes.get(i);
      if (node == null) {
        continue;
      }
      if (i * 2 + 1 < nums.size()) {
        node.left = nodes.get(i * 2 + 1);
      }
      if (i * 2 + 2 < nums.size()) {
        node.right = nodes.get(i * 2 + 2);
      }
    }
    return nodes.get(0);
  }

  public List<Integer> printTree(TreeNode root) {
    if (Objects.isNull(root)) {
      return Collections.emptyList();
    }
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new LinkedList<>();
    stack.offer(root);
    int level = 1;
    while (!stack.isEmpty()) {
      int size = stack.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = stack.poll();
      }
    }

    return result;
  }

  public static void main(String[] args) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    List<Integer> integers = java.util.Arrays.asList(1, 2, 2, 3, 4, 4, 3);
    TreeNode treeNode = buildTree(integers);
    System.out.println(mapper.writeValueAsString(treeNode));

    List<Integer> num = java.util.Arrays.asList(1, 2, 2, null, 3, null, 3);
    TreeNode tree = buildTree(num);
    System.out.println(mapper.writeValueAsString(tree));
  }
}
