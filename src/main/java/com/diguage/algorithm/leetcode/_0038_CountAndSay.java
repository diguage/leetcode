package com.diguage.algorithm.leetcode;

import java.util.Objects;

/**
 * = 38. Count and Say
 *
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * ----
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * ----
 *
 * `1` is read off as "`one 1`" or `11`.+
 * `11` is read off as "`two 1s`" or `21`.+
 * `21` is read off as "`one 2`, then `one 1`" or `1211`.+
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. You can do so recursively, in other words from the previous member read off the digits, counting the number of digits in groups of the same digit.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: 1
 * Output: "1"
 * Explanation: This is the base case.
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: 4
 * Output: "1211"
 * Explanation: For n = 3 the term was "21" in which we have two groups "2" and "1", "2" can be read as "12" which means frequency = 1 and value = 2, the same way "1" is read as "11", so the answer is the concatenation of "12" and "11" which is "1211".
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-17 23:16
 */
public class _0038_CountAndSay {
  // tag::answer[]
    /**
     * Runtime: 3 ms, faster than 40.24% of Java online submissions for Count and Say.
     *
     * Memory Usage: 40.9 MB, less than 5.26% of Java online submissions for Count and Say.
     */
    public String countAndSay(int n) {
        String result = "1";
        if (n == 1) {
            return result;
        }
        StringBuilder builder;
        for (int i = 1; i < n; i++) {
            builder = new StringBuilder();
            char[] chars = result.toCharArray();
            Character prefix = null;
            int count = 0;
            for (int j = 0; j < chars.length; j++) {
                char current = chars[j];
                if (Objects.isNull(prefix)) {
                    prefix = current;
                    ++count;
                } else {
                    if (Objects.equals(prefix, current)) {
                        ++count;
                    } else {
                        builder.append(count).append(prefix);
                        prefix = current;
                        count = 1;
                    }
                }
                if (j == chars.length - 1) {
                    builder.append(count).append(prefix);
                }
            }
            result = builder.toString();
        }

        return result;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0038_CountAndSay solution = new _0038_CountAndSay();
        String r1 = solution.countAndSay(5);
        System.out.println(r1.equals("111221") + " : " + r1);
    }
}
