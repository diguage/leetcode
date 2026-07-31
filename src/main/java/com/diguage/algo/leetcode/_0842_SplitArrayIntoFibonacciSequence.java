package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _0842_SplitArrayIntoFibonacciSequence {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-31 22:25:24
   */
  public List<Integer> splitIntoFibonacci(String num) {
    List<Integer> result = new ArrayList<>();
    if (backtrack(result, num, 0) && result.size() > 2) {
      return result;
    }
    return Collections.emptyList();
  }

  private boolean backtrack(List<Integer> result, String num, int index) {
    if (index == num.length()) {
      return true;
    }
    for (int i = 1; i < Math.min(num.length() / 2 + 1, 11); i++) {
      int next = index + i;
      if (i > 1 && num.charAt(index) == '0') {
        return false;
      }
      long lc = Long.parseLong(num.substring(index, Math.min(num.length(), next)));
      if (lc > Integer.MAX_VALUE) {
        return false;
      }
      int curr = (int) lc;
      if (result.size() < 2) {
        result.add(curr);
        if (backtrack(result, num, next)) {
          return true;
        } else {
          result.removeLast();
        }
      } else {
        if (result.get(result.size() - 2) + result.getLast() == curr) {
          result.add(curr);
          if (backtrack(result, num, next)) {
            return true;
          } else {
            result.removeLast();
          }
        }
        if (result.get(result.size() - 2) + result.getLast() < curr) {
          return false;
        }
      }
    }
    return false;
  }

  // end::answer[]
  static void main() {
    new _0842_SplitArrayIntoFibonacciSequence()
//      .splitIntoFibonacci("1101111");
      .splitIntoFibonacci("17522");
//      .splitIntoFibonacci("214748364721474836422147483641");
  }
}
