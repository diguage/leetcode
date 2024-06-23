package com.diguage.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * = 560. Subarray Sum Equals K
 *
 * https://leetcode.com/problems/subarray-sum-equals-k/[Subarray Sum Equals K - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-30 23:14
 */
public class _0560_SubarraySumEqualsK {
    /**
     * Runtime: 12 ms, faster than 97.62% of Java online submissions for Subarray Sum Equals K.
     * Memory Usage: 42.2 MB, less than 5.43% of Java online submissions for Subarray Sum Equals K.
     *
     * Copy from: https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/he-wei-kde-zi-shu-zu-by-leetcode/[和为K的子数组 - 和为K的子数组 - 力扣（LeetCode）]
     */
    public int subarraySum(int[] nums, int k) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        int count = 0, sum = 0;
        Map<Integer, Integer> sumToCountMap = new HashMap<>();
        sumToCountMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumToCountMap.containsKey(sum - k)) {
                count += sumToCountMap.get(sum - k);
            }
            sumToCountMap.put(sum, sumToCountMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        _0560_SubarraySumEqualsK solution = new _0560_SubarraySumEqualsK();

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
