package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;
import com.diguage.util.TreeNodes;

import java.util.*;

public class _0508_MostFrequentSubtreeSum {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-19 08:11:41
   */
  public int[] findFrequentTreeSum(TreeNode root) {
    Map<Integer, Integer> sumToCount = new HashMap<>();
    dfs(root, sumToCount);
    PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
      (a, b) -> Integer.compare(b.getValue(), a.getValue()));
    queue.addAll(sumToCount.entrySet());
    //    int flag = Integer.MIN_VALUE;
    //    for (Map.Entry<Integer, Integer> entry : sumToCount.entrySet()) {
    //      if (entry.getValue() < flag) {
    //        continue;
    //      }
    //      flag = entry.getValue();
    //      queue.add(entry);
    //    }
    List<Integer> temp = new ArrayList<>();
    Integer top = queue.peek().getValue();
    while (!queue.isEmpty()) {
      Map.Entry<Integer, Integer> entry = queue.poll();
      if (entry.getValue() < top) {
        break;
      }
      temp.add(entry.getKey());
    }
    int[] result = new int[temp.size()];
    for (int i = 0; i < temp.size(); i++) {
      result[i] = temp.get(i);
    }
    return result;
  }

  private int dfs(TreeNode root, Map<Integer, Integer> sumToNode) {
    if (Objects.isNull(root)) {
      return 0;
    }
    int left = dfs(root.left, sumToNode);
    int right = dfs(root.right, sumToNode);
    int sum = root.val + left + right;
    Integer cnt = sumToNode.getOrDefault(sum, 0);
    sumToNode.put(sum, cnt + 1);
    return sum;
  }
  // end::answer[]
  static void main() {
    new _0508_MostFrequentSubtreeSum()
      .findFrequentTreeSum(TreeNodes.buildTree(5, 2, -3));
  }
}
