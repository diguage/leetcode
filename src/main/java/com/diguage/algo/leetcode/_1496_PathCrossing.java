package com.diguage.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _1496_PathCrossing {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-27 20:32:05
   */
  public boolean isPathCrossing(String path) {
    int x = 0, y = 0;
    Set<Integer> visited = new HashSet<>();
    visited.add(0);
    for (int i = 0; i < path.length(); i++) {
      char c = path.charAt(i);
      if (c == 'N') {
        y++;
      } else if (c == 'S') {
        y--;
      } else if (c == 'E') {
        x++;
      } else if (c == 'W') {
        x--;
      }
      int point = x * 10000 + y;
      if (visited.contains(point)) {
        return true;
      } else {
        visited.add(point);
      }
    }
    return false;
  }
  // end::answer[]
}
