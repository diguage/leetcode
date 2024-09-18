package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0006_ZigZagConversion_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-18 20:27:18
   */
  public String convert(String s, int numRows) {
    if (numRows < 2) {
      return s;
    }
    List<StringBuilder> sbs = new ArrayList<>(numRows);
    for (int i = 0; i < numRows; i++) {
      sbs.add(new StringBuilder());
    }
    int i = 0, flag = -1;
    for (char c : s.toCharArray()) {
      sbs.get(i).append(c);
      if (i == 0 || i == numRows - 1) {
        flag = -flag;
      }
      i += flag;
    }
    StringBuilder result = new StringBuilder();
    for (StringBuilder sb : sbs) {
      result.append(sb);
    }
    return result.toString();
  }
  // end::answer[]

  public static void main(String[] args) {
    _0006_ZigZagConversion_2 solution = new _0006_ZigZagConversion_2();

    String example3 = solution.convert("AB", 1);
    System.out.println(example3 + " " + "AB".equals(example3));

    String example1 = solution.convert("PAYPALISHIRING", 3);
    System.out.println(example1 + " " + "PAHNAPLSIIGYIR".equals(example1));

    String example2 = solution.convert("PAYPALISHIRING", 4);
    System.out.println(example2 + " " + "PINALSIGYAHRPI".equals(example2));
  }
}
