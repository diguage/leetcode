package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0399_EvaluateDivision {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-16 23:26:48
   */
  public double[] calcEquation(List<List<String>> equations, double[] values,
                               List<List<String>> queries) {
    int length = equations.size();
    UnionFind unionFind = new UnionFind(2 * length);
    Map<String, Integer> map = new HashMap<>(2 * length);
    int id = 0;
    for (int i = 0; i < length; i++) {
      List<String> equation = equations.get(i);
      String s1 = equation.getFirst();
      String s2 = equation.getLast();
      if (!map.containsKey(s1)) {
        map.put(s1, id);
        id++;
      }
      if (!map.containsKey(s2)) {
        map.put(s2, id);
        id++;
      }
      unionFind.union(map.get(s1), map.get(s2), values[i]);
    }
    double[] result = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
      List<String> query = queries.get(i);
      String s1 = query.getFirst();
      String s2 = query.getLast();
      Integer id1 = map.get(s1);
      Integer id2 = map.get(s2);
      if (id1 == null || id2 == null) {
        result[i] = -1.0;
      } else {
        result[i] = unionFind.isConnected(id1, id2);
      }
    }
    return result;
  }

  public static class UnionFind {
    private int[] parent;
    private double[] weights;
    ;

    public UnionFind(int capacity) {
      parent = new int[capacity];
      weights = new double[capacity];
      for (int i = 0; i < capacity; i++) {
        parent[i] = i;
        weights[i] = 1.0;
      }
    }

    public void union(int a, int b, double weight) {
      int ap = find(a);
      int bp = find(b);
      if (ap == bp) {
        return;
      }
      parent[ap] = bp;
      weights[ap] = weights[b] * weight / weights[a];
    }

    public double isConnected(int a, int b) {
      int ap = find(a);
      int bp = find(b);
      if (ap == bp) {
        return weights[a] / weights[b];
      } else {
        return -1.0;
      }
    }


    private int find(int x) {
      if (x != parent[x]) {
        int origin = parent[x];
        parent[x] = find(parent[x]);
        weights[x] *= weights[origin];
      }
      return parent[x];
    }
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0399_EvaluateDivision()
      .calcEquation(Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c")),
        new double[]{2.0, 3.0},
        Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x")));
  }
}
