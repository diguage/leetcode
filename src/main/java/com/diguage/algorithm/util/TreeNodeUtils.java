package com.diguage.algorithm.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-02 00:25
 */
public class TreeNodeUtils {
    public static TreeNode buildTree(List<Integer> array) {
        if (Objects.isNull(array) || array.size() == 0) {
            return null;
        }

        TreeNode result = new TreeNode(array.get(0));
        List<TreeNode> treeNodeList = new ArrayList<>(array.size());
        treeNodeList.add(result);
        for (int i = 1; i < array.size(); i++) {
            TreeNode parent = treeNodeList.get((i - 1) / 2);
            if (Objects.isNull(parent)) {
                continue;
            }
            Integer value = array.get(i);
            TreeNode treeNode = null;
            if (Objects.nonNull(value)) {
                treeNode = new TreeNode(value);
                if (i % 2 == 0) {
                    parent.right = treeNode;
                } else {
                    parent.left = treeNode;
                }
            }
            treeNodeList.add(treeNode);
        }
        return result;
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
        List<Integer> integers = Arrays.asList(1, 2, 2, 3, 4, 4, 3);
        TreeNode treeNode = buildTree(integers);
        System.out.println(mapper.writeValueAsString(treeNode));

        List<Integer> num = Arrays.asList(1, 2, 2, null, 3, null, 3);
        TreeNode tree = buildTree(num);
        System.out.println(mapper.writeValueAsString(tree));
    }
}
