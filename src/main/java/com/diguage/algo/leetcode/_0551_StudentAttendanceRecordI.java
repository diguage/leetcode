package com.diguage.algo.leetcode;

public class _0551_StudentAttendanceRecordI {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-08 10:22:17
   */
  public boolean checkRecord(String s) {
    int a = 0;
    int l = 0;
    for (char c : s.toCharArray()) {
      if (c == 'L') {
        l++;
        if (l >= 3) {
          return false;
        }
      } else {
        l = 0;
        if (c == 'A') {
          a++;
          if (a >= 2) {
            return false;
          }
        }
      }
    }
    return true;
  }
  // end::answer[]
}
