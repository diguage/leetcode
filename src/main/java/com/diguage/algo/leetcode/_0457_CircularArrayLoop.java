package com.diguage.algo.leetcode;

import java.util.Objects;

public class _0457_CircularArrayLoop {
  // tag::answer[]

  /**
   * 遍历过的节点都不会是环形数组（是环形数组已经返回结果了），
   * 所以，可以把遍历过的节点留痕，那么遇到遍历过的节点，
   * 就可以直接返回 true 了。这样时间复杂度就成了 O(n)。
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-23 21:19:58
   */
  public boolean circularArrayLoop(int[] nums) {
    int index = 2000 * nums.length;
    int base = 100000;
    for (int i = index; i < index + nums.length; i++) {
      int num = nums[i % nums.length];
      if (num < -1000) {
        continue;
      }
      boolean circular = backtrack(nums, i, base, num > 0, 0, null);
      if (circular) {
        return true;
      }
    }
    return false;
  }

  private boolean backtrack(int[] nums, int index, int base, boolean positive, int step, Integer last) {
    int i = index % nums.length;
    int num = nums[i];
    if (num < -1000) {
      return false;
    } else if (positive ? num > base : 1000 < num && num < base) {
      return step > 1 && last != null && !Objects.equals(last, i);
    } else if ((num > 0) != positive) {
      return false;
    }
    nums[i] = base + num;
    boolean result = backtrack(nums, index + num, base, positive, step + 1, i);
    nums[i] = -nums[i];
    return result;
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0457_CircularArrayLoop().circularArrayLoop(new int[]{-1, -2, -3, -4, -5});
  }
}
