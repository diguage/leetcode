package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0015_3Sum_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2018-07-15 00:58
   */
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    return numSum(nums, 0, 3, 0);
  }

  private List<List<Integer>> numSum(int[] nums, int index, int count, int target) {
    if (index + count > nums.length || count < 2) {
      return new ArrayList<>();
    }
    if (count == 2) {
      int left = index, right = nums.length - 1;
      List<List<Integer>> result = new ArrayList<>();
      while (left < right) {
        int ln = nums[left], rn = nums[right];
        if (target < ln) {
          break;
        }
        int sum = ln + rn;
        if (sum == target) {
          result.add(new ArrayList<>(List.of(ln, rn)));
          while (left < right && nums[left] == ln) {
            left++;
          }
          while (left < right && nums[right] == rn) {
            right--;
          }
        } else if (target < sum) {
          while (left < right && nums[right] == rn) {
            right--;
          }
        } else {
          while (left < right && nums[left] == ln) {
            left++;
          }
        }
      }
      return result;
    } else {
      List<List<Integer>> result = new ArrayList<>();
      while (index + count <= nums.length) {
        int sn = nums[index];
        List<List<Integer>> temp = numSum(nums, index + 1, count - 1, target - sn);
        for (List<Integer> l : temp) {
          l.add(sn);
          result.add(l);
        }
        while (index + count <= nums.length && nums[index] == sn) {
          index++;
        }
      }
      return result;
    }
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0015_3Sum_5().threeSum(new int[]{0, 0, 0});
  }
}
