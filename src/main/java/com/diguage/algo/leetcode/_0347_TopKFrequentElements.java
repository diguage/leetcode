package com.diguage.algo.leetcode;

import java.util.*;

/**
 * = 347. Top K Frequent Elements
 *
 * https://leetcode.com/problems/top-k-frequent-elements/[Top K Frequent Elements - LeetCode]
 *
 * Given a non-empty array of integers, return the `k` most frequent elements.
 *
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: nums = [1], k = 1
 * Output: [1]
 * ----
 *
 * *Note:*
 *
 * * You may assume `k` is always valid, `1 ≤ k ≤ number` of unique elements.
 * * Your algorithm's time complexity *must be* better than O(nlogn), where `n` is the array's size.
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-11 00:04
 */
public class _0347_TopKFrequentElements {
  // tag::answer[]
    /**
     * Runtime: 10 ms, faster than 98.24% of Java online submissions for Top K Frequent Elements.
     *
     * Memory Usage: 41.2 MB, less than 31.89% of Java online submissions for Top K Frequent Elements.
     *
     * Copy from: https://leetcode.com/problems/top-k-frequent-elements/discuss/81602/Java-O(n)-Solution-Bucket-Sort[Java O(n) Solution - Bucket Sort - LeetCode Discuss]
     *
     * @author D瓜哥 · https://www.diguage.com
     * @since 2020-01-11 00:04
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToCountMap = new HashMap<>();
        for (int num : nums) {
            Integer count = numToCountMap.getOrDefault(num, 0);
            numToCountMap.put(num, ++count);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : numToCountMap.entrySet()) {
            if (Objects.isNull(bucket[entry.getValue()])) {
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }
        List<Integer> result = new ArrayList<>(k);
        for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
            if (Objects.nonNull(bucket[i])) {
                result.addAll(bucket[i]);
            }
        }
        return result;
    }

    /**
     * Runtime: 12 ms, faster than 81.45% of Java online submissions for Top K Frequent Elements.
     *
     * Memory Usage: 40.3 MB, less than 69.83% of Java online submissions for Top K Frequent Elements.
     */
    public List<Integer> topKFrequentSort(int[] nums, int k) {
        Map<Integer, Integer> numToCountMap = new HashMap<>();
        for (int num : nums) {
            Integer count = numToCountMap.getOrDefault(num, 0);
            numToCountMap.put(num, ++count);
        }
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(numToCountMap.entrySet());
        entries.sort((e1, e2) -> e2.getValue() - e1.getValue());
        List<Integer> result = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            result.add(entries.get(i).getKey());
        }
        return result;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0347_TopKFrequentElements solution = new _0347_TopKFrequentElements();
        List<Integer> r1 = solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(r1.toArray()));
    }
}
