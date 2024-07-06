package com.diguage.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * = 93. Restore IP Addresses
 *
 * https://leetcode.com/problems/restore-ip-addresses/[Restore IP Addresses - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-06 10:00
 */
public class _0093_RestoreIPAddresses {
  // tag::answer[]
    /**
     * Runtime: 2 ms, faster than 88.51% of Java online submissions for Restore IP Addresses.
     * Memory Usage: 38.4 MB, less than 30.23% of Java online submissions for Restore IP Addresses.
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayDeque<>(), result);
        return result;
    }

    private void backtrack(String s, int start, Deque<String> current, List<String> result) {
        if (start == s.length() && current.size() == 4) {
            result.add(String.join(".", current));
            return;
        }
        for (int i = start + 1; i <= s.length() && i <= start + 3 && current.size() < 4; i++) {
            String substring = s.substring(start, i);
            if (substring.length() > 1 && substring.charAt(0) == '0') {
                continue;
            }
            int num = Integer.parseInt(substring);
            if (0 <= num && num <= 255) {
                current.addLast(substring);
                backtrack(s, i, current, result);
                current.removeLast();
            }
        }
    }

  // end::answer[]


    public static void main(String[] args) {
        _0093_RestoreIPAddresses solution = new _0093_RestoreIPAddresses();
        System.out.println(solution.restoreIpAddresses("010010"));
        System.out.println(solution.restoreIpAddresses("0000"));
        System.out.println(solution.restoreIpAddresses("25525511135"));
    }
}
