package com.diguage.algo.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class _0787_CheapestFlightsWithinKStops_2a {
  // tag::answer[]
  /**
   * 暴力破解（32/58，报错）
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-19 21:36:05
   */
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    Map<Integer, List<int[]>> srcToDst = new HashMap<>(n);
    Map<Integer, List<int[]>> dstToSrc = new HashMap<>(n);
    for (int[] flight : flights) {
      int s = flight[0];
      int d = flight[1];
      int p = flight[2];
      srcToDst.computeIfAbsent(s, _ -> new ArrayList<>(n)).add(new int[]{d, p});
      dstToSrc.computeIfAbsent(d, _ -> new ArrayList<>(n)).add(new int[]{s, p});
    }
    // 题目理解错了：最多经过 k 站中转
    Map<Integer, Integer> prices = dfs(srcToDst, dstToSrc, src, Set.of(dst), k + 1);
    return prices.isEmpty() ? -1 : prices.values().stream().min(Integer::compareTo).get();
  }

  private Map<Integer, Integer> dfs(Map<Integer, List<int[]>> srcToDst,
                                    Map<Integer, List<int[]>> dstToSrc,
                                    int src, Set<Integer> dsts, int k) {
    if (k == 1) {
      List<int[]> ints = srcToDst.getOrDefault(src, Collections.emptyList());
      Map<Integer, Integer> result = new HashMap<>();
      for (int[] anInt : ints) {
        int d = anInt[0];
        if (dsts.contains(d)) {
          result.put(d, anInt[1]);
        }
      }
      return result;
    }
    List<int[]> preSrcs = new ArrayList<>();
    for (Integer dst : dsts) {
      preSrcs.addAll(dstToSrc.getOrDefault(dst, Collections.emptyList()));
    }
    Set<Integer> preDsts = preSrcs.stream()
      .map(a -> a[0]).collect(Collectors.toSet());
    if (preDsts.isEmpty()) {
      return Collections.emptyMap();
    }
    Map<Integer, Integer> preResult = dfs(srcToDst, dstToSrc, src, preDsts, k - 1);
    if (preResult.isEmpty()) {
      return Collections.emptyMap();
    }
    Map<Integer, Integer> result = new HashMap<>();
    for (Map.Entry<Integer, Integer> entry : preResult.entrySet()) {
      Integer ps = entry.getKey();
      Integer pp = entry.getValue();
      List<int[]> next = srcToDst.getOrDefault(ps, Collections.emptyList());
      for (int[] ints : next) {
        int d = ints[0];
        if (dsts.contains(d)) {
          result.put(d, pp + ints[1]);
        }
      }
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _0787_CheapestFlightsWithinKStops_2a()
//      .findCheapestPrice(4, new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}}, 0, 3, 1);
      .findCheapestPrice(3, new int[][]{{0, 1, 2}, {1, 2, 1}, {2, 0, 10}}, 1, 2, 1); // 这道题怎么会有 1 这个解呢？
  }
}
