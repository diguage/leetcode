package com.diguage.algo.leetcode;

import java.util.Objects;

public class _0005_LongestPalindromicSubstring_3 {
  // tag::answer[]

  /**
   * 相仿 718 题的思路。
   *
   * TODO 解法还有少许缺陷：142个用例，通过了140个。
   *      abcdbbfcba 找不到合适的回文字符串。
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-10-08 14:22:42
   */
  public String longestPalindrome(String s) {
    if (Objects.isNull(s) || s.length() == 1) {
      return s;
    }
    return findMax(s, new StringBuilder(s).reverse().toString());
  }

  private String findMax(String a, String b) {
    int length = b.length();
    String result = "";

    // 处理 a 的头部 与 b 的尾部 的字符串
    for (int len = 1; len <= length; len++) {
      String temp = maxLength(a, 0, b, length - len, len);
      if (temp.length() > result.length() && isPalindromic(temp)) {
        result = temp;
      }
    }
    // 由于两个字符串长度相同，则不需要处理中间对其部分的处理
    // 这里的代码假设，a 短 b 长
    // for (int i = b.length() - a.length(); i >= 0; i--) {
    //   String temp = maxLength(a, 0, b, i, a.length());
    //  }

    // 处理 a 的尾部 与 b 的头部
    for (int i = 1; i < length; i++) {
      String temp = maxLength(a, i, b, 0, length - i);
      if (temp.length() > result.length() && isPalindromic(temp)) {
        result = temp;
      }
    }

    return result.isEmpty() ? null : result;
  }

  private String maxLength(String a, int as, String b, int bs, int len) {
    int count = 0;
    StringBuilder temp = new StringBuilder();
    String result = "";
    for (int i = 0; i < len; i++) {
      if (a.charAt(as + i) == b.charAt(bs + i)) {
        count++;
        temp.append(a.charAt(as + i));
        if (temp.length() > result.length()) {
          result = temp.toString();
        }
      } else if (count > 0) {
        count = 0;
        temp = new StringBuilder();
      }
    }
    int sn = a.length();
    System.out.println(String.format("%3d %3d %3d  %" + (as + len != a.length() ? "-" : "")
        + sn + "s  %" + (as + len == a.length() ? "-" : "") + sn + "s" + "  %" + sn + "s",
      as, bs, len, a.substring(as, as + len), b.substring(bs, bs + len), result));
    return result;
  }

  private boolean isPalindromic(String s) {
    int l = 0, r = s.length() - 1;
    while (l < r) {
      if (s.charAt(l) != s.charAt(r)) {
        return false;
      }
      l++;
      r--;
    }
    return true;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0005_LongestPalindromicSubstring_3()
      .longestPalindrome("abcdbbfcba");
  }
}
