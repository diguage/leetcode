package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0447_NumberOfBoomerangs {
  // tag::answer[]

  /**
   * 优化后：利用排列组合原理，统计相同距离的点数，则组成的回旋镖数量为： c * (c -1)。
   * <p>
   * 优化前： 通过 25/32 个测试用例。
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-20 22:20:21
   */
  public int numberOfBoomerangs(int[][] points) {
    int result = 0;
    for (int[] pi : points) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int[] pj : points) {
        if (pi == pj) {
          continue;
        }
        int x = pi[0] - pj[0];
        int y = pi[1] - pj[1];
        int distance = x * x + y * y;
        map.put(distance, map.getOrDefault(distance, 0) + 1);
      }
      for (Integer value : map.values()) {
        result += value * (value - 1);
      }
    }
    return result;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0447_NumberOfBoomerangs()
      .numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}});
  }
}
