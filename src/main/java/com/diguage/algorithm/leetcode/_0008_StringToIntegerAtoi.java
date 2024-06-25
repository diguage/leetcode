package com.diguage.algorithm.leetcode;

import java.util.Objects;

/**
 * = 8. String to Integer (atoi)
 *
 * https://leetcode.com/problems/string-to-integer-atoi/[String to Integer (atoi) - LeetCode]
 *
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first
 * non-whitespace character is found. Then, starting from this character, takes an optional
 * initial plus or minus sign followed by as many numerical digits as possible, and interprets
 * them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number,
 * which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace characters,
 * no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note::
 * * Only the space character `' '` is considered as whitespace character.
 * * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: "42"
 * Output: 42
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 * ----
 *
 * .Example 3:
 * [source]
 * ----
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * ----
 *
 * .Example 4:
 * [source]
 * ----
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * ----
 *
 * .Example 5:
 * [source]
 * ----
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Thefore INT_MIN (−231) is returned.
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2019-07-14 19:57
 */
public class _0008_StringToIntegerAtoi {

  public int myAtoi(String str) {
    char[] chars = str.toCharArray();
    int n = str.length();
    int idx = 0;
    // 除去前面的空白符
    while (idx < n && Character.isWhitespace(chars[idx])) {
      idx++;
    }
    if (idx == n) {
      return 0;
    }
    // 判断正负号
    boolean negative = false;
    if (chars[idx] == '-') {
      negative = true;
      idx++;
    } else if (chars[idx] == '+') {
      // negative = false;
      idx++;
    } else if (!Character.isDigit(chars[idx])) {
      return 0;
    }
    // 计算数字
    int result = 0;
    while (idx < n && Character.isDigit(chars[idx])) {
      int num = chars[idx] - '0';
      // 注意这个判断是否溢出的方式。
      if (result > (Integer.MAX_VALUE - num) / 10) {
        return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      }
      result = result * 10 + num;
      idx++;
    }
    return negative ? -result : result;
  }

  /**
   * Runtime: 1 ms, faster than 100.00% of Java online submissions for String to Integer (atoi).
   *
   * Memory Usage: 35.8 MB, less than 99.90% of Java online submissions for String to Integer (atoi).
   */
  public int myAtoi2(String str) {
    int result = 0;
    if (Objects.isNull(str) || str.length() == 0) {
      return result;
    }

    int index = 0;
    int length = str.length();
    while (index < length && str.charAt(index) == ' ') {
      index++;
    }

    int sign = 1;
    if (index < length && isSign(str.charAt(index))) {
      if (str.charAt(index) == '-') {
        sign = -1;
      }
      index++;
    }

    int decimals = 10;
    while (index < length && isNumber(str.charAt(index))) {
      int number = str.charAt(index) - '0';

      if (result > Integer.MAX_VALUE / 10
        || (result == Integer.MAX_VALUE / 10 && number > Integer.MAX_VALUE % 10)) {
        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }

      result = result * decimals + number;

      index++;
    }

    return result * sign;
  }

  private boolean isNumber(char aChar) {
    return '0' <= aChar && aChar <= '9';
  }

  private boolean isSign(char aChar) {
    return aChar == '-' || aChar == '+';
  }

  public int myAtoiD2u(String str) {
    long result = 0;
    if (Objects.isNull(str) || str.length() == 0) {
      return (int) result;
    }
    char[] chars = str.toCharArray();
    int start = -1;
    int end = -1;
    int signed = 1;
    boolean hasSigned = false;
    boolean isStarted = false;
    boolean firstIsZero = true;
    for (int i = 0; i < chars.length; i++) {
      char aChar = chars[i];
      if (isStarted && !isNumber(aChar)) {
        break;
      }
      if (aChar == ' ') {
        start++;
        continue;
      }
      if (!isNumber(aChar) && !isSign(aChar)) {
        return (int) result;
      }
      if (isSign(aChar) && !hasSigned) {
        if (aChar == '-') {
          signed = -1;
        }
        hasSigned = true;
        isStarted = true;
        continue;
      }
      isStarted = true;
      if (firstIsZero && aChar == '0') {
        continue;
      }
      if (isStarted && !isNumber(aChar)) {
        break;
      }
      if (firstIsZero && aChar != '0' && isNumber(aChar)) {
        firstIsZero = false;
        start = i;
        end = i;
      }
      if (isNumber(aChar)) {
        end = i;
      } else {
        break;
      }
    }

    for (int i = end; chars.length > i && i >= start && start >= 0; i--) {
      char aChar = chars[i];
      long base = pow(10, end - i);
      if (base > Integer.MAX_VALUE) {
        if (signed == 1) {
          return Integer.MAX_VALUE;
        } else {
          return Integer.MIN_VALUE;
        }
      }
      if ('0' == aChar || isSign(aChar)) {
        continue;
      }
      if (!isNumber(aChar)) {
        break;
      }
      long newResult = (long) (aChar - '0') * base + result;
      boolean isOutOfRange = (signed > 0 && newResult > Integer.MAX_VALUE)
        || (signed < 0 && newResult * signed < Integer.MIN_VALUE);
      if (isOutOfRange) {
        if (signed == 1) {
          return Integer.MAX_VALUE;
        } else {
          return Integer.MIN_VALUE;
        }
      }
      result = newResult;
    }

    result *= signed;

    return (int) result;
  }

  private long pow(int base, int exponent) {
    long result = 1L;
    for (int i = 0; i < exponent; i++) {
      result *= base;
    }
    return result;
  }

  public static void main(String[] args) {
    _0008_StringToIntegerAtoi solution = new _0008_StringToIntegerAtoi();

    int i17 = solution.myAtoi("-2147483647");
    System.out.println(i17 + " : " + (-2147483647 == i17));

    int i16 = solution.myAtoi("-2147483649");
    System.out.println(i16 + " : " + (-2147483648 == i16));

    int i15 = solution.myAtoi(Integer.toString(Integer.MIN_VALUE));
    System.out.println(i15 + " : " + (-2147483648 == i15));

    int i14 = solution.myAtoi("2147483646");
    System.out.println(i14 + " : " + (2147483646 == i14));

    int i13 = solution.myAtoi("0-1");
    System.out.println(i13 + " : " + (0 == i13));

    int i12 = solution.myAtoi("    0000000000000   ");
    System.out.println(i12 + " : " + (0 == i12));

    int i11 = solution.myAtoi("  0000000000012345678");
    System.out.println(i11 + " : " + (12345678 == i11));

    int i10 = solution.myAtoi("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000522545459");
    System.out.println(i10 + " : " + (Integer.MAX_VALUE == i10));

    int i9 = solution.myAtoi("-abc");
    System.out.println(i9 + " : " + (0 == i9));

    int i8 = solution.myAtoi("20000000000000000000");
    System.out.println(i8 + " : " + (Integer.MAX_VALUE == i8));

    int i7 = solution.myAtoi("-6147483648");
    System.out.println(i7 + " : " + (Integer.MIN_VALUE == i7));

    int i6 = solution.myAtoi("+");
    System.out.println(i6 + " : " + (0 == i6));

    int i3 = solution.myAtoi("4193 with words");
    System.out.println(i3 + " : " + (4193 == i3));

    int i2 = solution.myAtoi("   -42");
    System.out.println(i2 + " : " + (-42 == i2));

    int i1 = solution.myAtoi("42");
    System.out.println(i1 + " : " + (42 == i1));

    int i4 = solution.myAtoi("words and 987");
    System.out.println(i4 + " : " + (0 == i4));

    int i5 = solution.myAtoi("-91283472332");
    System.out.println(i5 + " : " + (-2147483648 == i5));
  }
}
