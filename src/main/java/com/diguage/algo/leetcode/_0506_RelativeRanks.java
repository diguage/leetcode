package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _0506_RelativeRanks {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-17 09:40:31
   */
  public String[] findRelativeRanks(int[] score) {
    int length = score.length;
    List<Integer> seq = new ArrayList<>(length);
    for (int i = 0; i < length; i++) {
      seq.add(i);
    }
    Collections.sort(seq, (a, b) -> Integer.compare(score[b], score[a]));
    String[] result = new String[length];
    for (int i = 0; i < seq.size(); i++) {
      String note;
      if (i == 0) {
        note = "Gold Medal";
      } else if (i == 1) {
        note = "Silver Medal";
      } else if (i == 2) {
        note = "Bronze Medal";
      } else {
        note = String.valueOf(i + 1);
      }
      result[seq.get(i)] = note;
    }
    return result;
  }
  // end::answer[]
}
