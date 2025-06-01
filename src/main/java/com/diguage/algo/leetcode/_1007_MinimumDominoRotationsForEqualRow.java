package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _1007_MinimumDominoRotationsForEqualRow {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-01 07:20:11
   */
  public int minDominoRotations(int[] tops, int[] bottoms) {
    int length = tops.length;
    List<Integer>[] topMap = new ArrayList[7];
    for (int i = 1; i < topMap.length; i++) {
      topMap[i] = new ArrayList<>();
    }
    List<Integer>[] bottomMap = new ArrayList[7];
    for (int i = 1; i < bottomMap.length; i++) {
      bottomMap[i] = new ArrayList<>();
    }
    for (int i = 0; i < length; i++) {
      int top = tops[i];
      topMap[top].add(i);

      int bottom = bottoms[i];
      bottomMap[bottom].add(i);
    }
    int result = Integer.MAX_VALUE;
    for (int i = 1; i < topMap.length; i++) {
      List<Integer> topIdx = topMap[i];
      List<Integer> bottomIdx = bottomMap[i];
      // 总数量
      if (topIdx.size() + bottomIdx.size() < length) {
        continue;
      }
      Set<Integer> set = new HashSet<>(topIdx);
      set.addAll(bottomIdx);
      // 去除重复后的数量
      if (set.size()<length) {
        continue;
      }
      boolean ok = true;
      for (int j = 0; j < length; j++) {
        if (!set.contains(j)) {
          ok = false;
          break;
        }
      }
      if (ok) {
        result = Math.min(result,
          Math.min(length - topIdx.size(), length - bottomIdx.size()));
      }
    }

    return result == Integer.MAX_VALUE ? -1 : result;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _1007_MinimumDominoRotationsForEqualRow()
      .minDominoRotations(new int[]{3, 5, 1, 2, 3}, new int[]{3, 6, 3, 3, 4});
  }
}
