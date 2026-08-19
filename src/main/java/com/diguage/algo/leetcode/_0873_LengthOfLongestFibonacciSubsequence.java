package com.diguage.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _0873_LengthOfLongestFibonacciSubsequence {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-19 21:27:11
   */
  public int lenLongestFibSubseq(int[] arr) {
    Set<Integer> set = new HashSet<>();
    for (int num : arr) {
      set.add(num);
    }
    int result = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        int a = arr[i];
        int b = arr[j];
        int len = 0;
        if (arr[arr.length - 1] < (a + b)) {
          break;
        }
        while (set.contains(a + b)) {
          len++;
          int temp = a + b;
          System.out.println(a + " + " + b + " = " + temp);
          a = b;
          b = temp;
        }
        if (len > 0) {
          result = Math.max(result, len + 2);
        }
      }
    }
    return result;
  }

  // end::answer[]
  static void main() {
    new _0873_LengthOfLongestFibonacciSubsequence()
      .lenLongestFibSubseq(new int[]{2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50});
  }
}
