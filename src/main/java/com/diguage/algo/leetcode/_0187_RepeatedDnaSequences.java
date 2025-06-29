package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _0187_RepeatedDnaSequences {
  // tag::answer[]
  /**
   * 暴力法，通过 30/31 个测试用例。
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-29 23:01:27
   */
  public List<String> findRepeatedDnaSequences(String s) {
    Set<String> result = new HashSet<>();
    for (int i = 0; i <= s.length() - 11; i++) {
      for (int j = i + 1; j <= s.length() - 10; j++) {
        int li = i;
        int ri = j;
        while (ri - j < 10) {
          if (s.charAt(li) == s.charAt(ri)) {
            li++;
            ri++;
          } else {
            break;
          }
        }
        if (ri - j == 10) {
          result.add(s.substring(j, ri));
        }
      }
    }
    return new ArrayList<>(result);
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0187_RepeatedDnaSequences()
      .findRepeatedDnaSequences("AAAAAAAAAAA");
  }
}
