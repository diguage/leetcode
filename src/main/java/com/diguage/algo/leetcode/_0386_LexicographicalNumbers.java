package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0386_LexicographicalNumbers {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-09 22:40:14
   */
  public List<Integer> lexicalOrder(int n) {
    List<Integer> result = new ArrayList<>(n);
    int num = 1;
    for (int i = 0; i < n; i++) {
      result.add(num);
      if (num * 10 <= n) {
        num *= 10;
      } else {
        while (num % 10 == 9 || num + 1 > n) {
          num /= 10;
        }
        num++;
      }
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _0386_LexicographicalNumbers().lexicalOrder(1000);
  }
}
