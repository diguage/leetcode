package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.Objects;

public class _0869_ReorderedPowerOf2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-25 20:47:35
   */
  public boolean reorderedPowerOf2(int n) {
    char[] chars = String.valueOf(n).toCharArray();
    Arrays.sort(chars);
    int pow = 1;
    String str = new String(chars);
    for (int i = 0; Math.pow(2, i - 1) < Integer.MAX_VALUE; i++) {
      String ps = String.valueOf(pow);
      if (ps.length() == chars.length) {
        char[] pchars = ps.toCharArray();
        Arrays.sort(pchars);
        if (str.equals(new String(pchars))) {
          return true;
        }
      }
      pow *= 2;
    }
    return false;
  }
  // end::answer[]
}
