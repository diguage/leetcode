package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0785_IsGraphBipartite {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-19 21:39:01
   */
  public boolean isBipartite(int[][] graph) {
    UnionFind uf = new UnionFind(graph.length);
    for (int i = 0; i < graph.length; i++) {
      int[] ws = graph[i];
      for (int w : ws) {
        if (uf.isConnected(i, w)) {
          return false;
        }
        uf.union(ws[0], w);
      }
    }
    return true;
  }

  private static class UnionFind {
    private int[] parent;

    public UnionFind(int n) {
      parent = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
    }

    public int find(int a) {
      List<Integer> path = new ArrayList<>();
      while (a != parent[a]) {
        path.add(a);
        a = parent[a];
      }
      for (Integer p : path) {
        parent[p] = a;
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

    public boolean isConnected(int a, int b) {
      return find(a) == find(b);
    }
  }

  // end::answer[]
  static void main() {
    new _0785_IsGraphBipartite().isBipartite(
      new int[][]{new int[]{1, 3}, new int[]{0, 2}, new int[]{1, 3}, new int[]{0, 2}});
  }
}
