package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.*;

public class _1530_NumberOfGoodLeafNodesPairs {
  // tag::answer[]

  /**
   * 思路OK，通过 74 / 113 个测试用例。再检查一下哪里有问题？！
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-03 08:07:40
   */
  int result = 0;
  int distance;

  public int countPairs(TreeNode root, int distance) {
    this.distance = distance;
    dfs(root);
    return result;
  }

  private Map<Integer, List<TreeNode>> dfs(TreeNode root) {
    if (root == null) {
      return new HashMap<>();
    }
    if (root.left == null && root.right == null) {
      return new HashMap<>(Map.of(0, new ArrayList<>(Arrays.asList(root))));
    }
    Map<Integer, List<TreeNode>> left = dfs(root.left);
    Map<Integer, List<TreeNode>> right = dfs(root.right);
    Map<Integer, List<TreeNode>> map = new HashMap<>();
    for (Map.Entry<Integer, List<TreeNode>> entry : left.entrySet()) {
      int key = entry.getKey();
      List<TreeNode> nodes = entry.getValue();
      map.put(key + 1, nodes);
      int diffNum = distance - (key + 1) - 1;
      for (int i = diffNum; i >= 0 && !right.isEmpty(); i--) {
        List<TreeNode> diff = right.remove(i);
        if (diff != null) {
          result += diff.size() * nodes.size();
          List<TreeNode> exist = map.getOrDefault(i + 1, new ArrayList<>());
          exist.addAll(diff);
          map.put(i + 1, exist);
        }
      }
    }
    for (Map.Entry<Integer, List<TreeNode>> entry : right.entrySet()) {
      int key = entry.getKey();
      List<TreeNode> nodes = entry.getValue();
      List<TreeNode> exist = map.getOrDefault(key + 1, new ArrayList<>());
      exist.addAll(nodes);
      map.put(key + 1, exist);
      int diffNum1 = distance - (key + 1) - 1;
      for (int i = diffNum1; i >= 0 && !left.isEmpty(); i--) {
        List<TreeNode> diff = left.get(i);
        if (diff != null) {
          result += diff.size() * nodes.size();
        }
      }
    }
    return map;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _1530_NumberOfGoodLeafNodesPairs()
      .countPairs(TreeNodes.buildTree(
        Arrays.asList(78, 15, 81, 73, 98, 36, null, 30, null, 63, 32)), 3);
  }
}
