package com.diguage.algo.leetcode;

public class _0537_ComplexNumberMultiplication {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-03 18:06:26
   */
  public String complexNumberMultiply(String num1, String num2) {
    int[] e1 = parse(num1);
    int[] e2 = parse(num2);
    int n1 = e1[0] * e2[0] - e1[1] * e2[1];
    int n2 = e1[1] * e2[0] + e1[0] * e2[1];
    return n1 + "+" + n2 + "i";
  }

  private int[] parse(String exp) {
    int index = exp.indexOf("+");
    return new int[]{
      Integer.parseInt(exp.substring(0, index)),
      Integer.parseInt(exp.substring(index + 1, exp.length() - 1)),
    };
  }
  // end::answer[]
  static void main() {
    new _0537_ComplexNumberMultiplication()
      .complexNumberMultiply("78+-76i", "-86+72i");
  }
}
