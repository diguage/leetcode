package com.diguage.algo.leetcode;

public class _1442_CountTripletsThatCanFormTwoArraysOfEqualXor {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-28 21:33:59
   */
  public int countTriplets(int[] arr) {
    int length = arr.length;
    int[] pre = new int[length + 1];
    for (int i = 0; i < length; i++) {
      pre[i + 1] = pre[i] ^ arr[i];
    }
    int result = 0;
    // 优化前
    // for (int i = 0; i < length - 1; i++) {
    //   for (int j = i + 1; j < length; j++) {
    //     for (int k = j; k < length; k++) {
    //       if (pre[i] == pre[k + 1]) {
    //         result++;
    //       }
    //     }
    //   }
    // }
    // 优化后
    for (int i = 0; i < length - 1; i++) {
      for (int k = i + 1; k < length; k++) {
        if (pre[i] == pre[k + 1]) {
          result += k - i;
        }
      }
    }
    return result;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _1442_CountTripletsThatCanFormTwoArraysOfEqualXor()
      .countTriplets(new int[]{7, 7, 7, 7});
  }
}
