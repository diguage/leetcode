package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _0229_MajorityElementIi_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-02-10 22:48:52
   */
  public List<Integer> majorityElement(int[] nums) {
    if (nums == null || nums.length == 0) {
      return Collections.emptyList();
    }
    int card1 = nums[0], count1 = 0;
    int card2 = nums[0], count2 = 0;
    for (int num : nums) {
      if (num == card1) {
        count1++;
        continue;
      }
      if (num == card2) {
        count2++;
        continue;
      }
      if (count1 == 0) {
        card1 = num;
        count1++;
        continue;
      }
      if (count2 == 0) {
        card2 = num;
        count2++;
        continue;
      }
      count1--;
      count2--;
    }
    count1 = 0;
    count2 = 0;
    for (int num : nums) {
      if (num == card1) {
        count1++;
      } else if (num == card2) {
        count2++;
      }
    }
    List<Integer> result = new ArrayList<>();
    if (count1 > nums.length / 3) {
      result.add(card1);
    }
    if (count2 > nums.length / 3) {
      result.add(card2);
    }
    return result;
  }
  // end::answer[]
}
