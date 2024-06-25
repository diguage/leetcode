package com.diguage.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * = 992. Subarrays with K Different Integers
 *
 * https://leetcode.com/problems/subarrays-with-k-different-integers/[Subarrays with K Different Integers - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-30 19:44
 */
public class _0992_SubarraysWithKDifferentIntegers {
    /**
     * Runtime: 5 ms, faster than 93.74% of Java online submissions for Subarrays with K Different Integers.
     * Memory Usage: 51.9 MB, less than 5.26% of Java online submissions for Subarrays with K Different Integers.
     *
     * Copy from: https://mp.weixin.qq.com/s/6YeZUCYj5ft-OGa85sQegw[面试官，你再问我滑动窗口问题试试？我有解题模板，不怕！]
     */
    public int subarraysWithKDistinct(int[] A, int K) {
        if (Objects.isNull(A) || A.length == 0 || A.length < K) {
            return 0;
        }
        int[] hash = new int[A.length + 1];
        int left = 0, count = 0;
        int results = 0, result = 1;
        for (int right = 0; right < A.length; right++) {
            hash[A[right]]++;
            if (hash[A[right]] == 1) {
                count++;
            }
            while (hash[A[left]] > 1 || count > K) {
                if (count > K) {
                    result = 1;
                    count--;
                } else {
                    result++;
                }
                hash[A[left]]--;
                left++;
            }
            if (count == K) {
                results += result;
            }
        }
        return results;
    }

    /**
     * Runtime: 53 ms, faster than 67.75% of Java online submissions for Subarrays with K Different Integers.
     * Memory Usage: 43.9 MB, less than 10.53% of Java online submissions for Subarrays with K Different Integers.
     *
     * Copy from: https://leetcode-cn.com/problems/subarrays-with-k-different-integers/solution/k-ge-bu-tong-zheng-shu-de-zi-shu-zu-by-leetcode/[K 个不同整数的子数组 - K 个不同整数的子数组 - 力扣（LeetCode）]
     */
    public int subarraysWithKDistinctWindows(int[] A, int K) {
        if (Objects.isNull(A) || A.length == 0 || A.length < K) {
            return 0;
        }
        Window w1 = new Window();
        Window w2 = new Window();
        int result = 0;
        int left1 = 0, left2 = 0;
        for (int right = 0; right < A.length; right++) {
            int x = A[right];
            w1.add(x);
            w2.add(x);
            while (w1.different() > K) {
                w1.remove(A[left1++]);
            }
            while (w2.different() >= K) {
                w2.remove(A[left2++]);
            }
            result += left2 - left1;
        }
        return result;
    }

    private class Window {
        Map<Integer, Integer> count;
        int nonzeo;

        public Window() {
            count = new HashMap<>();
            nonzeo = 0;
        }

        void add(int x) {
            count.put(x, count.getOrDefault(x, 0) + 1);
            if (count.get(x) == 1) {
                nonzeo++;
            }
        }

        void remove(int x) {
            count.put(x, count.get(x) - 1);
            if (count.get(x) == 0) {
                nonzeo--;
            }
        }

        int different() {
            return nonzeo;
        }
    }

    public static void main(String[] args) {
        _0992_SubarraysWithKDifferentIntegers solution = new _0992_SubarraysWithKDifferentIntegers();
        int[] n1 = {1, 2, 1, 2, 3};
        int r1 = solution.subarraysWithKDistinct(n1, 2);
        System.out.println((r1 == 7) + " : " + r1);

        int[] n2 = {1, 2, 1, 3, 4};
        int r2 = solution.subarraysWithKDistinct(n2, 3);
        System.out.println((r2 == 3) + " : " + r2);
    }
}
