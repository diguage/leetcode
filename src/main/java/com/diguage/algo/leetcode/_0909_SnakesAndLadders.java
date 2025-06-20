package com.diguage.algo.leetcode;

import java.util.*;

public class _0909_SnakesAndLadders {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-20 21:27:23
   */
  public int snakesAndLadders(int[][] board) {
    int n = board.length;
    int max = n * n;
    Map<Integer, Integer> matrix = buildMatrix(n);
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(1);
    int step = 0;
    Set<Integer> visited = new HashSet<>();
    while (!queue.isEmpty()) {
      step++;
      int size = queue.size();
      Set<Integer> nextSteps = new HashSet<>();
      for (int i = 0; i < size; i++) {
        int cur = queue.poll();
        visited.add(cur);
        for (int j = 1; j <= 6; j++) {
          int next = cur + j;
          if (next >= max) {
            return step;
          }
          // TODO 从 matrix 的使用情况来看，只需要构建数字到坐标的正向关联即可。
          int[] point = decodeIndex(matrix.get(next));
          int snake = board[point[0]][point[1]];
          int nextStep = snake == -1 ? next : snake;
          if (nextStep >= max) {
            return step;
          }
          if (!visited.contains(nextStep)) {
            nextSteps.add(nextStep);
          }
        }
      }
      queue.addAll(nextSteps);
    }
    return step;
  }

  private Map<Integer, Integer> buildMatrix(int n) {
    Map<Integer, Integer> result = new HashMap<>();
    for (int i = n - 1; i >= 0; i -= 2) {
      for (int j = 0; j < n; j++) {
        int num = (j + 1) + n * (n - i - 1);
        int index = codeIndex(i, j);
        result.put(num, index);
        result.put(index, num);
      }
      if (i - 1 >= 0) {
        for (int j = n - 1; j >= 0; j--) {
          int num = 2 * n - j + n * (n - i - 1);
          int index = codeIndex(i - 1, j);
          result.put(num, index);
          result.put(index, num);
        }
      }
    }
    return result;
  }

  private int[] decodeIndex(int index) {
    int[] result = new int[2];
    result[0] = index >> 18;
    result[1] = (index >> 10) & 0xFF;
    return result;
  }

  private int codeIndex(int i, int j) {
    return (i << 18) + (j << 10);
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0909_SnakesAndLadders().snakesAndLadders(new int[][]{
      {-1, -1, -1},
      {-1, 9, 8},
      {-1, 8, 9}
    });
  }
}
