package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0164_MaximumGap {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-29 11:13:03
   */
  public int maximumGap(int[] nums) {
    int max = Arrays.stream(nums).max().orElse(0);
    long[] bits = new long[max / 64 + 1];
    for (int num : nums) {
      int index = num / 64;
      int step = num % 64;
      bits[index] = bits[index] | (1L << step);
    }
    int result = 0;
    int pre = -1;
    for (int i = 0; i < bits.length; i++) {
      long bit = bits[i];
      if (bit == 0) {
        continue;
      }
      int step = 0;
      int start = i * 64;
      while (bit != 0) {
        if ((bit & 1) == 1) {
          if (pre == -1) {
            pre = start + step;
          } else {
            int next = start + step;
            result = Math.max(result, next - pre);
            pre = next;
          }
        }
        step++;
        // 注意：这里要使用 >>> 无符号右移
        bit >>>= 1;
      }

    }
    return result;
  }

  //  // 最简单的写法
  //  public int maximumGap(int[] nums) {
  //    Arrays.sort(nums);
  //    int result = 0;
  //    for (int i = 1; i < nums.length; i++) {
  //      result = Math.max(result, nums[i] - nums[i - 1]);
  //    }
  //    return result;
  //  }

  // end::answer[]
  public static void main(String[] args) {
    new _0164_MaximumGap().maximumGap(new int[]{2, 99999999});
  }
}
