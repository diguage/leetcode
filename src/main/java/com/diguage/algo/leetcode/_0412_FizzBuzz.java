package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * = 412. Fizz Buzz
 *
 * https://leetcode.com/problems/fizz-buzz/[Fizz Buzz - LeetCode]
 *
 * Write a program that outputs the string representation of numbers from 1 to n.
 *
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 *
 * .Examples:
 * [source]
 * ----
 * n = 15,
 *
 * Return:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-26 23:17
 */
public class _0412_FizzBuzz {
  // tag::answer[]

    /**
     * Runtime: 2 ms, faster than 29.17% of Java online submissions for Fizz Buzz.
     *
     * Memory Usage: 45.5 MB, less than 5.40% of Java online submissions for Fizz Buzz.
     */
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                result.add("FizzBuzz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0412_FizzBuzz solution = new _0412_FizzBuzz();
        System.out.println(solution.fizzBuzz(15));
    }
}
