package com.diguage.algo.leetcode;

import java.util.*;

public class _0870_AdvantageShuffle {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-08-16 20:44:53
   */
  public int[] advantageCount(int[] nums1, int[] nums2) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    for (int i = 0; i < nums2.length; i++) {
      pq.offer(new int[]{i, nums2[i]});
    }
    Arrays.sort(nums1);
    int left = 0, right = nums1.length - 1;
    int[] result = new int[nums1.length];
    while (!pq.isEmpty()) {
      int[] nums = pq.poll();
      if (nums[1] < nums1[right]) {
        result[nums[0]] = nums1[right];
        right--;
      } else {
        result[nums[0]] = nums1[left];
        left++;
      }
    }
    return result;
  }
  // end::answer[]
}
