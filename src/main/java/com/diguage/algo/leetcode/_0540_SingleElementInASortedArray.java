package com.diguage.algo.leetcode;

public class _0540_SingleElementInASortedArray {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-05 18:57:13
   */
  public int singleNonDuplicate(int[] nums) {
    int length = nums.length;
    if (length == 1) {
      return nums[0];
    }
    int left = 0, right = length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (((mid == 0 && nums[mid] != nums[mid + 1]) || (0 < mid && nums[mid - 1] != nums[mid]))
        && ((mid < length - 1 && nums[mid] != nums[mid + 1]) || (mid == length - 1 && nums[mid - 1] != nums[mid]))) {
        return nums[mid];
      }
      if (mid < right) {
        if (nums[mid] != nums[mid + 1]) {
          mid++;
        }
      } else {
        if (left < mid) {
          mid--;
        }
      }
      if ((mid - left) % 2 == 0) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return 0;
  }

  // end::answer[]
  static void main() {
    new _0540_SingleElementInASortedArray()
      .singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11});
  }
}
