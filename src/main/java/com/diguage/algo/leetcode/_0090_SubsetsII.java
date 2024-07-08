package com.diguage.algo.leetcode;

import java.util.*;

/**
 * = 90. Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/[Subsets II - LeetCode]
 */
public class _0090_SubsetsII {
  // tag::answer[]
    /**
     * Runtime: 2 ms, faster than 27.76% of Java online submissions for Subsets II.
     * Memory Usage: 39.4 MB, less than 5.88% of Java online submissions for Subsets II.
     *
     * @author D瓜哥 · https://www.diguage.com
     * @since 2020-02-05 21:28
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayDeque<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, Deque<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            int num = nums[i];
            current.addLast(num);
            backtrack(nums, i + 1, current, result);
            current.removeLast();
        }
    }

    /**
     * Runtime: 2 ms, faster than 27.76% of Java online submissions for Subsets II.
     * Memory Usage: 39.3 MB, less than 5.88% of Java online submissions for Subsets II.
     *
     * Copy from: https://leetcode-cn.com/problems/subsets-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-19/[详细通俗的思路分析，多解法 - 子集 II - 力扣（LeetCode）]
     */
    public List<List<Integer>> subsetsWithDupAppend(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.emptyList());
        Arrays.sort(nums);
        //保存新解的开始位置
        int start = 1;
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> temp = new LinkedList<>();
            for (int j = 0; j < result.size(); j++) {
                //如果出现重复数字，就跳过所有旧解
                if (i > 0 && nums[i - 1] == nums[i] && j < start) {
                    continue;
                }
                List<Integer> list = result.get(j);
                List<Integer> newList = new ArrayList<>(list);
                newList.add(nums[i]);
                temp.add(newList);
            }
            start = result.size();
            result.addAll(temp);
        }
        return result;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0090_SubsetsII solution = new _0090_SubsetsII();
        System.out.println(Arrays.toString(solution.subsetsWithDup(new int[]{1, 2, 2}).toArray()));
    }
}
