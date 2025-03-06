package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0015_3Sum_3 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-03-06 16:53:23
   */
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    return numsSum(nums, 0, 3, 0);
  }

  /**
   * 通用方法，可以处理 count 数之和
   */
  private List<List<Integer>> numsSum(int[] nums, int idx, int count, int sum) {
    // 剩余数组长度不够，直接返回
    if (nums.length - idx < count || count < 2) {
      return new ArrayList<>();
    }
    List<List<Integer>> result = new ArrayList<>();
    if (count == 2) {
      int left = idx, right = nums.length - 1;
      while (left < right) {
        int leftNum = nums[left];
        int rightNum = nums[right];
        int iSum = leftNum + rightNum;
        if (iSum == sum) {
          result.add(new ArrayList<>(Arrays.asList(leftNum, rightNum)));
          // 不允许有重复数组，则将重复元素都排除掉
          while (left < right && leftNum == nums[left]) {
            left++;
          }
          while (left < right && rightNum == nums[right]) {
            right--;
          }
        } else if (iSum < sum) {
          while (left < right && leftNum == nums[left]) {
            left++;
          }
        } else {
          while (left < right && rightNum == nums[right]) {
            right--;
          }
        }
      }
      return result;
    } else {
      for (int i = idx; i < nums.length; i++) {
        int num = nums[i];
        // 在这里，递归相当一层循环，无论 count 值多大，就可以通过增加递归次数，来降低 count 的值
        List<List<Integer>> lists = numsSum(nums, i + 1, count - 1, sum - num);
        for (List<Integer> list : lists) {
          list.add(num);
          result.add(list);
        }
        // 不允许有重复数组，则将重复元素都排除掉
        // 使用 nums[i] == nums[i + 1] 来判断，因为执行完该语句之后，还有一个 i++ 要执行
        while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
          i++;
        }
      }
    }
    return result;
  }
  // end::answer[]
}
