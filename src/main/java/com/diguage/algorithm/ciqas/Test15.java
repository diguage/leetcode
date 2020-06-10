package com.diguage.algorithm.ciqas;

/**
 * {@link com.diguage.algorithm.leetcode._0191_NumberOf1Bits}
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-04-26 16:59
 */
public class Test15 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                result++;
            }
            n >>>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Test15 test = new Test15();
        System.out.println(test.hammingWeight(3));
    }
}
