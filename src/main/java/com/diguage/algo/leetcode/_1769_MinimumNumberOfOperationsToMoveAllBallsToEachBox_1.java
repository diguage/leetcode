package com.diguage.algo.leetcode;

public class _1769_MinimumNumberOfOperationsToMoveAllBallsToEachBox_1 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-11 20:51:33
   */
  public int[] minOperations(String boxes) {
    int length = boxes.length();
    int[] lop = new int[length];
    int left = 0;
    for (int i = 0; i < length; i++) {
      if (i > 0) {
        lop[i] = lop[i - 1] + left;
      }
      if (boxes.charAt(i) == '1') {
        left++;
      }
    }
    int right = 0;
     int[] result = new int[length];
    for (int i = length - 1; i >= 0; i--) {
      if (i < length - 1) {
        result[i] = result[i + 1] + right;
      }
      if (boxes.charAt(i) == '1') {
        right++;
      }
    }
    for (int i = 0; i < length; i++) {
      result[i] = lop[i] + result[i];
    }
    return result;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _1769_MinimumNumberOfOperationsToMoveAllBallsToEachBox_1()
      .minOperations("1010101010");
  }
}
