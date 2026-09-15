package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0438_FindAllAnagramsInAString_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-15 21:26:25
   */
  public List<Integer> findAnagrams(String s, String p) {
    int[] target = new int[26];
    for (char c : p.toCharArray()) {
      target[c - 'a']++;
    }
    int[] temp = new int[26];
    char[] chars = s.toCharArray();
    List<Integer> result = new ArrayList<>();
    int length = 0;
    for (int i = 0; i < chars.length; i++) {
      temp[chars[i] - 'a']++;
      length++;
      // 把 while 换成 if 也可以
      while (length == p.length()) {
        int idx = i - length + 1;
        if (Arrays.equals(target, temp)) {
          result.add(idx);
        }
        temp[chars[idx] - 'a']--;
        length--;
      }
    }
    return result;
  }
  // end::answer[]
}
