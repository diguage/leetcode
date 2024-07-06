package com.diguage.algorithm.leetcode;

import java.util.*;

/**
 * = 560. Subarray Sum Equals K
 *
 * https://leetcode.com/problems/subarray-sum-equals-k/[Subarray Sum Equals K - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2024-06-23 11:08:29
 */
public class _0560_SubarraySumEqualsK_2 {
  // tag::answer[]
    /**
     * 自己根据“前缀和”套路想的思路，参考 https://leetcode.cn/problems/subarray-sum-equals-k/solutions/238572/he-wei-kde-zi-shu-zu-by-leetcode-solution/[560. 和为 K 的子数组 - 官方题解^] 更正了代码。
     */
    public int subarraySum(int[] nums, int k) {
      int result = 0;
      if (nums == null || nums.length == 0) {
        return result;
      }
      // key：前缀和，value：key 对应的前缀和的个数
      Map<Integer, Integer> sumToCntMap = new HashMap<>();
      // 对于下标为 0 的元素，前缀和为 0，个数为 1
      sumToCntMap.put(0, 1);
      int sum = 0;
      for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        // 先获得前缀和为 preSum - k 的个数，加到计数变量里
        // TODO 这里为什么先检查是否存在？
        if (sumToCntMap.containsKey(sum - k)) {
          result += sumToCntMap.get(sum - k);
        }
        // 然后维护 preSumFreq 的定义
        sumToCntMap.put(sum, sumToCntMap.getOrDefault(sum, 0) + 1);
      }
      return result;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0560_SubarraySumEqualsK_2 solution = new _0560_SubarraySumEqualsK_2();

        int[] n4 = {3, 4, 7, 2, -3, 1, 4, 2};
        int r4 = solution.subarraySum(n4, 7);
        System.out.println((r4 == 4) + " : " + r4);

        int[] n3 = {1};
        int r3 = solution.subarraySum(n3, 0);
        System.out.println((r3 == 0) + " : " + r3);

        int[] n2 = {-1, -1, 1};
        int r2 = solution.subarraySum(n2, 0);
        System.out.println((r2 == 1) + " : " + r2);

        int[] n1 = {1, 1, 1};
        int r1 = solution.subarraySum(n1, 2);
        System.out.println((r1 == 2) + " : " + r1);
    }
}
