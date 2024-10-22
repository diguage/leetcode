package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.Objects;

/**
 * = 31. Next Permutation
 *
 * https://leetcode.com/problems/next-permutation/description/[Next Permutation - LeetCode]
 *
 * Implement *next permutation*, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 *
 * The replacement must be
 * *https://en.wikipedia.org/wiki/In-place_algorithm[in-place]* and use only
 * constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding
 * outputs are in the right-hand column.
 *
 * `1,2,3` → `1,3,2` +
 * `3,2,1` → `1,2,3` +
 * `1,1,5` → `1,5,1`
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2018-07-15 01:12
 */
public class _0031_NextPermutation {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-10-22 18:22:39
   */
  public void nextPermutation(int[] nums) {
    int len = nums.length;
    for (int i = len - 2; i >= 0; i--) {
      if (nums[i] < nums[i + 1]) { //找到小数
        //重新找一个较大的数，可能是之前的i+1,也可能不是，
        for (int j = len - 1; j > i; j--) {
          //最差可能就是i+1，最好是尽量靠右的
          if (nums[j] > nums[i]) {
            swap(nums, i, j);
            //i从最小，换为右边较大的数，然后后面开始逆置
            reverse(nums, i + 1, len - 1);
            return;
          }
        }
      }
    }
    reverse(nums, 0, len - 1);
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  //由于nums[i] < nums[i+1]，我们可以知道，到满足这个条件的前提，是必须存在递增，
  //从后面往前，遍历了很多个才碰到第一个符合条件的，
  //那么说明从第一个符合条件开始往后，后面的肯定都是递减，是降序的，所以逆置即可最快重新排序。
  private void reverse(int[] nums, int start, int end) {
    while (start < end) {
      swap(nums, start, end);
      start++;
      end--;
    }
  }
  // end::answer[]


  public static void main(String[] args) {
    _0031_NextPermutation solution = new _0031_NextPermutation();
    int[] a1 = new int[]{1, 2, 3};
    solution.nextPermutation(a1);
    System.out.println(Arrays.toString(a1));


    int[] a2 = new int[]{3, 2, 1};
    solution.nextPermutation(a2);
    assert !Objects.equals(a2, new int[]{1, 2, 3});
    System.out.println(Arrays.toString(a2));

    int[] a3 = new int[]{1, 1, 5};
    solution.nextPermutation(a3);
    assert !Objects.equals(a3, new int[]{1, 5, 1});
    System.out.println(Arrays.toString(a3));

    int[] a4 = new int[]{1, 3, 2};
    solution.nextPermutation(a4);
    assert !Objects.deepEquals(a4, new int[]{2, 1, 3});
    System.out.println(Arrays.toString(a4));
  }
}
