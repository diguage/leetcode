package com.diguage.algorithm.leetcode;

import java.util.*;

/**
 * = 60. Permutation Sequence
 *
 * https://leetcode.com/problems/permutation-sequence/[Permutation Sequence - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-02-03 22:42
 */
public class _0060_PermutationSequence {
  // tag::answer[]

    /**
     * Runtime: 1 ms, faster than 99.26% of Java online submissions for Permutation Sequence.
     * Memory Usage: 37.2 MB, less than 20.83% of Java online submissions for Permutation Sequence.
     *
     * Copy from: https://leetcode-cn.com/problems/permutation-sequence/solution/hui-su-jian-zhi-python-dai-ma-java-dai-ma-by-liwei/[深度优先遍历 + 剪枝、双链表模拟 - 第k个排列 - 力扣（LeetCode）]
     */
    private boolean[] used;
    private int[] factorial;
    private int n;
    private int k;
    private List<Integer> path;
    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        used = new boolean[n + 1];
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        path = new ArrayList<>();
        dfs(0);
        StringBuilder builder = new StringBuilder();
        for (Integer integer : path) {
            builder.append(integer);
        }
        return builder.toString();
    }

    private void dfs(int index) {
        if (index == n) {
            return;
        }
        int cnt = factorial[n - 1 - index];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            path.add(i);
            used[i] = true;
            dfs(index + 1);
        }
    }

    /**
     * Time Limit Exceeded
     */
    public String getPermutationRecursion(int n, int k) {
        List<Integer> nums = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        List<String> permutations = new LinkedList<>();
        permutations(nums, 0, permutations);
        ArrayList<String> sp = new ArrayList<>(permutations);
        sp.sort(Comparator.naturalOrder());
        return sp.get(k - 1);
    }

    private void permutations(List<Integer> nums, int index, List<String> result) {
        if (index == nums.size()) {
            StringBuilder builder = new StringBuilder(index);
            for (int num : nums) {
                builder.append(num);
            }
            result.add(builder.toString());
            return;
        }
        for (int i = index; i < nums.size(); i++) {
            Collections.swap(nums, i, index);
            permutations(nums, index + 1, result);
            Collections.swap(nums, i, index);
        }
    }

  // end::answer[]


    public static void main(String[] args) {
        _0060_PermutationSequence solution = new _0060_PermutationSequence();

        String r1 = solution.getPermutation(3, 3);
        System.out.println("213".equals(r1) + " : " + r1);

        String r2 = solution.getPermutation(4, 9);
        System.out.println("2314".equals(r2) + " : " + r2);
    }
}
