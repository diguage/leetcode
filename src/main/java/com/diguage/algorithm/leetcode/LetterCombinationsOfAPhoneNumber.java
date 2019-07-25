package com.diguage.algorithm.leetcode;

import java.util.*;

/**
 * = 17. Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/[Letter Combinations of a Phone Number - LeetCode]
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter
 * combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 *
 * * 1 - {},
 * * 2 - {'a','b','c'},
 * * 3 - {'d','e','f'},
 * * 4 - {'g','h','i'},
 * * 5 - {'j','k','l'},
 * * 6 - {'m','n','o'},
 * * 7 - {'p','q','r','s'},
 * * 8 - {'t','u','v'},
 * * 9 - {'w','x','y','z'},
 * * 0 - {}
 *
 * .Example:
 * [source]
 * ----
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * ----
 *
 * *Note:*
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2019-07-19 00:19
 */
public class LetterCombinationsOfAPhoneNumber {
    /**
     * Runtime: 32 ms, faster than 6.94% of Java online submissions for Letter Combinations of a Phone Number.
     *
     * Memory Usage: 36.2 MB, less than 99.10% of Java online submissions for Letter Combinations of a Phone Number.
     */
    public List<String> letterCombinations(String digits) {
        if (Objects.isNull(digits) || digits.length() == 0) {
            return Collections.EMPTY_LIST;
        }

        char[] chars = digits.toCharArray();
        List<Integer> integers = new ArrayList<>();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            int num = chars[i] - '0';
            if (num > 1) {
                integers.add(num);
            }
        }
        char[][] int2chars = new char[][]{
                {},
                {},
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'},
        };
        int size = integers.size();
        char[][] selectedChars = new char[size][];
        for (int i = 0; i < size; i++) {
            selectedChars[i] = int2chars[integers.get(i)];
        }

        return combine(selectedChars, 0);
    }

    public List<String> combine(char[][] chars, int depth) {
        List<String> result = new ArrayList<>();
        char[] rowChars = chars[depth];
        if (depth == chars.length - 1) {
            for (int i = 0; i < rowChars.length; i++) {
                result.add(rowChars[i] + "");
            }
        } else {
            List<String> strings = combine(chars, depth + 1);
            for (int i = 0; i < rowChars.length; i++) {
                char aChar = rowChars[i];
                strings.forEach(s -> result.add(aChar + s));
            }
        }
        return result;
    }


    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber solution = new LetterCombinationsOfAPhoneNumber();
        List<String> r1 = solution.letterCombinations("23");
        Collections.sort(r1);
        System.out.println(Arrays.toString(r1.toArray(new String[0])));
        List<String> s1 = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        Collections.sort(s1);
        System.out.println(s1.equals(r1) + " : " + Arrays.toString(r1.toArray(new String[0])));
    }

}
