package com.diguage.algorithm.leetcode;

/**
 * = 96. Unique Binary Search Trees
 *
 * https://leetcode.com/problems/unique-binary-search-trees/[Unique Binary Search Trees - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-27 22:14
 */
public class _0096_UniqueBinarySearchTrees {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Binary Search Trees.
     * Memory Usage: 38.2 MB, less than 5.55% of Java online submissions for Unique Binary Search Trees.
     *
     * Copy from: https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode/[不同的二叉搜索树 - 不同的二叉搜索树 - 力扣（LeetCode）]
     */
    public int numTreesCatalanNumber(int n) {
        long C = 1;
        for (int i = 0; i < n; i++) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Binary Search Trees.
     * Memory Usage: 36 MB, less than 5.55% of Java online submissions for Unique Binary Search Trees.
     *
     * Copy from: https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode/[不同的二叉搜索树 - 不同的二叉搜索树 - 力扣（LeetCode）]
     */
    public int numTrees(int n) {
        int[] g = new int[n + 1];
        g[0] = 1;
        g[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                g[i] += g[j - 1] * g[i - j];
            }
        }
        return g[n];
    }

    public static void main(String[] args) {
        _0096_UniqueBinarySearchTrees solution = new _0096_UniqueBinarySearchTrees();
        int r1 = solution.numTrees(3);
        System.out.println((r1 == 5) + " : " + r1);
    }
}
