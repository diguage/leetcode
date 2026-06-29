package com.diguage.algo.leetcode;

import java.util.*;

public class _0802_FindEventualSafeStates {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-29 21:20:53
   */
  public List<Integer> eventualSafeNodes(int[][] graph) {
    int[][] reversed = new int[graph.length][];
    for (int i = 0; i < graph.length; i++) {
      int[] target = graph[i];
      for (int t : target) {
        if (Objects.isNull(reversed[t])) {
          reversed[t] = new int[]{i};
        } else {
          int[] temp = new int[reversed[t].length + 1];
          System.arraycopy(reversed[t], 0, temp, 0, reversed[t].length);
          temp[temp.length - 1] = i;
          reversed[t] = temp;
        }
      }
    }
    Set<Integer> result = new TreeSet<>();
    for (int i = 0; i < reversed.length; i++) {
      if (Objects.isNull(graph[i]) || graph[i].length == 0) { // 没有进边
        dfs(graph, reversed, result, i);
      }
    }
    return new ArrayList<>(result);
  }

  private void dfs(int[][] graph, int[][] reversed, Set<Integer> result, int index) {
    if (result.contains(index)) {
      return;
    }
    result.add(index);
    int[] source = reversed[index];
    if (Objects.isNull(source)) {
      return;
    }
    for (int s : source) {
      int[] targets = graph[s];
      if (targets.length == 1) {
        dfs(graph, reversed, result, s);
      } else {
        boolean flag = true;
        for (int t : targets) {
          if (!result.contains(t)) {
            flag = false;
            break;
          }
        }
        if (flag) {
          dfs(graph, reversed, result, s);
        }
      }
    }
  }
  // end::answer[]
  static void main() {
    new _0802_FindEventualSafeStates()
//      .eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}});
      .eventualSafeNodes(new int[][]{{0}, {2, 3, 4}, {3, 4}, {0, 4}, {}});
  }
}
