package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0368_LargestDivisibleSubset {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-22 21:04:16
   */
  public List<Integer> largestDivisibleSubset(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int[] lens = new int[n];
    int[] idx = new int[n];
    for (int i = 0; i < n; i++) {
      // 至少包含自身一个数，因此起始长度为 1，由自身转移而来
      int l = 1, p = i;
      for (int j = 0; j < i; j++) {
        if (nums[i] % nums[j] == 0) {
          // 如果能接在更长的序列后面，则更新「最大长度」&「从何转移而来」
          if (lens[j] + 1 > l) {
            l = lens[j] + 1;
            p = j;
          }
        }

      }
      // 记录「最终长度」&「从何转移而来」
      idx[i] = p;
      lens[i] = l;
    }
    // 遍历所有的 lens[i]，取得「最大长度」和「对应下标」
    int max = -1, index = -1;
    for (int i = 0; i < n; i++) {
      if (lens[i] > max) {
        max = lens[i];
        index = i;
      }
    }
    // 使用 idx[] 数组回溯出具体方案
    List<Integer> result = new ArrayList<>();
    while (result.size() < max) {
      result.add(nums[index]);
      index = idx[index];
    }
    return result;
  }
  // end::answer[]
}
