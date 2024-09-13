package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * = 20. Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/[Valid Parentheses - LeetCode]
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: "()"
 * Output: true
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: "()[]{}"
 * Output: true
 * ----
 *
 * .Example 3:
 * [source]
 * ----
 * Input: "(]"
 * Output: false
 * ----
 *
 * .Example 4:
 * [source]
 * ----
 * Input: "([)]"
 * Output: false
 * ----
 *
 * .Example 5:
 * [source]
 * ----
 * Input: "{[]}"
 * Output: true
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2019-07-26 08:12
 */
public class _0020_ValidParentheses {
  // tag::answer[]
    /**
     * Runtime: 2 ms, faster than 60.99% of Java online submissions for Valid Parentheses.
     *
     * Memory Usage: 34.2 MB, less than 100.00% of Java online submissions for Valid Parentheses.
     *
     * @author D瓜哥 · https://www.diguage.com
     * @since 2019-07-26 08:12
     */
    public boolean isValid(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return true;
        }
        Map<Character, Character> parenthesesMap = new HashMap<>(3);
        parenthesesMap.put('(', ')');
        parenthesesMap.put('{', '}');
        parenthesesMap.put('[', ']');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char aChar = s.charAt(i);
            if (parenthesesMap.containsKey(aChar)) {
                stack.push(aChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char peek = stack.pop();
                if (aChar != parenthesesMap.get(peek)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

  // end::answer[]


    public static void main(String[] args) {
        _0020_ValidParentheses solution = new _0020_ValidParentheses();

        String s7 = "[";
        boolean valid7 = solution.isValid(s7);
        System.out.println((false == valid7) + " : " + s7);

        String s6 = "]";
        boolean valid6 = solution.isValid(s6);
        System.out.println((false == valid6) + " : " + s6);

        String s1 = "()";
        boolean valid1 = solution.isValid(s1);
        System.out.println((true == valid1) + " : " + s1);

        String s2 = "()[]{}";
        boolean valid2 = solution.isValid(s2);
        System.out.println((true == valid2) + " : " + s2);

        String s3 = "(]";
        boolean valid3 = solution.isValid(s3);
        System.out.println((false == valid3) + " : " + s3);

        String s4 = "([)]";
        boolean valid4 = solution.isValid(s4);
        System.out.println((false == valid4) + " : " + s4);

        String s5 = "{[]}";
        boolean valid5 = solution.isValid(s5);
        System.out.println((true == valid5) + " : " + s5);
    }
}
