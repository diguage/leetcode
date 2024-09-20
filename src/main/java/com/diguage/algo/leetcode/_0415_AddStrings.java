package com.diguage.algo.leetcode;

public class _0415_AddStrings {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-20 22:18:41
   */
  public String addStrings(String num1, String num2) {
    int max = 0, diff = 0;
    if (num1.length() < num2.length()) {
      String tmp = num1;
      num1 = num2;
      num2 = tmp;
    }
    max = num1.length();
    diff = max - num2.length();
    int carry = 0;
    String result = "";
    for (int i = max - 1; i >= 0; i--) {
      int n1 = num1.charAt(i) - '0';
      int n2 = 0;
      if (i - diff >= 0) {
        n2 = num2.charAt(i - diff) - '0';
      }
      int sum = n1 + n2 + carry;
      carry = sum / 10;
      result = (sum % 10) + result;
    }
    return carry == 0 ? result : "1" + result;
  }
  // end::answer[]

  public static void main(String[] args) {
    _0415_AddStrings solution = new _0415_AddStrings();
    String result = solution.addStrings("11", "123");
    System.out.println(result);
  }
}
