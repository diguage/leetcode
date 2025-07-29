package com.diguage.algo.leetcode;

public class _0393_Utf8Validation {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-29 23:06:41
   */
  public boolean validUtf8(int[] data) {
    boolean result = true;
    int step = 0;
    for (int i = 0; i < data.length; i++) {
      int num = data[i];
      if (step == 0 && 0 <= num && num <= 0B1111111) {
      } else if (step >= 1 && 0B10000000 <= num && num <= 0B10111111) {
        step--;
      } else if (step == 0 & (0B11000000 <= num && num <= 0B11011111)) {
        step = 1;
      } else if (step == 0 & (0B11100000 <= num && num <= 0B11101111)) {
        step = 2;
      } else if (step == 0 & (0B11110000 <= num && num <= 0B11110111)) {
        step = 3;
      } else {
        return false;
      }
    }
    if (step > 0) {
      return false;
    }
    return result;
  }

  // end::answer[]
  public static void main(String[] args) {
    System.out.println(new _0393_Utf8Validation().validUtf8(new int[]{237}));
  }
}
