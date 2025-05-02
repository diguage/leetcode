package com.diguage.algo.leetcode;

public class _0137_SingleNumberIi_2 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-02 07:17:29
   */
  public int singleNumber(int[] nums) {
    int[] bits = new int[32];
    for (int num : nums) {
      // num != 0 在小一点的正数，可以尽早结束循环
      for (int i = 0; num != 0 && i < 32; i++, num >>>= 1) {
        if ((num & 1) == 1) {
          bits[i]++;
        }
      }
    }
    int result = 0;
    for (int i = 31; i >= 0; i--) {
      result <<= 1;
      if (bits[i] % 3 == 1) {
        result |= 1;
      }
    }
    //    int result = 0;
    //    int pow = 1;
    //    for (int i = 0; i < 32; i++) {
    //      if (bits[i] % 3 == 1) {
    //        if (i < 31) {
    //          result += pow;
    //        } else {
    //          // TODO 这个地方该如何使用补码得到负数？
    //          result = -result;
    //        }
    //      }
    //      pow *= 2;
    //    }
    return result;
  }

  // end::answer[]
  public static void main(String[] args) {
    new _0137_SingleNumberIi_2()
//      .singleNumber(new int[]{-2, -2, 1, 1, 4, 1, 4, 4, -4, -2});
      .singleNumber(new int[]{-4});
  }
}
