package com.diguage.algo.ciqas;

/**
 * {@link com.diguage.algo.leetcode._0343_IntegerBreak}
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-04-26 15:29
 */
public class Test14 {
    public int cuttingRope(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int timeOf3 = n / 3;
        int mod = n % 3;
        if (mod == 0) {
            return (int) Math.pow(3, timeOf3);
        }
        if (mod == 1) {
            return (int) Math.pow(3, timeOf3 - 1) * (3 + 1);
        }
        return (int) Math.pow(3, timeOf3) * 2;
    }

    public int cuttingRopeDp(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int[] products = new int[n + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        for (int i = 4; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
            }
            products[i] = max;
        }
        return products[n];
    }

    public static void main(String[] args) {
        Test14 test = new Test14();
        System.out.println(test.cuttingRope(10));
    }
}
