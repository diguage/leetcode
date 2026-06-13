package com.diguage.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _0771_JewelsAndStones {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-06-13 22:18:02
   */
  public int numJewelsInStones(String jewels, String stones) {
    Set<Character> set = new HashSet<>();
    jewels.chars().forEach(c -> set.add((char) c));
    int result = 0;
    for (char c : stones.toCharArray()) {
      if (set.contains(c)) {
        result++;
      }
    }
    return result;
  }
  // end::answer[]
}
