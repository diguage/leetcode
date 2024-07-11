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
    int target = sum / k;
    // 排序：逆序先放大元素，这样减少回溯的可能和次数
    Arrays.sort(nums);
    for (int l = 0, r = nums.length - 1; l < r; l++, r--) {
      int temp = nums[l];
      nums[l] = nums[r];
      nums[r] = temp;
    }
    // 最大元素大于平均值，也不可能平分，直接返回
    if (target < nums[0]) {
      return false;
    }
    int[] bucket = new int[k];
    return backtrack(nums, 0, bucket, target);
  }

  private boolean backtrack(int[] nums, int start, int[] bucket, int target) {
    // 遍历完数组内所有的数字，那么就成功
    if (start == nums.length) {
      return true;
    }
    for (int i = 0; i < bucket.length; i++) {
      // 剪枝：如果两个桶的值一样，只要做一个尝试即可
      // 这里也包含了：第一个数字放在第一个桶的优化点
      // 解释：最初始时，所有的桶都是0，在执行完第一个桶后，
      //      由于回溯一加一减，所有的桶还是0，后面的桶就直接跳过了。
      if (0 < i && bucket[i - 1] == bucket[i]) {
        continue;
      }
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
