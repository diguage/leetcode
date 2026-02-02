package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class _0399_EvaluateDivision_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-02 22:05:20
   */
  public double[] calcEquation(List<List<String>> equations,
                               double[] values, List<List<String>> queries) {
    int size = equations.size();
    Map<String, Integer> ids = new HashMap<>(size * 2);
    UnionFind uf = new UnionFind(size * 2);
    int id = 0;
    for (int i = 0; i < size; i++) {
      List<String> path = equations.get(i);
      double weigh = values[i];
      String first = path.getFirst();
      if (!ids.containsKey(first)) {
        ids.put(first, id++);
      }
      String last = path.getLast();
      if (!ids.containsKey(last)) {
        ids.put(last, id++);
      }
      uf.union(ids.get(first), ids.get(last), weigh);
    }
    double[] result = new double[queries.size()];
    for (int i = 0; i < result.length; i++) {
      List<String> query = queries.get(i);
      String first = query.getFirst();
      String last = query.getLast();
      Integer a = ids.get(first);
      Integer b = ids.get(last);
      if (Objects.isNull(a) || Objects.isNull(b)) {
        result[i] = -1.0;
      } else {
        result[i] = uf.isConnected(a, b);
      }
    }
    return result;
  }

  public static class UnionFind {
    private int[] parents;
    private double[] weights;

    public UnionFind(int size) {
      parents = new int[size];
      weights = new double[size];
      for (int i = 0; i < size; i++) {
        parents[i] = i;
        weights[i] = 1;
      }
    }

    public void union(int a, int b, double weight) {
      int ap = find(a);
      int bp = find(b);
      if (ap == bp) {
        return;
      }
      parents[ap] = bp;
      weights[ap] = weights[b] * weight / weights[a];
    }

    public int find(int a) {
      if (a != parents[a]) {
        int origin = parents[a];
        parents[a] = find(origin);
        weights[a] *= weights[origin];
      }
      return parents[a];
    }

    public double isConnected(Integer a, Integer b) {
      int ap = find(a);
      int bp = find(b);
      if (ap != bp) {
        return -1.0;
      }
      return weights[a] / weights[b];
    }
  }
  // end::answer[]
}
