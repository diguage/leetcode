package com.diguage.algo.leetcode;

public class _0168_ExcelSheetColumnTitle {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-27 21:01:09
   */
  public String convertToTitle(int columnNumber) {
    StringBuilder sb = new StringBuilder();
    while (columnNumber > 0) {
      int mul = columnNumber / 26;
      int diff = columnNumber - mul * 26;
      if (diff == 0) {
        diff = 26;
      }
      sb.append((char) ('A' + diff - 1));
      columnNumber = (columnNumber - diff) / 26;
    }
    return sb.reverse().toString();
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0168_ExcelSheetColumnTitle().convertToTitle(2147483647);
  }
}
