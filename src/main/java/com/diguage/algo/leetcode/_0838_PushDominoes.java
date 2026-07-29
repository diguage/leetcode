package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0838_PushDominoes {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-07-29 22:40:19
   */
  public String pushDominoes(String dominoes) {
    char[] s = ("L" + dominoes + "R").toCharArray(); // 前后各加一个哨兵
    int pre = 0; // 上一个 L 或 R 的位置
    for (int i = 1; i < s.length; i++) {
      if (s[i] == '.') {
        continue;
      }
      if (s[pre] == s[i]) { // L...L 或 R...R
        Arrays.fill(s, pre + 1, i, s[i]);
      } else if (s[i] == 'L') { // R...L。注：L..R 这种情况不需要处理
        int l = pre + 1, r = i - 1;
        while (l < r) {
          s[l] = s[l - 1]; // 前一半向右，变 R
          s[r] = s[r + 1]; // 后一半向左，变 L
          l++;
          r--;
        }
      }
      pre = i;
    }
    return new String(s, 1, s.length - 2); // 去掉前后哨兵
  }
  // end::answer[]
}
