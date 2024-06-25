package com.diguage.algorithm.leetcode;

import java.util.Objects;

/**
 * = 91. Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/[Decode Ways - LeetCode]
 *
 * A message containing letters from `A-Z` is being encoded to numbers using the following mapping:
 *
 * ----
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * ----
 *
 * Given a *non-empty* string containing only digits, determine the total number of ways to decode it.
 *
 * .Example 2:
 * [source]
 * ----
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-18 00:20
 */
public class _0091_DecodeWays {
    /**
     * Runtime: 3 ms, faster than 19.41% of Java online submissions for Decode Ways.
     *
     * Memory Usage: 41.5 MB, less than 5.66% of Java online submissions for Decode Ways.
     *
     * Copy from: https://leetcode.com/problems/decode-ways/discuss/30357/DP-Solution-(Java)-for-reference[DP Solution (Java) for reference - LeetCode Discuss]
     */
    public int numDecodings(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int[] memo = new int[length + 1];
        memo[length] = 1;
        memo[length - 1] = s.charAt(length - 1) != '0' ? 1 : 0;
        for (int i = length - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            } else {
                int value = Integer.parseInt(s.substring(i, i + 2));
                memo[i] = value <= 26 ? memo[i + 1] + memo[i + 2] : memo[i + 1];
            }
        }
        return memo[0];
    }

    public static void main(String[] args) {
        _0091_DecodeWays solution = new _0091_DecodeWays();

        int r4 = solution.numDecodings("27");
        System.out.println((r4 == 1) + " : " + r4);

        int r1 = solution.numDecodings("12");
        System.out.println((r1 == 2) + " : " + r1);

        int r2 = solution.numDecodings("226");
        System.out.println((r2 == 3) + " : " + r2);

        int r3 = solution.numDecodings("0");
        System.out.println((r3 == 0) + " : " + r3);
    }
}
