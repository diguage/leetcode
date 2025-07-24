package com.diguage.algo.leetcode;

public class _0374_GuessNumberHigherOrLower {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-07-24 19:03:06
   */
  public int guessNumber(int n) {
    int left = 1, right = n;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int temp = guess(mid);
      if (temp == 0) {
        return mid;
      } else if (temp == 1) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }
  // 内置函数，不需要自己实现
  int guess(int num) {
    return 0;
  }
  // end::answer[]

}
