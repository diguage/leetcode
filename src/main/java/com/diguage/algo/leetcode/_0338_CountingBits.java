package com.diguage.algo.leetcode;

import java.util.Arrays;

/**
 * = 338. Counting Bits
 * <p>
 * https://leetcode.com/problems/counting-bits/[Counting Bits - LeetCode]
 *
 * @author D瓜哥 · https://www.diguage.com
 * @since 2020-01-29 14:50
 */
public class _0338_CountingBits {
  // tag::answer[]
    /**
     * Runtime: 1 ms, faster than 99.73% of Java online submissions for Counting Bits.
     * Memory Usage: 43 MB, less than 5.88% of Java online submissions for Counting Bits.
     * <p>
     * Copy from: https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode/[比特位计数 - 比特位计数 - 力扣（LeetCode）]
     */
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        int b = 1;
        int i = 0;
        while (b <= num) {
            while (i < b && i + b <= num) {
                result[i + b] = result[i] + 1;
                ++i;
            }
            i = 0;
            b <<= 1;
        }
        return result;
    }

    /**
     * Runtime: 3 ms, faster than 24.83% of Java online submissions for Counting Bits.
     * Memory Usage: 43 MB, less than 5.88% of Java online submissions for Counting Bits.
     */
    public int[] countBitsEvenOdd(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i += 2) {
            result[i] = bitsInNum(i);
        }
        for (int i = 1; i <= num; i += 2) {
            result[i] = result[i - 1] + 1;
        }
        return result;
    }

    private int bitsInNum(int num) {
        int result = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                result++;
            }
            num = num >>> 1;
        }
        return result;
    }

  // end::answer[]


    public static void main(String[] args) {
        _0338_CountingBits solution = new _0338_CountingBits();
        System.out.println(Arrays.toString(solution.countBits(2)));
        System.out.println(Arrays.toString(solution.countBits(5)));
        System.out.println(Arrays.toString(solution.countBits(10)));

for (int i = 0; i < 99; i++) {
    int j = 0;
    for (; Math.pow(2, j) <= i; j++) {
        if (Math.pow(2, j) == i && i != 1) {
            System.out.println("---");
        }
    }
    System.out.printf("%2d  %10s\n", i, Integer.toBinaryString(i));
}
    }
}
