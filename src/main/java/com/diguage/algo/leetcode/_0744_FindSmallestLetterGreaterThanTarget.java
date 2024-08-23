package com.diguage.algo.leetcode;

public class _0744_FindSmallestLetterGreaterThanTarget {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-08-23 17:04:36
   */
  public char nextGreatestLetter(char[] letters, char target) {
    int length = letters.length;
    if (target >= letters[length - 1]) {
      return letters[0];
    }
    int left = 0, right = length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (target < letters[mid]) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return letters[left];
  }
  // end::answer[]
}
