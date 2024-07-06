package com.diguage.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * = 76. Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring/[Minimum Window Substring - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-07-02 17:03:23
 */
public class _0076_MinimumWindowSubstring_2 {
  // tag::answer[]

  /**
   * 自己实现失败后，参考社区答案修改的
   */
  public String minWindow(String s, String t) {
    if (s == null || s.isEmpty() || t == null || t.isEmpty() || s.length() < t.length()) {
      return "";
    }

    // 初始化 need，记录 t 中每个字符的出现次数
    char[] chars = s.toCharArray();
    Map<Character, Integer> need = new HashMap<>();
    for (char c : t.toCharArray()) {
      need.put(c, need.getOrDefault(c, 0) + 1);
    }

    Map<Character, Integer> window = new HashMap<>();

    int left = 0, right = 0; // 窗口的左右边界
    int valid = 0; // 已经匹配上的字符数量
    int start = 0, minLen = Integer.MAX_VALUE; // 最小窗口的起始位置和长度

    while (right < s.length()) {
      // 扩大窗口
      char rc = chars[right];
      right++;

      // 更新窗口内字符的计数
      if (need.containsKey(rc)) {
        window.put(rc, window.getOrDefault(rc, 0) + 1);
        if (window.get(rc).equals(need.get(rc))) {
          valid++;
        }
      }

      // 收缩窗口
      while (need.size() == valid) {
        // 更新最小窗口的起始位置和长度
        if (right - left < minLen) {
          start = left;
          minLen = right - left;
        }

        char lc = chars[left];
        // 缩小窗口，移动左边界
        if (need.containsKey(lc)) {
          window.put(lc, window.get(lc) - 1);
          if (window.get(lc) < need.get(lc)) {
            valid--;
          }
        }
        left++;
      }
    }
    return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
  }

  // end::answer[]


  public static void main(String[] args) {
    _0076_MinimumWindowSubstring_2 solution = new _0076_MinimumWindowSubstring_2();
    String r1 = solution.minWindow("ADOBECODEBANC", "ABC");
    System.out.println("BANC".equals(r1) + " : " + r1);
  }
}
