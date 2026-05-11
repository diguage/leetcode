package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0682_BaseballGame {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-11 21:33:21
   */
  public int calPoints(String[] operations) {
    List<Integer> list = new ArrayList<>();
    for (String o : operations) {
      if ("+".equals(o)) {
        Integer a = list.getLast();
        Integer b = list.get(list.size() - 2);
        list.add(a + b);
      } else if ("D".equals(o)) {
        list.add(2 * list.getLast());
      } else if ("C".equals(o)) {
        list.removeLast();
      } else {
        list.add(Integer.parseInt(o));
      }
    }
    return list.stream().mapToInt(Integer::intValue).sum();
  }
  // end::answer[]
}
