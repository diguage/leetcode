package com.diguage.algo.leetcode;


import java.util.ArrayList;
import java.util.List;

public class _0990_SatisfiabilityOfEqualityEquations {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-20 23:06:36
   */
  public boolean equationsPossible(String[] equations) {
    List<String> equationsList = new ArrayList<>();
    List<String> noEquationsList = new ArrayList<>();
    for (String equation : equations) {
      if (equation.charAt(1) == '=') {
        equationsList.add(equation);
      } else {
        noEquationsList.add(equation);
      }
    }
    UnionFind graph = new UnionFind(26);
    for (String equation : equationsList) {
      int a = equation.charAt(0) - 'a';
      int b = equation.charAt(3) - 'a';
      graph.union(a, b);
    }
    for (String equation : noEquationsList) {
      int a = equation.charAt(0) - 'a';
      int b = equation.charAt(3) - 'a';
      boolean connected = graph.isConnected(a, b);
      if (connected) {
        return false;
      }
    }
    return true;
  }

  public static class UnionFind {
    private int[] parent;

    public UnionFind(int n) {
      parent = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
    }

    public int find(int x) {
      int xp = parent[x];
      if (xp != x) {
        List<Integer> path = new ArrayList<>();
        path.add(x);
        while (xp != parent[xp]) {
          path.add(parent[xp]);
          xp = parent[xp];
        }
        for (Integer p : path) {
          parent[p] = xp;
        }
      }
      return xp;
    }

    public void union(int a, int b) {
      int ap = find(a);
      int bp = find(b);
      if (ap == bp) {
        return;
      }
      parent[ap] = bp;
    }

    public boolean isConnected(int a, int b) {
      return find(a) == find(b);
    }
  }

  // end::answer[]

  public static void main(String[] args) {
    new _0990_SatisfiabilityOfEqualityEquations()
      .equationsPossible(new String[]{"c==c", "b==d", "x!=z"});
  }
}
