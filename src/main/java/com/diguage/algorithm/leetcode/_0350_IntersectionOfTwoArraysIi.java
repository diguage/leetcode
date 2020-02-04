package com.diguage.algorithm.leetcode;

import java.util.*;

/**
 * = 350. Intersection of Two Arrays II
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * ----
 *
 * *Note:*
 *
 * * Each element in the result should appear as many times as it shows in both arrays.
 * * The result can be in any order.
 *
 * *Follow up:*
 *
 * * What if the given array is already sorted? How would you optimize your algorithm?
 * * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-01-11 10:00
 */
public class _0350_IntersectionOfTwoArraysIi {

    /**
     * Runtime: 2 ms, faster than 88.63% of Java online submissions for Intersection of Two Arrays II.
     *
     * Memory Usage: 37 MB, less than 83.87% of Java online submissions for Intersection of Two Arrays II.
     *
     * Copy from: https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/82241/AC-solution-using-Java-HashMap/86567[AC solution using Java HashMap - LeetCode Discuss]
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (Objects.isNull(nums1) || nums1.length == 0
                || Objects.isNull(nums2) || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> resultList = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                resultList.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[resultList.size()];
        for (int k = 0; k < result.length; k++) {
            result[k] = resultList.get(k);
        }
        return result;
    }

    /**
     * Runtime: 4 ms, faster than 24.04% of Java online submissions for Intersection of Two Arrays II.
     *
     * Memory Usage: 36.8 MB, less than 83.87% of Java online submissions for Intersection of Two Arrays II.
     */
    public int[] intersectMap(int[] nums1, int[] nums2) {
        if (Objects.isNull(nums1) || nums1.length == 0
                || Objects.isNull(nums2) || nums2.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> numToCountMap1 = getNumToCountMap(nums1);
        // 这个其实没有必要，可以直接循环生成结果List，把原来的count值逐渐减少就好
        Map<Integer, Integer> numToCountMap2 = getNumToCountMap(nums2);
        Map<Integer, Integer> small, big;
        if (numToCountMap1.size() > numToCountMap2.size()) {
            big = numToCountMap1;
            small = numToCountMap2;
        } else {
            big = numToCountMap2;
            small = numToCountMap1;
        }
        Map<Integer, Integer> resultMap = new HashMap<>();
        int resultLength = 0;
        for (Map.Entry<Integer, Integer> entry : small.entrySet()) {
            Integer num = entry.getKey();
            Integer count = big.getOrDefault(num, 0);
            if (count > 0) {
                int minCount = Math.min(entry.getValue(), count);
                resultMap.put(num, minCount);
                resultLength += minCount;
            }
        }
        int[] result = new int[resultLength];
        for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                result[--resultLength] = entry.getKey();
            }
        }
        return result;
    }

    private Map<Integer, Integer> getNumToCountMap(int[] nums1) {
        Map<Integer, Integer> numToCountMap1 = new HashMap<>();
        for (int num : nums1) {
            Integer count = numToCountMap1.getOrDefault(num, 0);
            numToCountMap1.put(num, ++count);
        }
        return numToCountMap1;
    }

    public static void main(String[] args) {
        _0350_IntersectionOfTwoArraysIi solution = new _0350_IntersectionOfTwoArraysIi();
        int[] r1 = solution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        System.out.println(Arrays.toString(r1));
    }
}
