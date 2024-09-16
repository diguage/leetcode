package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0089_GrayCode_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-16 20:43:16
   */
  public List<Integer> grayCode(int n) {
    List<Integer> result = new ArrayList<>((int) Math.pow(2, n));
    result.add(0);
    int head = 1;
    for (int i = 0; i < n; i++) {
      for (int j = result.size() - 1; j >= 0; j--) {
        result.add(head + result.get(j));
      }
      head <<= 1;
    }
    return result;
  }
  // end::answer[]
}
