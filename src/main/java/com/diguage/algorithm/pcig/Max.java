package com.diguage.algorithm.pcig;

import com.diguage.algorithm.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-06-17 15:19
 */
public class Max {
  public int getMaxLength(TreeNode head, int sum) {
    Map<Integer, Integer> sumToLevelMap = new HashMap<>();
    sumToLevelMap.put(0, 0);
    return process(head, sum, 0, 1, 0, sumToLevelMap);
  }

  private int process(TreeNode head, int sum, int presum, int level, int maxLen, Map<Integer, Integer> sumToLevelMap) {
    if (head == null) {
      return maxLen;
    }
    int cursum = presum + head.val;
    if (!sumToLevelMap.containsKey(cursum)) {
      sumToLevelMap.put(cursum, level);
    }
    if (sumToLevelMap.containsKey(cursum - sum)) {
      maxLen = Math.max(level - sumToLevelMap.get(cursum - sum), maxLen);
    }
    maxLen = process(head.left, sum, cursum, level + 1, maxLen, sumToLevelMap);
    maxLen = process(head.right, sum, cursum, level + 1, maxLen, sumToLevelMap);
    if (level == sumToLevelMap.get(cursum)) {
      sumToLevelMap.remove(cursum);
    }
    return 0;
  }

  public static void main(String[] args) {

  }
}
