package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0409_LongestPalindrome_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-13 21:32:00
   */
  public int longestPalindrome(String s) {
    // 统计每个字符的出现次数
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    int result = 0;
    for (Integer cnt : map.values()) {
      if ((cnt & 1) == 0) {
        // 偶数直接相加
        result += cnt;
      } else {
        // 奇数需要特殊处理：
        // 当 result 为 0 或者偶数是，直接相加
        // 否则，需要减一
        if ((result & 1) == 0 || result == 0) {
          result += cnt;
        }else {
          result += (cnt - 1);
        }
      }
    }
    return result;
  }
  // end::answer[]
}
