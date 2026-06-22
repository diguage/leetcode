package com.diguage.algo.leetcode;

public class _0789_EscapeTheGhosts {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-22 20:46:27
   */
  public boolean escapeGhosts(int[][] ghosts, int[] target) {
    int[] source = {0, 0};
    int distance = manhattanDistance(source, target);
    for (int[] ghost : ghosts) {
      if (manhattanDistance(ghost, target) <= distance) {
        return false;
      }
    }
    return true;
  }

  private int manhattanDistance(int[] source, int[] target) {
    return Math.abs(target[0] - source[0]) + Math.abs(target[1] - source[1]);
  }
  // end::answer[]
}
