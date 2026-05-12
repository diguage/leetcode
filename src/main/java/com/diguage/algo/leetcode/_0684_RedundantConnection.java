package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0684_RedundantConnection {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-12 21:32:48
   */
  public int[] findRedundantConnection(int[][] edges) {
    int[] result = null;
    UnionFind uf = new UnionFind(edges.length);
    for (int[] edge : edges) {
      int a = edge[0];
      int b = edge[1];
      int ap = uf.find(a);
      int bp = uf.find(b);
      if (ap == bp) {
        result = edge;
      }
      uf.union(a, b);
    }
    return result;
  }

  private static class UnionFind {
    private int[] parent;

    public UnionFind(int n) {
      parent = new int[n + 1];
      for (int i = 0; i < parent.length; i++) {
        parent[i] = i;
      }
    }

    public int find(int a) {
      List<Integer> path = new ArrayList<>();
      while (a != parent[a]) {
        path.add(a);
        a = parent[a];
      }
      for (Integer x : path) {
        parent[x] = a;
      }
      return a;
    }

    public void union(int a, int b) {
      int ap = find(a);
      int bp = find(b);
      if (ap == bp) {
        return;
      }
      if (ap < bp) {
        parent[bp] = ap;
      } else {
        parent[ap] = bp;
      }
    }
  }

  // end::answer[]

  static void main() {
    new _0684_RedundantConnection()
      .findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}});
//      .findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {1, 5}, {3, 4}, {1, 4}});
  }
}
