package com.diguage.algo.leetcode;

public class _0202_HappyNumber_2 {
  // tag::answer[]

/**
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-10 21:40
 */
public boolean isHappy(int n) {
  int slow = n, fast = n;
  do {
    slow = squareSum(slow);
    fast = squareSum(fast);
    fast = squareSum(fast);
    if (fast == 1) {
      return true;
    }
  } while (slow != fast);

  return false;
}

private int squareSum(int num) {
  int sum = 0;
  while (num > 0) {
    int n = num % 10;
    sum += n * n;
    num /= 10;
  }
  return sum;
}
// end::answer[]
}
