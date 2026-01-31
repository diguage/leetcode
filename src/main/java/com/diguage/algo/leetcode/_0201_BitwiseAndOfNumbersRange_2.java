package com.diguage.algo.leetcode;

public class _0201_BitwiseAndOfNumbersRange_2 {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-01-31 21:06:30
   */
  public int rangeBitwiseAnd(int left, int right) {
    int bit = 32 - Integer.numberOfLeadingZeros(left ^ right);
    return left & (~((1 << bit) - 1));
    // 下面的方案超时（8265/8272）
    //    int[] bits = new int[32];
    //    for (int i = 0; i < 32 && (right >> i != 0); i++) {
    //      int bit = 1;
    //      for (int j = left; j <= right; j++) {
    //        bit &= (j >> i);
    //        if (bit == 0) {
    //          break;
    //        }
    //        if (j + 1 < j) {
    //          break;
    //        }
    //      }
    //      bits[i] = bit;
    //    }
    //    int result = 0;
    //    for (int i = 31; i >= 0; i--) {
    //      result <<= 1;
    //      result |= bits[i];
    //    }
    //    return result;
  }
  // end::answer[]

  static void main() {
    new _0201_BitwiseAndOfNumbersRange_2()
      .rangeBitwiseAnd(2147483646, 2147483647);
//      .rangeBitwiseAnd(5, 7);
//      .rangeBitwiseAnd(1, 2147483647);
  }
}
