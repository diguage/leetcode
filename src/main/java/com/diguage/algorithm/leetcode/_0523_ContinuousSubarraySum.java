package com.diguage.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-23 00:23:40
 */
public class _0523_ContinuousSubarraySum {
  // tag::answer[]
  /**
   * 参考 https://leetcode.cn/problems/continuous-subarray-sum/solutions/807930/lian-xu-de-zi-shu-zu-he-by-leetcode-solu-rdzi/[523. 连续的子数组和 - 官方题解^]
   */
  public boolean checkSubarraySum(int[] nums, int k) {
    if (nums == null || nums.length < 2) {
      return false;
    }
    Map<Integer, Integer> remainderToIndexMap = new HashMap<>();
    // 当 sum=0 时，还没有任何数字参与，所以是 -1
    remainderToIndexMap.put(0, -1);
    int remainder = 0;
    for (int i = 0; i < nums.length; i++) {
      // 同余定理
      remainder = (remainder + nums[i]) % k;
      if (remainderToIndexMap.containsKey(remainder)) {
        int prevIndex = remainderToIndexMap.get(remainder);
        if (i - prevIndex >= 2) {
          return true;
        }
      } else {
        // 前面已经判断过是否包含该值，
        // 这里也就不需要为了保存最小的下标去判断是否已经存在该值
        remainderToIndexMap.put(remainder, i);
      }
    }
    return false;
  }

  // end::answer[]


  public static void main(String[] args) {
    _0523_ContinuousSubarraySum solution = new _0523_ContinuousSubarraySum();
    boolean result = solution.checkSubarraySum(new int[]{5, 0, 0, 0}, 3);
    System.out.println(result);
  }
}
