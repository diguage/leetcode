package com.diguage.algo.leetcode;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-17 17:22:04
 */
public class _0453_MinimumMovesToEqualArrayElements {
  // tag::answer[]
  /**
   * 参考： https://leetcode.cn/problems/minimum-moves-to-equal-array-elements/solutions/1054870/zui-xiao-cao-zuo-ci-shu-shi-shu-zu-yuan-3meg3/[453. 最小操作次数使数组元素相等 官方题解^]
   */
  public int minMoves(int[] nums) {
    if (Objects.isNull(nums) || nums.length <= 1) {
      return 0;
    }
    int min = Arrays.stream(nums).min().getAsInt();
    int result = 0;
    for (int num : nums) {
      result += (num - min);
    }
    return result;
  }
  // end::answer[]
}
