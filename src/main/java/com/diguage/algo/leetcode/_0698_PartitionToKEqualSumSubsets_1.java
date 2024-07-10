package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0698_PartitionToKEqualSumSubsets_1 {
  // tag::answer[]
  /**
   * 第一版：超时，通过 150/163 个测试用例
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-07-10 17:53:39
   */
  public boolean canPartitionKSubsets(int[] nums, int k) {
    if (nums == null || nums.length == 0 || nums.length < k) {
      return false;
    }
    // 总和不能整除，肯定无法均分
    int sum = Arrays.stream(nums).sum();
    if (sum % k != 0) {
      return false;
    }
    int[] bucket = new int[k];
    int target = sum / k;
    return backtrack(nums, 0, bucket, target);
  }

  private boolean backtrack(int[] nums, int start, int[] bucket, int target) {
    // 遍历完了所有数组
    if (start == nums.length) {
      return true;
    }
    for (int i = 0; i < bucket.length; i++) {
      // 剪枝：如果该桶总和大于平均值，则跳过
      if (target < nums[start] + bucket[i]) {
        continue;
      }
      bucket[i] += nums[start];
      if (backtrack(nums, start + 1, bucket, target)) {
        return true;
      }
      bucket[i] -= nums[start];
    }
    return false;
  }
  // end::answer[]
}
