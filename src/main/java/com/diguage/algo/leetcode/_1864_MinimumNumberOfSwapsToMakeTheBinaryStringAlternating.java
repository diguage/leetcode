package com.diguage.algo.leetcode;

public class _1864_MinimumNumberOfSwapsToMakeTheBinaryStringAlternating {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-24 16:26:07
   */
  public int minSwaps(String s) {
    int[] bits = bits(s);
    int b0 = bits[0];
    int b1 = bits[1];
    int n = s.length();
    int result = Integer.MAX_VALUE;
    // 1010...
    if (b0 == n / 2 && b1 == (n + 1) / 2) {
      int diff = 0;
      for (int i = 0; i < n; i++) {
        if (s.charAt(i) - '0' == i % 2) {
          diff++;
        }
      }
      result = Math.min(result, diff / 2);
    }
    // 0101...
    if (b0 == (n + 1) / 2 && b1 == n / 2) {
      int diff = 0;
      for (int i = 0; i < n; i++) {
        if (s.charAt(i) - '0' != i % 2) {
          diff++;
        }
      }
      result = Math.min(result, diff / 2);
    }
    return result != Integer.MAX_VALUE ? result : -1;
  }

  private int[] bits(String s) {
    int b0 = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '0') {
        b0++;
      }
    }
    return new int[]{b0, s.length() - b0};
  }

  // end::answer[]

  public static void main(String[] args) {
    new _1864_MinimumNumberOfSwapsToMakeTheBinaryStringAlternating()
      .minSwaps("1110");
  }
}
