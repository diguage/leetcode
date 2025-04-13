package com.diguage.algo.leetcode;

public class _0415_AddStrings_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-04-13 21:54:00
   */
  public String addStrings(String num1, String num2) {
    int m = num1.length() - 1, n = num2.length() - 1;
    char[] mc = num1.toCharArray();
    char[] nc = num2.toCharArray();
    StringBuilder sb = new StringBuilder(Math.max(m, n) + 1);
    int carry = 0;
    // 看官方答案，可以通过 m>=0 || n>=0 || carry !=0 来把三个循环合并成一个
    while (m >= 0 && n >= 0) {
      int mi = mc[m--] - '0';
      int ni = nc[n--] - '0';
      int sum = carry + mi + ni;
      carry = sum / 10;
      sb.append(sum % 10);
    }
    while (m >= 0) {
      int mi = mc[m--] - '0';
      int sum = carry + mi;
      carry = sum / 10;
      sb.append(sum % 10);
    }
    while (n >= 0) {
      int ni = nc[n--] - '0';
      int sum = carry + ni;
      carry = sum / 10;
      sb.append(sum % 10);
    }
    if (carry > 0) {
      sb.append(carry);
    }
    return sb.reverse().toString();
  }
  // end::answer[]
}
