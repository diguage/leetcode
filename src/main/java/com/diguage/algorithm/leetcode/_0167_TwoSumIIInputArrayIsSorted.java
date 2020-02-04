package com.diguage.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * = 167. Two Sum II - Input array is sorted
 *
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/[Two Sum II - Input array is sorted - LeetCode]
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-02-04 23:35
 */
public class _0167_TwoSumIIInputArrayIsSorted {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum II - Input array is sorted.
     * Memory Usage: 42.2 MB, less than 5.22% of Java online submissions for Two Sum II - Input array is sorted.
     *
     * Copy from: https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/solution/liang-shu-zhi-he-ii-shu-ru-you-xu-shu-zu-by-leetco/[两数之和 II - 输入有序数组 - 两数之和 II - 输入有序数组 - 力扣（LeetCode）]
     */
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }

        return new int[]{-1, -1};
    }

    /**
     * Runtime: 4 ms, faster than 14.69% of Java online submissions for Two Sum II - Input array is sorted.
     * Memory Usage: 41.8 MB, less than 5.22% of Java online submissions for Two Sum II - Input array is sorted.
     */
    public int[] twoSumPair(int[] numbers, int target) {
        Map<Integer, Pair> valueToIndexMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            valueToIndexMap.put(numbers[i], new Pair(numbers[i], i + 1));
        }
        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            if (valueToIndexMap.containsKey(diff)) {
                Pair pair = valueToIndexMap.get(diff);
                return new int[]{i + 1, pair.index};
            }
        }
        return null;
    }

    private class Pair {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        _0167_TwoSumIIInputArrayIsSorted solution = new _0167_TwoSumIIInputArrayIsSorted();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
