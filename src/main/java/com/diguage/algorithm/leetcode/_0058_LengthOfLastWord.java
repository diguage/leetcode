package com.diguage.algorithm.leetcode;

import java.util.Objects;

/**
 * = 58. Length of Last Word
 * <p>
 * https://leetcode.com/problems/length-of-last-word/[Length of Last Word - LeetCode]
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-02-01 22:49
 */
public class _0058_LengthOfLastWord {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Length of Last Word.
     * Memory Usage: 38 MB, less than 7.57% of Java online submissions for Length of Last Word.
     *
     * Copy from: https://leetcode-cn.com/problems/length-of-last-word/solution/hua-jie-suan-fa-58-zui-hou-yi-ge-dan-ci-de-chang-d/[画解算法：58. 最后一个单词的长度 - 最后一个单词的长度 - 力扣（LeetCode）]
     */
    public int lengthOfLastWord(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return 0;
        }
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Length of Last Word.
     * Memory Usage: 37.3 MB, less than 48.48% of Java online submissions for Length of Last Word.
     */
    public int lengthOfLastWordFor(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return 0;
        }
        int start = s.length(), end = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (end == s.length() && c != ' ') {
                end = i;
            }
            if (c == ' ' && i < end && end != s.length()) {
                start = i;
                break;
            }
        }
        if (start == s.length() && end != s.length()) {
            start = -1;
        }
        return end - start;
    }

    public static void main(String[] args) {
        _0058_LengthOfLastWord solution = new _0058_LengthOfLastWord();
        int r1 = solution.lengthOfLastWord("Hello World");
        System.out.println((r1 == 5) + " : " + r1);
    }
}
