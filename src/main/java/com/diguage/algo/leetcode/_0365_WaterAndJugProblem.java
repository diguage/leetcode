package com.diguage.algo.leetcode;

import java.util.*;

public class _0365_WaterAndJugProblem {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-18 22:28:36
   */
  public boolean canMeasureWater(int x, int y, int target) {
    if (target == 0) {
      return true;
    }
    if (x + y < target) {
      return false;
    }
    State init = new State(0, 0);
    Queue<State> queue = new LinkedList<>();
    Set<State> visited = new HashSet<>();
    queue.offer(init);
    visited.add(init);
    while (!queue.isEmpty()) {
      State cur = queue.poll();
      int cx = cur.x;
      int cy = cur.y;
      if (cx == target || cy == target || cx + cy == target) {
        return true;
      }
      List<State> next = getNextState(cx, cy, x, y);
      for (State s : next) {
        if (!visited.contains(s)) {
          queue.offer(s);
          visited.add(s);
        }
      }
    }
    return false;
  }

  private List<State> getNextState(int cx, int cy, int x, int y) {
    List<State> result = new ArrayList<>(8);
    // 外部加水，加满 A。（未满加水）
    if (cx < x) {
      State s1 = new State(x, cy);
      result.add(s1);
    }
    // 外部加水，加满 B。（未满加水）
    if (cy < y) {
      State s2 = new State(cx, y);
      result.add(s2);
    }

    // 把 A 清空。（有水才能清空）
    if (cx > 0) {
      State s3 = new State(0, cy);
      result.add(s3);
    }
    // 把 B 清空。（有水才能清空）
    if (cy > 0) {
      State s4 = new State(cx, 0);
      result.add(s4);
    }

    // 从 A 到 B，使得 B 满，A 剩余。（有剩余才倒）
    if (cx - (y - cy) > 0) {
      State s5 = new State(cx - (y - cy), y);
      result.add(s5);
    }
    // 从 A 到 B， A 空，B 未满。（倒过去不满才倒）
    if (cx + cy < y) {
      State s6 = new State(x, cx + cy);
      result.add(s6);
    }
    // 从 B 到 A，使得 A 满，B 剩余。（有剩余才倒）
    if (cy - (x - cx) > 0) {
      State s7 = new State(x, cy - (x - cx));
      result.add(s7);
    }
    // 从 B 到 A，使得 A 未满，B 空。（倒过去不满才倒）
    if (cx + cy < x) {
      State s8 = new State(cx + cy, 0);
      result.add(s8);
    }
    return result;
  }

  private static class State {
    final int x;
    final int y;

    public State(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      State state = (State) o;
      return x == state.x && y == state.y;
    }

    @Override
    public String toString() {
      return "State{x=" + x + ", y=" + y + "}";
    }
  }
  // end::answer[]
}
