package com.diguage.algo.leetcode;

public class _1769_MinimumNumberOfOperationsToMoveAllBallsToEachBox {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-11 20:51:33
   */
  public int[] minOperations(String boxes) {
    int length = boxes.length();
    int[] result = new int[length];
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        if (boxes.charAt(j) == '1') {
          result[i] += Math.abs(i - j);
        }
      }
    }
    return result;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _1769_MinimumNumberOfOperationsToMoveAllBallsToEachBox()
      .minOperations("1010101010");
  }
}
