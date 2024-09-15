package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0205_IsomorphicStrings {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-15 22:54:57
   */
  public boolean isIsomorphic(String s, String t) {
    Map<Character, Character> s2t = new HashMap<>();
    Map<Character, Character> t2s = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char sc = s.charAt(i);
      char tc = t.charAt(i);
      if (s2t.containsKey(sc) && s2t.get(sc) != tc) {
        return false;
      } else {
        s2t.put(sc, tc);
      }
      if (t2s.containsKey(tc) && t2s.get(tc) != sc) {
        return false;
      } else {
        t2s.put(tc, sc);
      }
    }
    return true;
  }
  // end::answer[]
}
