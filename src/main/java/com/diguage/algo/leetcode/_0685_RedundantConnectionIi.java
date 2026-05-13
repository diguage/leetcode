package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0685_RedundantConnectionIi {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-13 19:48:26
   */
  public int[] findRedundantDirectedConnection(int[][] edges) {
    int n = edges.length;
    UnionFind uf = new UnionFind(n + 1);
    int[] parent = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      parent[i] = i;
    }
    int conflict = -1;
    int cycle = -1;

    for (int i = 0; i < n; i++) {
      int[] edge = edges[i];
      int a = edge[0];
      int b = edge[1];
      if (parent[b] != b) {
        conflict = i;
      } else {
        parent[b] = a;
        int ap = uf.find(a);
        int bp = uf.find(b);
        if (ap == bp) {
          cycle = i;
        } else {
          uf.union(a, b);
        }
      }
    }
    // 没有入度大于 1 的节点，即没有冲突，则有环
    if (conflict < 0) {
      return edges[cycle];
    } else {
      int[] edge = edges[conflict];
      // 有环
      if (cycle >= 0) {
        return new int[]{parent[edge[1]], edge[1]};
      } else {
        // 没有环
        return edge;
      }
    }
  }

  private static class UnionFind {
    int[] ancestor;

    public UnionFind(int n) {
      ancestor = new int[n];
      for (int i = 1; i < n; i++) {
        ancestor[i] = i;
      }
    }

    public int find(int a) {
      List<Integer> path = new ArrayList<>();
      while (a != ancestor[a]) {
        path.add(a);
        a = ancestor[a];
      }
      for (Integer p : path) {
        ancestor[p] = a;
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
        ancestor[bp] = ap;
      } else {
        ancestor[ap] = bp;
      }
    }
  }

  // end::answer[]
  static void main() {
    new _0685_RedundantConnectionIi()
//      .findRedundantDirectedConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}});
//      .findRedundantDirectedConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}});
      .findRedundantDirectedConnection(new int[][]{{2, 1}, {3, 1}, {4, 2}, {1, 4}});
  }
}
