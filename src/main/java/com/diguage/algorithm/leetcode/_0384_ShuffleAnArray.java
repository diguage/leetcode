package com.diguage.algorithm.leetcode;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

/**
 * = 384. Shuffle an Array
 *
 * https://leetcode.com/problems/shuffle-an-array/[Shuffle an Array - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-27 15:51
 */
public class _0384_ShuffleAnArray {
  // tag::answer[]

    /**
     * Runtime: 146 ms, faster than 8.33% of Java online submissions for Shuffle an Array.
     *
     * Memory Usage: 95.1 MB, less than 6.45% of Java online submissions for Shuffle an Array.
     *
     * Copy from: https://leetcode.com/problems/shuffle-an-array/solution/[Shuffle an Array - LeetCode]
     */
    class Solution {
        private int[] origin;

        public Solution(int[] nums) {
            this.origin = nums;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return this.origin;
        }

        /**
         * Returns a random shuffling of the array.
         *
         * Fisher-Yates Algorithm
         */
        public int[] shuffle() {
            if (Objects.isNull(this.origin)) {
                return null;
            }
            int[] result = this.origin.clone();
            ThreadLocalRandom random = ThreadLocalRandom.current();
            int length = this.origin.length;
            for (int i = 0; i < length; i++) {
                int temp = result[i];
                int index = random.nextInt(i, length);
                result[i] = result[index];
                result[index] = temp;
            }
            return result;
        }
    }

    /**
     * Runtime: 90 ms, faster than 39.11% of Java online submissions for Shuffle an Array.
     *
     * Memory Usage: 50.7 MB, less than 100.00% of Java online submissions for Shuffle an Array.
     */
    class SolutionBruteForce {
        private int[] origin;

        public SolutionBruteForce(int[] nums) {
            this.origin = nums;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return this.origin;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            if (Objects.isNull(this.origin)) {
                return null;
            }
            int[] result = new int[this.origin.length];
            ThreadLocalRandom random = ThreadLocalRandom.current();
            LinkedHashSet<Integer> index = new LinkedHashSet<>();
            while (index.size() < this.origin.length) {
                index.add(random.nextInt(this.origin.length));
            }
            int i = 0;
            for (Integer integer : index) {
                result[i++] = this.origin[integer];
            }
            return result;
        }
    }

    private void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        Solution solution = new Solution(nums);
        int[] reset = solution.reset();
        int[] shuffle = solution.shuffle();
    }

  // end::answer[]


    public static void main(String[] args) {
        _0384_ShuffleAnArray solution = new _0384_ShuffleAnArray();
        solution.test();
    }
}
