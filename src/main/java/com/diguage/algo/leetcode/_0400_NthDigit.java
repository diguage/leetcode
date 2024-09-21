package com.diguage.algo.leetcode;

public class _0400_NthDigit {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2024-09-21 18:58:09
   */
  public int findNthDigit(int n) {
    int digit = 1;  // n所在数字有几位数
    long start = 1; // 每digit位的起始数字，1位数从2开始，2位数从10开始..
    long count = 9; // 所有digit位数的数位数量, 所有1位数有9个位，所有的2位数90x2个位..
    // 1. 确定n所在的数字的位数digit
    //  循环执行 n 减去 一位数、两位数、... 的数位数量 count ，直至 n≤count 时跳出。
    while (n > count) {
      n -= count;  // n分别减去1位数 2位数 3位数的个数..
      start *= 10;
      digit += 1;
      count = digit * start * 9;
    }
    // 2. 确定n所在的数字num，n-1是从0开始计算偏移量
    //   所求数位在从数字 start 开始的第 [(n−1)/digit] 个 数字 中（start 为第 0 个数字）。
    long num = start + (n - 1) / digit;
    // 3. 确定所求数位是 num 的第几位数字，从0算起
    //    所求数位为数字 num 的第 (n−1)%digit 位（数字的首个数位为第 0 位）。
    // 注：上面第二步已经确定在哪个数字了，那么取余就是找在该数中的第多少位。
    //     能整除的部分，已经在前面n-1个数字中了
    return Long.toString(num).charAt((n - 1) % digit) - '0';
  }
  // end::answer[]

  public static void main(String[] args) {
    new _0400_NthDigit().findNthDigit(300);
  }
}
