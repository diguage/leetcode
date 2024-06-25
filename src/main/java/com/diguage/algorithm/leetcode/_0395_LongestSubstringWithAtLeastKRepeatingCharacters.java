package com.diguage.algorithm.leetcode;

import java.util.Objects;

/**
 * = 395. Longest Substring with At Least K Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/[Longest Substring with At Least K Repeating Characters - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-27 16:28
 */
public class _0395_LongestSubstringWithAtLeastKRepeatingCharacters {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Longest Substring with At Least K Repeating Characters.
     *
     * Memory Usage: 38.7 MB, less than 10.00% of Java online submissions for Longest Substring with At Least K Repeating Characters.
     *
     * Copy from: https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/solution/javadi-gui-by-tzfun/[Java递归 - 至少有K个重复字符的最长子串 - 力扣（LeetCode）]
     */
    public int longestSubstring(String s, int k) {
        if (Objects.isNull(s) || s.length() == 0 || k > s.length()) {
            return 0;
        }
        if (k < 2) {
            return s.length();
        }

        return count(s.toCharArray(), k, 0, s.length() - 1);
    }

    private int count(char[] chars, int k, int start, int end) {
        if (end - start + 1 < k) {
            return 0;
        }
        int[] times = new int[26];
        for (int i = start; i <= end; i++) {
            ++times[chars[i] - 'a'];
        }
        while (end - start + 1 > k && times[chars[start] - 'a'] < k) {
            ++start;
        }
        while (end - start + 1 > k && times[chars[end] - 'a'] < k) {
            --end;
        }
        if (end - start + 1 < k) {
            return 0;
        }
        for (int i = start; i <= end; i++) {
            if (times[chars[i] - 'a'] < k) {
                return Math.max(count(chars, k, start, i - 1), count(chars, k, i + 1, end));
            }
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        _0395_LongestSubstringWithAtLeastKRepeatingCharacters solution = new _0395_LongestSubstringWithAtLeastKRepeatingCharacters();
        int r1 = solution.longestSubstring("aaabb", 3);
        System.out.println((r1 == 3) + " : " + r1);

        int r2 = solution.longestSubstring("ababbc", 2);
        System.out.println((r2 == 5) + " : " + r2);
    }
}
