package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class _0447_NumberOfBoomerangs {
  // tag::answer[]
  /**
   * 优化前： 通过 25/32 个测试用例。
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-20 22:20:21
   */
  public int numberOfBoomerangs(int[][] points) {
    int result = 0;
    Map<String, Integer> distances = new HashMap<>();
    int length = points.length;
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        if (i == j) {
          continue;
        }
        Integer distance = calcDistance(points, distances, i, j);
        for (int k = 0; k < length; k++) {
          if (k == i || k == j) {
            continue;
          }
          Integer distance2 = calcDistance(points, distances, i, k);
          if (Objects.equals(distance, distance2)) {
            result++;
          }
        }
      }
    }
    return result;
  }

  private Integer calcDistance(int[][] points, Map<String, Integer> distances, int i, int j) {
    String k1 = buildKey(points, i, j);
    return distances.computeIfAbsent(k1, k -> (points[i][0] - points[j][0]) * (points[i][0] - points[j][0])
      + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]));
  }

  private String buildKey(int[][] points, int i, int j) {
    return points[i][0] + ":" + points[i][1] + "/" + points[j][0] + ":" + points[j][1];
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0447_NumberOfBoomerangs()
      .numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}});
  }
}
