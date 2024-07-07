package com.diguage.algo.leetcode;

import java.util.*;

/**
 * = 49. Group Anagrams
 *
 * https://leetcode.com/problems/group-anagrams/[Group Anagrams - LeetCode]
 *
 * Given an array of strings, group anagrams together.
 *
 * .Example:
 * [source]
 * ----
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * ----
 *
 * *Note:*
 *
 * * All inputs will be in lowercase.
 * * The order of your output does not matter.
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-06 21:42
 */
public class _0049_GroupAnagrams {
  // tag::answer[]
    /**
     * Runtime: 16 ms, faster than 22.85% of Java online submissions for Group Anagrams.
     *
     * Memory Usage: 40.4 MB, less than 96.49% of Java online submissions for Group Anagrams.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (Objects.isNull(strs) || strs.length == 0) {
            return Collections.emptyList();
        }
        Map<String, List<String>> charsToStringsMap = new HashMap<>();
        int[] count = new int[26];
        for (String str : strs) {
            Arrays.fill(count, 0);
            char[] chars = str.toCharArray();
            for (char aChar : chars) {
                count[aChar - 'a']++;
            }
            StringBuilder builder = new StringBuilder(26 * 2);
            for (int i : count) {
                builder.append("#").append(i);
            }
            String key = builder.toString();
            List<String> strings = charsToStringsMap.getOrDefault(key, new ArrayList<>());
            strings.add(str);
            charsToStringsMap.put(key, strings);
        }
        return new ArrayList<>(charsToStringsMap.values());
    }

    /**
     * Runtime: 8 ms, faster than 96.90% of Java online submissions for Group Anagrams.
     *
     * Memory Usage: 41.1 MB, less than 95.32% of Java online submissions for Group Anagrams.
     */
    public List<List<String>> groupAnagramsSort(String[] strs) {
        if (Objects.isNull(strs) || strs.length == 0) {
            return Collections.emptyList();
        }
        Map<String, List<String>> charsToStringsMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> strings = charsToStringsMap.getOrDefault(key, new ArrayList<>());
            strings.add(str);
            charsToStringsMap.put(key, strings);
        }
        return new ArrayList<>(charsToStringsMap.values());
    }

  // end::answer[]


    public static void main(String[] args) {
        _0049_GroupAnagrams solution = new _0049_GroupAnagrams();
        String[] s1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> r1 = solution.groupAnagrams(s1);
        System.out.println(Arrays.deepToString(r1.toArray()));
    }
}
