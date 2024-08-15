package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _0015_3Sum_20 {
  // tag::answer[]

  /**
   * 双指针
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-08-15 16:08:08
   */
  public List<List<Integer>> threeSum(int[] nums) {
    if (nums == null || nums.length < 3) {
      return Collections.emptyList();
    }
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
      if (nums[i] > 0) {
        break;
      }
      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }
      int l = i + 1, r = nums.length - 1;
      while (l < r) {
        int sum = nums[i] + nums[l] + nums[r];
        if (sum < 0) {
          while (l < r && nums[l] == nums[++l]) ;
        } else if (0 < sum) {
          while (l < r && nums[r] == nums[--r]) ;
        } else {
          result.add(Arrays.asList(nums[i], nums[l], nums[r]));
          while (l < r && nums[l] == nums[++l]) ;
          while (l < r && nums[r] == nums[--r]) ;
        }
      }
    }
    return result;
  }
  // end::answer[]
}
