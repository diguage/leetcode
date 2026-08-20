package com.diguage.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _0874_WalkingRobotSimulation {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-20 21:44:41
   */
  public int robotSim(int[] commands, int[][] obstacles) {
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int px = 0, py = 0, d = 1;
    Set<Integer> set = new HashSet<>();
    for (int[] obstacle : obstacles) {
      set.add(obstacle[0] * 60001 + obstacle[1]);
    }
    int result = 0;
    for (int cmd : commands) {
      if (cmd < 0) {
        d += cmd == -1 ? 1 : -1;
        d %= 4;
        if (d < 0) {
          d += 4;
        }
      } else {
        for (int i = 0; i < cmd; i++) {
          if (set.contains((px + directions[d][0]) * 60001 + py + directions[d][1])) {
            break;
          }
          px += directions[d][0];
          py += directions[d][1];
          result = Math.max(result, px * px + py * py);
        }
      }
    }
    return result;
  }
  // end::answer[]
}
