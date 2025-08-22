package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0455_AssignCookies {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-22 21:22:22
   */
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int result = 0;
    int gi = 0, si = 0;
    while (gi < g.length && si < s.length) {
      // 这里也可以加一个循环，利用贪心模式，
      // 将饼干向右移动到大于等于胃口为止
      if (g[gi] <= s[si]) {
        result++;
        gi++;
      }
      si++;
    }
    return result;
  }
  // end::answer[]
}
