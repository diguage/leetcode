package com.diguage.algo.leetcode;

import java.util.Arrays;

public class _0475_Heaters {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-01 22:08:15
   */
  public int findRadius(int[] houses, int[] heaters) {
    Arrays.sort(heaters);
    int result = 0;
    for (int house : houses) {
      // 寻找 house 左侧最近加热器
      int left = binarySearch(heaters, house);
      int right = left + 1;
      int leftDistance = left < 0 ? Integer.MAX_VALUE : house - heaters[left];
      int rightDistance = right >= heaters.length ? Integer.MAX_VALUE : heaters[right] - house;
      // 选择距离房子 house 最近的加热器
      int distance = Math.min(leftDistance, rightDistance);
      result = Math.max(result, distance);
    }
    return result;
  }

  private int binarySearch(int[] nums, int target) {
    if (target < nums[0]) {
      return -1;
    }
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left - 1;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0475_Heaters().findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4});
  }
}
