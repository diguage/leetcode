package com.diguage.algorithm.leetcode;

import java.util.*;

/**
 * = 438. Find All Anagrams in a String
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/[Find All Anagrams in a String - LeetCode]
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-30 12:24
 */
public class _0438_FindAllAnagramsInAString {
    /**
     * Runtime: 18 ms, faster than 51.95% of Java online submissions for Find All Anagrams in a String.
     * Memory Usage: 42.6 MB, less than 6.00% of Java online submissions for Find All Anagrams in a String.
     *
     * Copy from: https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/hua-dong-chuang-kou-tong-yong-si-xiang-jie-jue-zi-/[滑动窗口通用思想解决子串问题 - 找到字符串中所有字母异位词 - 力扣（LeetCode）]
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (Objects.isNull(s) || s.length() == 0
                || Objects.isNull(p) || p.length() == 0
                || s.length() < p.length()) {
            return Collections.emptyList();
        }

        Map<Character, Integer> needs = new HashMap<>(p.length());
        for (char c : p.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        Map<Character, Integer> windows = new HashMap<>(p.length());
        int match = 0;
        List<Integer> result = new ArrayList<>();
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
                if (right - left == p.length()) {
                    result.add(left);
                }
                char lChar = s.charAt(left);
                if (needs.containsKey(lChar)) {
                    Integer lCount = windows.get(lChar) - 1;
                    windows.put(lChar, lCount);
                    if (lCount < needs.get(lChar)) {
                        match--;
                    }
                }
                left++;
            }
        }
        return result;
    }

    /**
     * Time Limit Exceeded
     */
    public List<Integer> findAnagramsSort(String s, String p) {
        if (Objects.isNull(s) || s.length() == 0
                || Objects.isNull(p) || p.length() == 0
                || s.length() < p.length()) {
            return Collections.emptyList();
        }
        char[] chars = p.toCharArray();
        Arrays.sort(chars);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= s.length() - p.length(); i++) {
            char[] subchars = s.substring(i, i + p.length()).toCharArray();
            Arrays.sort(subchars);
            if (Arrays.equals(chars, subchars)) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * Time Limit Exceeded
     */
    public List<Integer> findAnagramsPermutations(String s, String p) {
        if (Objects.isNull(s) || s.length() == 0
                || Objects.isNull(p) || p.length() == 0
                || s.length() < p.length()) {
            return Collections.emptyList();
        }
        ArrayList<Character> chars = new ArrayList<>();
        for (char c : p.toCharArray()) {
            chars.add(c);
        }
        HashSet<String> anagrams = new HashSet<>();
        buildAnagrams(chars, anagrams, 0);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= s.length() - p.length(); i++) {
            String substring = s.substring(i, i + p.length());
            if (anagrams.contains(substring)) {
                result.add(i);
            }
        }
        return result;
    }

    private void buildAnagrams(List<Character> chars, Set<String> result, int index) {
        if (index == chars.size()) {
            StringBuilder builder = new StringBuilder();
            for (Character aChar : chars) {
                builder.append(aChar);
            }
            result.add(builder.toString());
            return;
        }
        for (int i = index; i < chars.size(); i++) {
            Collections.swap(chars, i, index);
            buildAnagrams(chars, result, index + 1);
            Collections.swap(chars, i, index);
        }
    }


    public static void main(String[] args) {
        _0438_FindAllAnagramsInAString solution = new _0438_FindAllAnagramsInAString();

        List<Integer> r1 = solution.findAnagrams("cbaebabacd", "abc");
        System.out.println(r1);

        List<Integer> r2 = solution.findAnagrams("abab", "ab");
        System.out.println(r2);
    }
}
