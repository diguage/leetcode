package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0118_PascalSTriangle_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-10-19 22:43:10
   */
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>(numRows);
    for (int i = 1; i <= numRows; i++) {
      if (result.isEmpty()) {
        result.add(List.of(1));
      } else {
        List<Integer> last = result.getLast();
        List<Integer> curr = new ArrayList(i);
        curr.add(1);
        for (int j = 2; j < i; j++) {
          curr.add(last.get(j - 2) + last.get(j - 1));
        }
        curr.add(1);
        result.add(curr);
      }
    }
    return result;
  }
  // end::answer[]
  static void main() {
    new _0118_PascalSTriangle_3().generate(5);
  }
}

