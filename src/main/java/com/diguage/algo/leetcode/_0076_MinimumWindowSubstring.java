package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * = 76. Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring/[Minimum Window Substring - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-30 16:15
 */
public class _0076_MinimumWindowSubstring {
  // tag::answer[]

    /**
     * Runtime: 489 ms, faster than 5.03% of Java online submissions for Minimum Window Substring.
     * Memory Usage: 322.8 MB, less than 5.32% of Java online submissions for Minimum Window Substring.
     *
     * ↓ 优化：在最后输出时，才截取字符串。
     *
     * Runtime: 33 ms, faster than 16.02% of Java online submissions for Minimum Window Substring.
     * Memory Usage: 44.4 MB, less than 5.32% of Java online submissions for Minimum Window Substring.
     */
    public String minWindow(String s, String t) {
        if (Objects.isNull(s) || s.length() == 0
                || Objects.isNull(t) || t.length() == 0
                || s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> needs = new HashMap<>(t.length());
        for (char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int match = 0;
        Map<Character, Integer> windows = new HashMap<>(t.length());
        while (right < s.length()) {
            char rChar = s.charAt(right);
            if (needs.containsKey(rChar)) {
                int rCount = windows.getOrDefault(rChar, 0) + 1;
                windows.put(rChar, rCount);
                if (rCount == needs.get(rChar)) {
                    match++;
                }
            }
            right++;

            while (match == needs.size()) {
                if (right - left < minLength) {
                    minLength = right - left;
                    start = left;
                }
                char lChar = s.charAt(left);
                if (needs.containsKey(lChar)) {
                    int lCount = windows.get(lChar) - 1;
                    windows.put(lChar, lCount);
                    if (lCount < needs.get(lChar)) {
                        match--;
                    }
                }
                left++;
            }

        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }

  // end::answer[]


    public static void main(String[] args) {
        _0076_MinimumWindowSubstring solution = new _0076_MinimumWindowSubstring();
        String r1 = solution.minWindow("ADOBECODEBANC", "ABC");
        System.out.println("BANC".equals(r1) + " : " + r1);
    }
}
