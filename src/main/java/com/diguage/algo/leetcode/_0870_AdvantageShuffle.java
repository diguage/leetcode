package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _0870_AdvantageShuffle {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-08-16 20:44:53
   */
  public int[] advantageCount(int[] nums1, int[] nums2) {
    // idx 中存的就是每个 nums2 数组中对应的下标
    Integer[] idx = new Integer[nums2.length];
    for (int i = 0; i < nums2.length; i++) {
      idx[i] = i;
    }
    // 利用 nums2 中数字的大小，对下标进行排序
    // 这样可以保持 nums2 数字不变的情况下，对其数字进行排序。
    Arrays.sort(idx, Comparator.comparingInt(i -> nums2[i]));
    Arrays.sort(nums1);
    int left = 0, right = nums1.length - 1;
    int[] result = new int[nums1.length];
    for (int i = nums2.length - 1; i >= 0; i--) {
      int num = nums2[idx[i]];
      if (num < nums1[right]) {
        // nums1 能赢就直接上
        result[idx[i]] = nums1[right];
        right--;
      } else {
        // nums1 不能赢就选最小值当炮灰
        result[idx[i]] = nums1[left];
        left++;
      }
    }
    return result;
  }
  // end::answer[]
}
