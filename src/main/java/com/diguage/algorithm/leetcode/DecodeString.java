package com.diguage.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * = 394. Decode String
 *
 * https://leetcode.com/problems/decode-string/[Decode String - LeetCode]
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-28 22:08
 */
public class DecodeString {

    /**
     * Runtime: 1 ms, faster than 64.03% of Java online submissions for Decode String.
     * Memory Usage: 37.4 MB, less than 5.68% of Java online submissions for Decode String.
     */
    public String decodeString(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return "";
        }
        Deque<Integer> nums = new LinkedList<>();
        Deque<String> strings = new LinkedList<>();
        int num = 0;
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                nums.addLast(num);
                strings.addLast(result.toString());
                num = 0;
                result = new StringBuilder();
            } else if (c == ']') {
                StringBuilder sb = new StringBuilder();
                Integer n = nums.removeLast();
                for (int i = 0; i < n; i++) {
                    sb.append(result);
                }
                result = new StringBuilder(strings.removeLast() + sb.toString());
            } else if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (Character.isLetter(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        DecodeString solution = new DecodeString();
        String r1 = solution.decodeString("3[a]2[bc]");
        System.out.println("aaabcbc".equals(r1) + " : " + r1);

        String r2 = solution.decodeString("3[a2[c]]");
        System.out.println("accaccacc".equals(r2) + " : " + r2);

        String r3 = solution.decodeString("2[abc]3[cd]ef");
        System.out.println("abcabccdcdcdef".equals(r3) + " : " + r3);
    }
}
