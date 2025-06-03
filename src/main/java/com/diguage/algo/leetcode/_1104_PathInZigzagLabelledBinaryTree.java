package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _1104_PathInZigzagLabelledBinaryTree {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-03 15:52:57
   */
  public List<Integer> pathInZigZagTree(int label) {
    int cur = label;
    int len = 1;
    boolean isOdd;
    int max = 0;
    int depth = ((int) (Math.log(label) / Math.log(2))) + 1;
    int[] left = new int[depth];
    int[] right = new int[depth];
    int level = 1;
    while (left[depth - 1] == 0) {
      isOdd = (level & 1) == 1;
      max += len;
      if (isOdd) {
        right[level - 1] = max;
        left[level - 1] = max - len + 1;
      } else {
        left[level - 1] = max;
        right[level - 1] = max - len + 1;
      }
      if (cur > len) {
        cur -= len;
      }
      level++;
      len *= 2;
    }
    List<Integer> result = new ArrayList<>();
    int index = depth - 1;
    boolean isEven = (depth & 1) == 0;
    int levelIndex = isEven ? (left[depth - 1] - right[depth - 1] + 1) - cur + 1 : cur;
    while (index >= 0) {
      if (left[index] < right[index]) {
        result.add(left[index] + levelIndex - 1);
      } else {
        result.add(left[index] - levelIndex + 1);
      }
      levelIndex = (int) Math.ceil(levelIndex / 2.0);
      index--;
    }
    return result.reversed();
  }
  // end::answer[]
  public static void main(String[] args) {
    new _1104_PathInZigzagLabelledBinaryTree()
      .pathInZigZagTree(26);
  }
}
