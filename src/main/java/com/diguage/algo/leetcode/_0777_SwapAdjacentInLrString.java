package com.diguage.algo.leetcode;

public class _0777_SwapAdjacentInLrString {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-15 20:49:10
   */
  public boolean canTransform(String start, String result) {
    if (!start.replace("X", "")
      .equals(result.replace("X", ""))) {
      return false;
    }
    for (int i = 0, j = 0; i < start.length(); i++) {
      if (start.charAt(i) == 'X') {
        continue;
      }
      while (result.charAt(j) == 'X') {
        j++;
      }
      if (i != j && (start.charAt(i) == 'L') != (i > j)) {
        return false;
      }
      j++;
    }
    return true;
  }
  // end::answer[]

  static void main() {
    new _0777_SwapAdjacentInLrString()
//      .canTransform("RXXLRXRXL", "XRLXXRRLX");
//      .canTransform("XRRXRX", "RXLRRX");
      .canTransform("LXXLXRLXXL", "XLLXRXLXLX");
  }
}
