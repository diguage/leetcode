package com.diguage.algo.leetcode;

public class _0476_NumberComplement {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-09-02 21:49:25
   */
  public int findComplement(int num) {
    int[] bits = new int[32];
    int cnt = 0;
    while (cnt < bits.length) {
      bits[cnt] = num & 1;
      num >>= 1;
      if (num > 0) {
        cnt++;
      } else {
        break;
      }
    }
    int result = bits[cnt--] == 0 ? 1 : 0;
    while (cnt >= 0) {
      result = (result * 2) + (bits[cnt] == 0 ? 1 : 0);
      cnt--;
    }
    return result;
  }
  // end::answer[]
  public static void main(String[] args) {
    new _0476_NumberComplement().findComplement(5);
  }
}
