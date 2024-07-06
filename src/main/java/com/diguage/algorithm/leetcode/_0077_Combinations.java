package com.diguage.algorithm.leetcode;

import java.util.*;

/**
 * = 77. Combinations
 *
 * https://leetcode.com/problems/combinations/[Combinations - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-04 17:43
 */
public class _0077_Combinations {
  // tag::answer[]
    /**
     * Runtime: 20 ms, faster than 58.94% of Java online submissions for Combinations.
     * Memory Usage: 42.7 MB, less than 6.52% of Java online submissions for Combinations.
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(n, k, 1, result, new LinkedList<>());
        return result;
    }

    private void dfs(int n, int k, int first, List<List<Integer>> result, Deque<Integer> current) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = first; i <= n; i++) {
            current.addLast(i);
            dfs(n, k, i + 1, result, current);
            current.removeLast();
        }
    }

  // end::answer[]


    public static void main(String[] args) {
        _0077_Combinations solution = new _0077_Combinations();
        System.out.println(Arrays.toString(solution.combine(4, 2).toArray()));
    }
}
