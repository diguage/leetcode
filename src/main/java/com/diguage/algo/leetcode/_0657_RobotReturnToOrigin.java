package com.diguage.algo.leetcode;

public class _0657_RobotReturnToOrigin {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-20 21:13:45
   */
  public boolean judgeCircle(String moves) {
    int u = 0, d = 0, r = 0, l = 0;
    for (char c : moves.toCharArray()) {
      if (c == 'U') {
        u++;
      }
      if (c == 'D') {
        d++;
      }
      if (c == 'R') {
        r++;
      }
      if (c == 'L') {
        l++;
      }
    }
    return u == d && r == l;
  }
  // end::answer[]
}
