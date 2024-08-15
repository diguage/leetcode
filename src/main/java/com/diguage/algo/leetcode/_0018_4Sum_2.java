package com.diguage.algo.leetcode;

import java.util.*;

/**
 * = 18. 4Sum
 *
 * https://leetcode.com/problems/4sum/description/[4Sum - LeetCode]
 *
 * Given an array `nums` of n integers and an integer `target`, are there
 * elements `a`, `b`, `c`, and `d` in `nums` such that `a + b + c + d = target`?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * == Note
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * .Example:
 * [source]
 * ----
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 * ----
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2018-07-15 00:58
 */
public class _0018_4Sum_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-08-15 18:37:58
   */
  public List<List<Integer>> fourSum(int[] nums, int target) {
    if (nums == null || nums.length < 4) {
      return Collections.emptyList();
    }
    Arrays.sort(nums);
    return numSum(nums, 0, 4, target);
  }

  private List<List<Integer>> numSum(int[] nums, int idx, int cnt, long target) {
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

  public static void main(String[] args) {
    _0018_4Sum_2 solution = new _0018_4Sum_2();
    List<List<Integer>> r1 = solution.fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296);
    System.out.println(Arrays.deepToString(r1.toArray()));
  }
}
