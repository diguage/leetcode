package com.diguage.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * = 239. Sliding Window Maximum
 *
 * https://leetcode.com/problems/sliding-window-maximum/[Sliding Window Maximum - LeetCode]
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-30 17:00
 */
public class _0239_SlidingWindowMaximum {
    /**
     * Runtime: 9 ms, faster than 85.37% of Java online submissions for Sliding Window Maximum.
     * Memory Usage: 56.6 MB, less than 6.25% of Java online submissions for Sliding Window Maximum.
     *
     * Copy from: https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetcode-3/[滑动窗口最大值 - 滑动窗口最大值 - 力扣（LeetCode）]
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (Objects.isNull(nums) || nums.length == 0 || k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int n = nums.length;
        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            if (i % k == 0) {
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i - 1], nums[i]);
            }

            int j = n - i - 1;
            if ((j + 1) % k == 0) {
                right[j] = nums[j];
            } else {
                right[j] = Math.max(nums[j], right[j + 1]);
            }
        }

        int[] result = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            result[i] = Math.max(left[i + k - 1], right[i]);
        }

        return result;
    }

    /**
     * Runtime: 25 ms, faster than 30.23% of Java online submissions for Sliding Window Maximum.
     * Memory Usage: 48.5 MB, less than 6.25% of Java online submissions for Sliding Window Maximum.
     */
    public int[] maxSlidingWindowMax(int[] nums, int k) {
        if (Objects.isNull(nums) || nums.length == 0 || k == 0) {
            return new int[0];
        }
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            integers.add(max);
        }
        int[] result = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            result[i] = integers.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        _0239_SlidingWindowMaximum solution = new _0239_SlidingWindowMaximum();
        int[] n1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] r1 = solution.maxSlidingWindow(n1, 5);
        System.out.println(Arrays.toString(r1));
    }
}
