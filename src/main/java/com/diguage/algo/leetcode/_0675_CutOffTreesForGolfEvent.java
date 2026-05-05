package com.diguage.algo.leetcode;

import java.util.*;

public class _0675_CutOffTreesForGolfEvent {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-04 20:58:57
   */
  int m;
  int n;
  int[][] dict = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public int cutOffTree(List<List<Integer>> forest) {
    m = forest.size();
    n = forest.getFirst().size();
    Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
    for (int r = 0; r < m; r++) {
      List<Integer> row = forest.get(r);
      for (int c = 0; c < n; c++) {
        if (row.get(c) > 1) {
          pq.offer(new int[]{r, c, row.get(c)});
        }
      }
    }
    pq.offer(new int[]{0, 0, 1});
    int result = 0;
    int[] prev = pq.poll();
    while (!pq.isEmpty()) {
      int[] curr = pq.poll();
      int step = find(prev[0], prev[1], curr[0], curr[1], forest, new boolean[m][n]);
      if (step == -1) {
        return -1;
      }
      result += step;
      prev = curr;
    }
    return result;
  }

  private int find(int px, int py, int cx, int cy,
                   List<List<Integer>> forest, boolean[][] visited) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{px, py});
    int step = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] curr = queue.poll();
        if (visited[curr[0]][curr[1]]) {
          continue;
        }
        visited[curr[0]][curr[1]] = true;
        if (curr[0] == cx && curr[1] == cy) {
          return step;
        }
        for (int i = 0; i < dict.length; i++) {
          int dx = curr[0] + dict[i][0];
          int dy = curr[1] + dict[i][1];
          if (check(dx, dy, forest, visited)) {
            queue.offer(new int[]{dx, dy});
          }
        }
      }
      step++;
    }
    return -1;
  }

  private boolean check(int dx, int dy, List<List<Integer>> forest, boolean[][] visited) {
    return dx >= 0 && dx < forest.size()
      && dy >= 0 && dy < forest.get(dx).size()
      && !visited[dx][dy]
      && forest.get(dx).get(dy) > 0;
  }
  // end::answer[]
}
