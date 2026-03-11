package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0554_BrickWall {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-11 22:11:47
   */
  public int leastBricks(List<List<Integer>> wall) {
    Map<Integer, Integer> sumToCountMap = new HashMap<>();
    int result = 0;
    for (List<Integer> walls : wall) {
      int presum = 0;
      for (int i = 0; i < walls.size() - 1; i++) {
        presum += walls.get(i);
        sumToCountMap.put(presum, sumToCountMap.getOrDefault(presum, 0) + 1);
        result = Math.max(result, sumToCountMap.get(presum));
      }
    }
    return wall.size() - result;
  }
  // end::answer[]
}
