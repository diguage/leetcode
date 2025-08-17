package com.diguage.algo.leetcode;

public class _0421_MaximumXorOfTwoNumbersInAnArray {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-08-11 20:09:06
   */

  Trie root = new Trie();
  int BITS = 30;

  public int findMaximumXOR(int[] nums) {
    int n = nums.length;
    int result = 0  ;
    for (int i = 1; i < n; i++) {
      add(nums[i - 1]);
      result = Math.max(result, check(nums[i]));
    }
    return result;
  }

  public void add(int num) {
    Trie curr = root;
    for (int i = BITS; i >= 0; i--) {
      int bit = (num >> i) & 1;
      if (bit == 0) {
        if (curr.left == null) {
          curr.left = new Trie();
        }
        curr = curr.left;
      } else {
        if (curr.right == null) {
          curr.right = new Trie();
        }
        curr = curr.right;
      }
    }
  }

  private int check(int num) {
    Trie curr = root;
    int result = 0;
    for (int i = BITS; i >= 0; i--) {
      int bit = (num >> i) & 1;
      if (bit == 0) {
        if (curr.right != null) {
          curr = curr.right;
          result = result * 2 + 1;
        } else {
          curr = curr.left;
          result = result * 2;
        }
      } else {
        if (curr.left != null) {
          curr = curr.left;
          result = result * 2 + 1;
        } else {
          curr = curr.right;
          result = result * 2;
        }
      }
    }
    return result;
  }

  public static class Trie {
    // 左树表示 0
    Trie left;
    // 右树表示 1
    Trie right;
  }
  // end::answer[]
}
