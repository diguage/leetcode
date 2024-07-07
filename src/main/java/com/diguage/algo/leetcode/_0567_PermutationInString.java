package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * = 567. Permutation in String
 *
 * https://leetcode.com/problems/permutation-in-string/[Permutation in String - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-30 18:05
 */
public class _0567_PermutationInString {
  // tag::answer[]
    /**
     * Runtime: 14 ms, faster than 45.41% of Java online submissions for Permutation in String.
     * Memory Usage: 39.4 MB, less than 7.69% of Java online submissions for Permutation in String.
     */
    public boolean checkInclusion(String s1, String s2) {
        if (Objects.isNull(s1) || s1.length() == 0) {
            return true;
        }
        if (Objects.isNull(s2) || s2.length() == 0 || s2.length() < s1.length()) {
            return false;
        }
        Map<Character, Integer> needs = new HashMap<>();
        for (char c : s1.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int match = 0;
        Map<Character, Integer> windows = new HashMap<>();
        while (right < s2.length()) {
            char rChar = s2.charAt(right);
            if (needs.containsKey(rChar)) {
                int rCount = windows.getOrDefault(rChar, 0) + 1;
                windows.put(rChar, rCount);
                if (rCount == needs.get(rChar)) {
                    match++;
                }
            }
            right++;

            while (match == needs.size()) {
                if (right - left == s1.length()) {
                    return true;
                }
                char lChar = s2.charAt(left);
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
        return false;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0567_PermutationInString solution = new _0567_PermutationInString();
        System.out.println(solution.checkInclusion("ab", "eidbaooo"));
        System.out.println(solution.checkInclusion("ab", "eidboaoo"));
    }
}
