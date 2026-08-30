package com.diguage.algo.leetcode;

public class _1343_NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-08-30 23:29:14
   */
  public int numOfSubarrays(int[] arr, int k, int threshold) {
    int result = 0;
    int sum = 0;
    threshold *= k;
    for (int i = 0; i < k - 1; i++) {
      sum += arr[i];
    }
    for (int i = k - 1; i < arr.length; i++) {
      sum += arr[i];
      if (sum >= threshold) {
        result++;
      }
      sum -= arr[i - k + 1];
    }

    return result;
  }
  // end::answer[]
}
