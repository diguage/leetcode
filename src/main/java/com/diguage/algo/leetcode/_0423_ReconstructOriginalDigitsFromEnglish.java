package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0423_ReconstructOriginalDigitsFromEnglish {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-08 23:08:22
   */
  public String originalDigits(String s) {
    Map<Character, Integer> charToCnt = new HashMap<Character, Integer>();
    for (char c : s.toCharArray()) {
      Integer cnt = charToCnt.getOrDefault(c, 0);
      charToCnt.put(c, cnt + 1);
    }
    int[] cnt = new int[10];
    // 0 zero
    // 1 one
    // 2 two
    // 3 three
    // 4 four
    // 5 five
    // 6 sex
    // 7 seven
    // 8 eight
    // 9 nine
    cnt[0] = charToCnt.getOrDefault('z', 0);
    cnt[2] = charToCnt.getOrDefault('w', 0);
    cnt[4] = charToCnt.getOrDefault('u', 0);
    cnt[6] = charToCnt.getOrDefault('x', 0);
    cnt[8] = charToCnt.getOrDefault('g', 0);

    cnt[3] = charToCnt.getOrDefault('h', 0) - cnt[8];
    cnt[5] = charToCnt.getOrDefault('f', 0) - cnt[4];
    cnt[7] = charToCnt.getOrDefault('s', 0) - cnt[6];

    cnt[1] = charToCnt.getOrDefault('o', 0) - cnt[0] - cnt[2] - cnt[4];
    cnt[9] = charToCnt.getOrDefault('i', 0) - cnt[5] - cnt[6] - cnt[8];

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < cnt.length; i++) {
      if (cnt[i] > 0) {
        sb.append(String.valueOf(i).repeat(cnt[i]));
      }
    }
    return sb.toString();
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0423_ReconstructOriginalDigitsFromEnglish().originalDigits("owoztneoer");
  }
}
