package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0477_TotalHammingDistance {
  // tag::answer[]
  /**
   * 优化前：通过 35 / 46 个测试用例。
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-03 22:03:55
   */
  public int totalHammingDistance(int[] nums) {
    int result = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int num = nums[i] ^ nums[j];
        if (map.containsKey(num)) {
          result += map.get(num);
        } else {
          int bits = bits(num);
          map.put(num, bits);
          result += bits;
        }
      }
    }
    return result;
  }

  private int bits(int num) {
    int result = 0;
    while (num > 0) {
      num = num & (num - 1);
      result++;
    }
    return result;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0477_TotalHammingDistance()
      .totalHammingDistance(new int[]{4, 14, 2});
  }
}
