package com.diguage.algo.leetcode;

import java.util.*;

public class _0632_SmallestRangeCoveringElementsFromKLists {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-11 21:47:54
   */
  public int[] smallestRange(List<List<Integer>> nums) {
    List<List<Integer>> data = new ArrayList<>();
    for (int i = 0; i < nums.size(); i++) {
      for (Integer num : nums.get(i)) {
        data.add(List.of(num, i));
      }
    }
    data.sort(Comparator.comparingInt((List<Integer> a) -> a.get(0))
      .thenComparingInt(a -> a.get(1)));
    int fast = 0, slow = 0;
    Map<Integer, Integer> windows = new HashMap<>();
    int start = data.getFirst().getFirst();
    int end = data.getLast().getFirst();
    while (fast < data.size()) {
      List<Integer> fastItem = data.get(fast);
      Integer index = fastItem.getLast();
      windows.put(index, windows.getOrDefault(index, 0) + 1);
      while (windows.size() == nums.size()) {
        Integer ie = data.get(fast).getFirst();
        Integer is = data.get(slow).getFirst();
        if (ie - is < end - start
          || (ie - is == end - start && is < start)) {
          start = is;
          end = ie;
        }
        List<Integer> slowItem = data.get(slow);
        Integer cnt = windows.get(slowItem.getLast());
        if (cnt > 1) {
          windows.put(slowItem.getLast(), cnt - 1);
        } else {
          windows.remove(slowItem.getLast());
        }
        slow++;
      }
      fast++;
    }
    return new int[]{start, end};
  }
  // end::answer[]
  static void main() {
    new _0632_SmallestRangeCoveringElementsFromKLists()
      .smallestRange(List.of(List.of(4, 10, 15, 24, 26), List.of(0, 9, 12, 20), List.of(5, 18, 22, 30)));

  }
}
