package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class _0539_MinimumTimeDifference {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-04 19:31:53
   */
  public int findMinDifference(List<String> timePoints) {
    Set<String> set = timePoints.stream().collect(Collectors.toSet());
    if (set.size() < timePoints.size()) {
      return 0;
    }
    PriorityQueue<Integer> queue = new PriorityQueue<>(timePoints.size());
    for (String point : timePoints) {
      queue.offer(parse(point));
    }
    int result = Integer.MAX_VALUE;
    int first = queue.poll();
    int last = first;
    while (!queue.isEmpty()) {
      int i = queue.poll();
      result = Math.min(result, i - last);
      last = i;
    }
    result = Math.min(result, first + 24 * 60 - last);
    return result;
  }

  private Integer parse(String point) {
    int index = point.indexOf(":");
    return Integer.parseInt(point.substring(0, index)) * 60
      + Integer.parseInt(point.substring(index + 1));
  }
  // end::answer[]
  static void main() {
    new _0539_MinimumTimeDifference().findMinDifference(
      Arrays.asList("01:01", "02:01", "03:00", "03:01"));
  }
}
