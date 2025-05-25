package com.diguage.algo.leetcode;

public class _1052_GrumpyBookstoreOwner {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-25 20:02:35
   */
  public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
    int sum = 0;
    for (int i = 0; i < customers.length; i++) {
      if (grumpy[i] == 0) {
        sum += customers[i];
      }
    }
    int slow = 0, fast = 0;
    int incre = 0;
    int winSum = 0;
    while (fast < customers.length) {
      if (grumpy[fast] == 1) {
        winSum += customers[fast];
      }
      while (fast - slow + 1 > minutes) {
        if (grumpy[slow] == 1) {
          winSum -= customers[slow];
        }
        slow++;
      }
      incre = Math.max(incre, winSum);
      fast++;
    }
    return incre + sum;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _1052_GrumpyBookstoreOwner()
      .maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5},
        new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3);
  }
}
