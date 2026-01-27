package com.diguage.algo.leetcode;

public class _1442_CountTripletsThatCanFormTwoArraysOfEqualXor_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-27 20:12:45
   */
  public int countTriplets(int[] a) {
    int result = 0;
    for (int i = 0; i < a.length - 1; i++) {
      int ap = a[i];
      for (int j = i + 1; j < a.length; j++) {
        if (j - i > 1) {
          ap ^= a[j - 1];
        }
        int bp = a[j];
        for (int k = j; k < a.length; k++) {
          if (k != j) {
            bp ^= a[k];
          }
          if (ap == bp) {
            System.out.printf("i=%d, j=%d, k=%d\n", i, j, k);
            result++;
          }
        }
      }
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _1442_CountTripletsThatCanFormTwoArraysOfEqualXor_2()
      .countTriplets(new int[]{2, 3, 1, 6, 7});
  }
}
