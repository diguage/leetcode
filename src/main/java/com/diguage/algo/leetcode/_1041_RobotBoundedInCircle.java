package com.diguage.algo.leetcode;

public class _1041_RobotBoundedInCircle {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-27 16:10:21
   */
  public boolean isRobotBounded(String instructions) {
    int x = 0, y = 0;
    int dx = 0, dy = 1;
    for (int i = 0; i < instructions.length(); i++) {
      char step = instructions.charAt(i);
      if (step == 'G') {
        x += dx;
        y += dy;
      } else if (step == 'R') {
        int temp = dx;
        dx = dy;
        dy = -temp;
      } else if (step == 'L') {
        int temp = dx;
        dx = -dy;
        dy = temp;
      }
    }
    return !(dx == 0 && dy == 1) || (x == 0 && y == 0);
  }

  // end::answer[]
  public static void main(String[] args) {
    new _1041_RobotBoundedInCircle()
      .isRobotBounded("GLGLGGLGL");
  }
}
