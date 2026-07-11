package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0816_AmbiguousCoordinates {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-11 21:53:24
   */
  public List<String> ambiguousCoordinates(String s) {
    s = s.substring(1, s.length() - 1);
    List<String> result = new ArrayList<>();
    for (int i = 1; i < s.length(); i++) {
      List<String> heads = toDecimal(s.substring(0, i));
      if (heads.isEmpty()) {
        continue;
      }
      List<String> tails = toDecimal(s.substring(i));
      if (tails.isEmpty()) {
        continue;
      }
      for (String h : heads) {
        for (String t : tails) {
          result.add('(' + h + ", " + t + ')');
        }
      }
    }
    return result;
  }

  private List<String> toDecimal(String s) {
    List<String> result = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      String d = (i > 0 ? s.substring(0, i) + '.' : "") + s.substring(i);
      if ((d.charAt(0) == '0' && d.length() > 1 && d.charAt(1) != '.')
        || (d.contains(".") && d.charAt(d.length() - 1) == '0')) {
        continue;
      }
      result.add(d);
    }
    return result;
  }

  // end::answer[]
  static void main() {
    new _0816_AmbiguousCoordinates().ambiguousCoordinates("(123)");
  }
}
