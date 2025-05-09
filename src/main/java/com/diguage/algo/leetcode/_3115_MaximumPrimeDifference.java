package com.diguage.algo.leetcode;

public class _3115_MaximumPrimeDifference {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-09 21:44:53
   */
  public int maximumPrimeDifference(int[] nums) {
    int min = -1;
    for (int i = 0; i < nums.length; i++) {
      if (isPrime(nums[i])) {
        min = i;
        break;
      }
    }
    int max = nums.length;
    for (int i = nums.length - 1; i >= min; i--) {
      if (isPrime(nums[i])) {
        max = i;
        break;
      }
    }
    return max - min;
  }

  private boolean isPrime(int num) {
    if (num < 2) {
      return false;
    }
    if (num == 2) {
      return true;
    }
    if ((num & 1) == 0) {
      return false;
    }
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
  // end::answer[]
}
