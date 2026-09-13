package com.diguage.algo.leetcode;

import java.util.*;

public class _0763_PartitionLabels_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-13 23:17:25
   */
  public List<Integer> partitionLabels(String s) {
    char[] charArray = s.toCharArray();
    List<int[]> list = new ArrayList<>(Collections.nCopies(26, null));
    for (int i = 0; i < charArray.length; i++) {
      char c = charArray[i];
      int index = c - 'a';
      if (list.get(index) == null) {
        int[] item = new int[2];
        list.set(index, item);
        item[0] = i;
        item[1] = i;
      } else {
        list.get(index)[1] = i;
      }
    }
    list = list.stream()
      .filter(Objects::nonNull)
      .sorted(Comparator.comparingInt(a -> a[0]))
      .toList();
    List<int[]> result = new ArrayList<>();
    for (int[] ints : list) {
      if (result.isEmpty()) {
        result.add(ints);
      } else {
        int[] last = result.getLast();
        if (last[1] < ints[0]) {
          result.add(ints);
        } else {
          last[0] = Math.min(last[0], ints[0]);
          last[1] = Math.max(last[1], ints[1]);
        }
      }
    }
    return result.stream().map(a -> a[1] - a[0] + 1).toList();
  }

  // end::answer[]
  static void main() {
    new _0763_PartitionLabels_2()
      .partitionLabels("eaaaabaaec");
//      .partitionLabels("ababcbacadefegdehijhklij");
  }
}
