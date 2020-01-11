package com.diguage.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * = 387. First Unique Character in a String
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string/[First Unique Character in a String - LeetCode]
 *
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * .Examples:
 * [source]
 * ----
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * ----
 *
 * *Note:* You may assume the string contain only lowercase letters.
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-11 10:48
 */
public class FirstUniqueCharacterInAString {
    /**
     * Runtime: 34 ms, faster than 54.19% of Java online submissions for First Unique Character in a String.
     *
     * Memory Usage: 37.4 MB, less than 100.00% of Java online submissions for First Unique Character in a String.
     *
     * Copy from: https://leetcode.com/problems/first-unique-character-in-a-string/solution/[First Unique Character in a String solution - LeetCode]
     */
    public int firstUniqChar(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return -1;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> charToCountMap = new HashMap<>();
        for (char aChar : chars) {
            Integer count = charToCountMap.getOrDefault(aChar, 0);
            charToCountMap.put(aChar, ++count);
        }
        for (int i = 0; i < chars.length; i++) {
            if (charToCountMap.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Runtime: 53 ms, faster than 10.48% of Java online submissions for First Unique Character in a String.
     *
     * Memory Usage: 38.4 MB, less than 96.43% of Java online submissions for First Unique Character in a String.
     */
    public int firstUniqCharArray(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return -1;
        }
        char[] chars = s.toCharArray();
        boolean[] unique = new boolean[chars.length];
        Arrays.fill(unique, true);
        for (int i = 0; i < chars.length; i++) {
            if (!unique[i]) {
                continue;
            }
            for (int j = i + 1; j < chars.length; j++) {
                if (!unique[j]) {
                    continue;
                }
                if (chars[i] == chars[j]) {
                    unique[i] = false;
                    unique[j] = false;
                }
            }
        }
        for (int i = 0; i < unique.length; i++) {
            if (unique[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInAString solution = new FirstUniqueCharacterInAString();
        int r1 = solution.firstUniqChar("leetcode");
        System.out.println((r1 == 0) + " : " + r1);

        int r2 = solution.firstUniqChar("cc");
        System.out.println((r2 == -1) + " : " + r2);
    }
}
