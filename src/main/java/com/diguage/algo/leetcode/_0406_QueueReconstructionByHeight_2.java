package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0406_QueueReconstructionByHeight_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-10 17:06:07
   */
  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
    List<int[]> result = new ArrayList<>();
    for (int[] p : people) {
      result.add(p[1], p);
    }
    return result.toArray(new int[result.size()][]);
  }
  // end::answer[]
}
