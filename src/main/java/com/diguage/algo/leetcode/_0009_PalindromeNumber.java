package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * = 9. Palindrome Number
 *
 * https://leetcode.com/problems/palindrome-number/description/[Palindrome Number - LeetCode]
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome when
 * it reads the same backward as forward.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: 121
 * Output: true
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * ----
 *
 * .Example 3:
 * [source]
 * ----
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * ----
 *
 * == Follow up
 *
 * Coud you solve it without converting the integer to a string?
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2018-07-01
 */
public class _0009_PalindromeNumber {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2018-07-01
   */
  public static boolean isPalindrome(int x) {
    if (x < 0 || (x > 0 && x % 10 == 0)) {
      return false;
    }
    // 如果是回文数字，则反转之后数字相等。
    // 可以再进一步，不需要完全反转，只需要反转一半即可。
    int part = 0;
    while (x > part) {
      int digit = x % 10;
      part = part * 10 + digit;
      x /= 10;
    }
    // 这里分分两种情况：
    // abccba 型，则 x == part == abc
    // abcba  型，则 x == 12, part = abc，所以 x == part / 10
    return x == part || x == part / 10;
  }

  public static boolean isPalindromeDigits(int x) {
    boolean result = true;
    if (x < 0) {
      return false;
    }
    int multiBitNumStarter = 10;
    if (x < multiBitNumStarter) {
      return result;
    }
    List<Integer> bitNums = new ArrayList<>(25);
    for (int i = x; i > 0; i /= 10) {
      bitNums.add(i % 10);
    }
    int halfLength = bitNums.size() / 2;
    for (int i = 0; i < halfLength; i++) {
      if (!bitNums.get(i).equals(bitNums.get(bitNums.size() - i - 1))) {
        result = false;
        break;
      }
    }

    return result;
  }

  // end::answer[]


  public static void main(String[] args) {
    System.out.println(isPalindrome(121));
    System.out.println(isPalindrome(-121));
    System.out.println(isPalindrome(10));
  }
}
