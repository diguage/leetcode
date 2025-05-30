package com.diguage.algo.leetcode;

public class _1362_ClosestDivisors {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-30 19:50:44
   */
  public int[] closestDivisors(int num) {
    int a = 1, b = num + 2;
    int[] result = {a, b};
    while (a <= b) {
      int mul = a * b;
      if (mul == num + 1 || mul == num + 2) {
        if (b - a < result[1] - result[0]) {
          result[0] = a;
          result[1] = b;
        }

      } else if (mul < num + 1) {
        int temp = (num + 1) / b;
        if (temp > a) {
          a = temp;
        } else {
          a++;
        }
      } else {
        int tem = (num + 2) / a + 1;
        if (tem < b) {
          b = tem;
        } else {
          b--;
        }
      }
    }
    return result;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _1362_ClosestDivisors().closestDivisors(1);
  }
}
