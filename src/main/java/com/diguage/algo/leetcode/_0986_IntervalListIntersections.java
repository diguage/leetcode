package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0986_IntervalListIntersections {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-03 14:23:09
   */
  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    if (firstList == null || secondList == null
      || firstList.length == 0 || secondList.length == 0) {
      return new int[0][0];
    }
    int first = 0, second = 0;
    List<int[]> result = new ArrayList<>();
    while (first < firstList.length && second < secondList.length) {
      if (firstList[first][1] < secondList[second][0]) {
        first++;
      } else if (secondList[second][1] < firstList[first][0]) {
        second++;
      } else {
        int max = Math.max(firstList[first][0], secondList[second][0]);
        int min;
        if (firstList[first][1] > secondList[second][1]) {
          min = secondList[second][1];
          second++;
        } else {
          min = firstList[first][1];
          first++;
        }
        result.add(new int[]{max, min});
      }
    }
    return result.toArray(new int[][]{});
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0986_IntervalListIntersections()
      .intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
        new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}});
  }
}
