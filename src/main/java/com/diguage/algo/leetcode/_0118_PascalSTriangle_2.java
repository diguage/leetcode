package com.diguage.algo.leetcode;


import java.util.ArrayList;
import java.util.List;

public class _0118_PascalSTriangle_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-09 21:58:02
   */
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>(numRows);
    result.add(List.of(1));
    for (int i = 1; i < numRows; i++) {
      List<Integer> row = new ArrayList<>(i + 1);
      row.add(1);
      List<Integer> last = result.getLast();
      for (int j = 1; j < i; j++) {
        int left = last.get(j - 1);
        // 最后一个数字，右上方为空，所以，
        // 它必定是 1，可以单独添加，这样就少一个判断
        int right = last.get(j);
        row.add(left + right);
      }
      row.add(1);
      result.add(row);
    }
    return result;
  }
  // end::answer[]
}
