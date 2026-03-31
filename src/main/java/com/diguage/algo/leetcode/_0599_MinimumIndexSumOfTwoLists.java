package com.diguage.algo.leetcode;

import java.util.*;

public class _0599_MinimumIndexSumOfTwoLists {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-31 21:27:55
   */
  public String[] findRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> wordToIndex = new HashMap<>();
    for (int i = 0; i < list1.length; i++) {
      wordToIndex.put(list1[i], i);
    }
    int min = Integer.MAX_VALUE;
    List<String> result = new ArrayList<>();
    for (int i = 0; i < list2.length; i++) {
      String w = list2[i];
      if (!wordToIndex.containsKey(w)) {
        continue;
      }
      int sum = wordToIndex.get(w) + i;
      if (sum > min) {
        continue;
      }
      if (sum < min) {
        min = sum;
        result.clear();
      }
      result.add(w);
    }
    return result.toArray(new String[0]);
  }
  // end::answer[]
}
