package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0401_BinaryWatch {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-21 18:58:09
   */
  public List<String> readBinaryWatch(int turnedOn) {
    int[] nums = new int[]{1, 2, 4, 8, 16, 32, 1, 2, 4, 8};
    List<String> result = new ArrayList<>();
    boolean[] used = new boolean[10];
    backtrack(nums, result, used, turnedOn, 0, 0, 0);
    return result;
  }

  private void backtrack(int[] nums, List<String> result, boolean[] used,
                         int turnedOn, int hour, int minute, int start) {
    if (turnedOn >= 9) {
      return;
    }
    if (turnedOn == 0) {
      result.add(String.format("%d:%02d", hour, minute));
      return;
    }
    for (int i = start; i < nums.length; i++) {
      if (used[i]) {
        continue;
      }
      used[i] = true;
      if (i <= 5) {
        if (minute + nums[i] <= 59) {
          backtrack(nums, result, used, turnedOn - 1, hour, minute + nums[i], i + 1);
        }
      } else {

        if (hour + nums[i] <= 11) {
          backtrack(nums, result, used, turnedOn - 1, hour + nums[i], minute, i + 1);
        }
      }
      used[i] = false;
    }
  }

  // end::answer[]
  public static void main(String[] args) {
    System.out.println(new _0401_BinaryWatch().readBinaryWatch(2));
  }
}
