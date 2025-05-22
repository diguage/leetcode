package com.diguage.algo.leetcode;

import com.diguage.algo.util.TreeNode;

public class _1457_PseudoPalindromicPathsInABinaryTree {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-22 18:40:51
   */
  int result = 0;

  public int pseudoPalindromicPaths(TreeNode root) {
    int[] counter = new int[10];
    backtrack(root, counter);
    return result;
  }

  private void backtrack(TreeNode root, int[] counter) {
    if (root == null) {
      return;
    }
    counter[root.val]++;
    if (root.left == null && root.right == null) {
      if (isPalindromic(counter)) {
        result++;
      }
    } else {
      backtrack(root.left, counter);
      backtrack(root.right, counter);
    }
    counter[root.val]--;
  }

  private boolean isPalindromic(int[] counter) {
    int cnt = 0;
    for (int value : counter) {
      if ((value & 1) == 1) {
        cnt++;
        if (cnt == 2) {
          break;
        }
      }
    }
    return cnt < 2;
  }
  // end::answer[]
}
