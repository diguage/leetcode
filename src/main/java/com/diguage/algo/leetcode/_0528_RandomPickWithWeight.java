package com.diguage.algo.leetcode;

import java.util.Random;

public class _0528_RandomPickWithWeight {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-08-16 16:14:41
   */
  class Solution {

    private int[] preSum;
    private Random random;

    public Solution(int[] w) {
      preSum = new int[w.length + 1];
      preSum[0] = 0;
      for (int i = 1; i <= w.length; i++) {
        preSum[i] = preSum[i - 1] + w[i - 1];
      }
      random = new Random();
    }

    public int pickIndex() {
      if (preSum.length == 0) return -1;
      int target = random.nextInt(preSum[preSum.length - 1]) + 1;
      int left = 1, right = preSum.length;
      while (left < right) {
        int mid = left + (right - left) / 2;
        if (preSum[mid] == target) {
          right = mid;
        } else if (preSum[mid] < target) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }
      return left - 1;
    }
  }
  // end::answer[]
}
