package com.diguage.algo.leetcode;

/**
 * = 190. Reverse Bits
 *
 * https://leetcode.com/problems/reverse-bits/[Reverse Bits - LeetCode]
 *
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * .Example 1:
 * [source]
 * ----
 * Input: 00000010100101000001111010011100
 * Output: 00111001011110000010100101000000
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
 * ----
 *
 * .Example 2:
 * [source]
 * ----
 * Input: 11111111111111111111111111111101
 * Output: 10111111111111111111111111111111
 * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.
 * ----
 *
 * *Note:*
 *
 * * Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
 * * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in *Example 2* above the input represents the signed integer `-3` and the output represents the signed integer `-1073741825`.
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-15 22:55
 */
public class _0190_ReverseBits {
  // tag::answer[]
    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse Bits.
     *
     * Memory Usage: 36.6 MB, less than 7.32% of Java online submissions for Reverse Bits.
     *
     * Copy from: https://leetcode.com/problems/reverse-bits/discuss/54746/Java-Solution-and-Optimization[Java Solution and Optimization - LeetCode Discuss]
     */
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;
            if (i < 31) {
                result <<= 1;
            }
        }
        return result;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0190_ReverseBits solution = new _0190_ReverseBits();
        int r2 = solution.reverseBits(2);
        System.out.println((r2 == 964176192) + " : " + r2);

        int r1 = solution.reverseBits(43261596);
        System.out.println((r1 == 964176192) + " : " + r1);
    }
}
