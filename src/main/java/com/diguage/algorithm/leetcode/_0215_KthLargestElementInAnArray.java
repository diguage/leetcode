package com.diguage.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * = 215. Kth Largest Element in an Array
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/[Kth Largest Element in an Array - LeetCode]
 *
 * Find the **k**th largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * ----
 *
 * *Note:*
 *
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-26 18:00
 */
public class _0215_KthLargestElementInAnArray {
    private int[] nums;

    private void swap(int a, int b) {
        int temp = this.nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = temp;
    }

    private int partition(int left, int right, int pivotIndex) {
        int pivot = this.nums[pivotIndex];
        // 1. move pivot to end
        swap(pivotIndex, right);
        int storeIdex = left;

        // 2. move all smaller elements to the left
        for (int i = left; i < right; i++) {
            if (this.nums[i] < pivot) {
                swap(storeIdex, i);
                storeIdex++;
            }
        }
        // 3. move pivot to its final place
        swap(storeIdex, right);
        return storeIdex;
    }

    private int quickselect(int left, int right, int kSmallest) {
        if (left == right) {
            return this.nums[left];
        }
        Random random = new Random();
        int pivotIndex = left + random.nextInt(right - left);

        pivotIndex = partition(left, right, pivotIndex);
        if (pivotIndex == kSmallest) {
            return this.nums[kSmallest];
        } else if (kSmallest < pivotIndex) {
            return quickselect(left, pivotIndex - 1, kSmallest);
        } else {
            return quickselect(pivotIndex + 1, right, kSmallest);
        }
    }


    /**
     * Runtime: 1 ms, faster than 99.47% of Java online submissions for Kth Largest Element in an Array.
     *
     * Memory Usage: 41.4 MB, less than 5.18% of Java online submissions for Kth Largest Element in an Array.
     *
     * Copy from: https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/307351/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/[数组中的第K个最大元素-题解^]
     */
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int size = nums.length;
        return quickselect(0, size - 1, size - k);
    }

    /**
     * Runtime: 6 ms, faster than 62.37% of Java online submissions for Kth Largest Element in an Array.
     *
     * Memory Usage: 40.9 MB, less than 5.18% of Java online submissions for Kth Largest Element in an Array.
     */
    public int findKthLargestHeap(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }

    public int findKthLargestSort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        _0215_KthLargestElementInAnArray solution = new _0215_KthLargestElementInAnArray();
        int[] n1 = {3, 2, 1, 5, 6, 4};
        int r1 = solution.findKthLargest(n1, 2);
        System.out.println((r1 == 5) + " : " + r1);

        int[] n2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int r2 = solution.findKthLargest(n2, 4);
        System.out.println((r2 == 4) + " : " + r2);
    }
}
