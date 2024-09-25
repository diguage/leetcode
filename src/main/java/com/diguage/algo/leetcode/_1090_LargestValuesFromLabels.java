package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1090_LargestValuesFromLabels {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-25 19:36:28
   */
  public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
    int length = values.length;
    Integer[] id = new Integer[length];
    for (int i = 0; i < length; i++) {
      id[i] = i;
    }
    // 倒序排列，把大数放在前面
    Arrays.sort(id, (a, b) -> Integer.compare(values[b], values[a]));
    Map<Integer, Integer> cnt = new HashMap<>();
    int result = 0;
    int choose = 0;
    for (int i = 0; i < length && choose < numWanted; i++) {
      int label = labels[id[i]];
      if (cnt.getOrDefault(label, 0) == useLimit) {
        continue;
      }
      result += values[id[i]];
      choose++;
      cnt.put(label, cnt.getOrDefault(label, 0) + 1);
    }
    return result;
  }
  // end::answer[]
}
