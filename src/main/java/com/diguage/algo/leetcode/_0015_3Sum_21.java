package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _0015_3Sum_21 {
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
    return numSum(nums, 0, 3, 0);
  }

  private List<List<Integer>> numSum(int[] nums, int idx, int cnt, int target) {
    // 剩余长度不够，则直接返回
    if (nums.length - idx < cnt || cnt < 2) {
      return new ArrayList<>();
    }
    List<List<Integer>> result = new ArrayList<>();
    if (cnt == 2) {
      int l = idx;
      int r = nums.length - 1;
      while (l < r) {
        int sum = nums[l] + nums[r];
        int left = nums[l];
        int right = nums[r];
        if (sum < target) {
          while (l < r && nums[l] == left) {
            l++;
          }
        } else if (target < sum) {
          while (l < r && nums[r] == right) {
            r--;
          }
        } else {
          result.add(new ArrayList<>(Arrays.asList(left, right)));
          while (l < r && nums[l] == left) {
            l++;
          }
          while (l < r && nums[r] == right) {
            r--;
          }
        }
      }
    } else {
      for (int i = idx; i < nums.length; i++) {
        int num = nums[i];
        List<List<Integer>> temp = numSum(nums, i + 1, cnt - 1, target - num);
        for (List<Integer> rs : temp) {
          rs.addFirst(num);
          result.add(rs);
        }
        while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
          i++;
        }
      }
    }
    return result;
  }
  // end::answer[]
}
