package com.diguage.algorithm.leetcode;

/**
 * = 96. Unique Binary Search Trees
 *
 * https://leetcode.com/problems/unique-binary-search-trees/[Unique Binary Search Trees - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-27 22:14
 */
public class _0096_UniqueBinarySearchTrees_2 {
  // tag::answer[]
  public int numTrees(int num) {
    int[] r = new int[num + 1];
    r[0] = 1;
    r[1] = 1;
    for (int n = 2; n <= num; n++) {
      for (int i = 1; i <= n; i++) {
        r[n] += r[i - 1] * r[n - i];
      }
    }
    return r[num];
  }


  // end::answer[]


  public static void main(String[] args) {
    _0096_UniqueBinarySearchTrees_2 solution = new _0096_UniqueBinarySearchTrees_2();
    int r1 = solution.numTrees(3);
    System.out.println((r1 == 5) + " : " + r1);
  }
}
