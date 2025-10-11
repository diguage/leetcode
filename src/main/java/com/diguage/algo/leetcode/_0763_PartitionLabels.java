package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class _0763_PartitionLabels {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-11 16:05:09
   */
  public List<Integer> partitionLabels(String s) {
    char[] charArray = s.toCharArray();
    List<int[]> chars = new ArrayList<>(26);
    for (int i = 0; i < 26; i++) {
      chars.add(null);
    }
    List<int[]> charList = new ArrayList<>();
    for (int i = 0; i < charArray.length; i++) {
      int idx = charArray[i] - 'a';
      int[] index = chars.get(idx);
      if (Objects.isNull(index)) {
        index = new int[2];
        index[0] = i;
        chars.set(idx, index);
        charList.add(index);
      }
      index[1] = i;
    }
    List<int[]> result = new ArrayList<>();
    result.add(charList.getFirst());
    for (int i = 1; i < charList.size(); i++) {
      int[] index = charList.get(i);
      int[] last = result.getLast();
      if (last[1] < index[0]) {
        result.add(index);
      } else {
        last[1] = Math.max(last[1], index[1]);
      }
    }
    return result.stream().map(i -> i[1] - i[0] + 1).toList();
  }

  // end::answer[]
  static void main() {
    new _0763_PartitionLabels()
      .partitionLabels("ababcbacadefegdehijhklij");
  }
}
