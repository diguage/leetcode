package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0015_3Sum_4 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-03-06 16:53:23
   */
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    return numSum(nums, 0, 3, 0);
  }

  private List<List<Integer>> numSum(int[] nums, int idx, int cnt, int target) {
    // 剩余数组长度不够，直接返回
    if (nums.length - idx < cnt || cnt < 2) {
      return new ArrayList<>();
    }
    if (cnt > 2) {
      List<List<Integer>> result = new ArrayList<>();
      while (idx < nums.length) {
        int in = nums[idx];
        if (in > target) {
          break;
        }
        // 利用递归推进下标前进，这样多少个数的sum都可以处理
        List<List<Integer>> temp = numSum(nums, idx + 1, cnt - 1, target - in);
        for (List<Integer> res : temp) {
          res.add(in);
          result.add(res);
        }
        // 不允许有重复数组，则跳过重复元素
        while (idx < nums.length && in == nums[idx]) {
          idx++;
        }
      }
      return result;
    } else {
      List<List<Integer>> result = new ArrayList<>();
      int l = idx, r = nums.length - 1;
      while (l < r) {
        int ln = nums[l];
        if (target < ln) {
          break;
        }
        int rn = nums[r];
        int sum = ln + rn;
        if (sum == target) {
          result.add(new ArrayList<>(Arrays.asList(ln, rn)));
          // 跳过重复元素
          while (l < r && nums[l] == ln) {
            l++;
          }
          while (l < r && nums[r] == rn) {
            r--;
          }
        } else if (sum < target) {
          // 跳过重复元素
          while (l < r && nums[l] == ln) {
            l++;
          }
        } else {
          // 跳过重复元素
          while (l < r && nums[r] == rn) {
            r--;
          }
        }
      }
      return result;
    }
  }
  // end::answer[]

  public static void main(String[] args) {
    List<List<Integer>> result = new _0015_3Sum_4().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    System.out.println(Arrays.toString(result.toArray()));
  }
}
