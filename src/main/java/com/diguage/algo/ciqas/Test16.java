package com.diguage.algo.ciqas;

/**
 * {@link com.diguage.algo.leetcode._0050_PowXN}
 *
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-04-26 17:03
 */
public class Test16 {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double semiPow = myPow(x, n / 2);
        if (Double.isInfinite(semiPow)) {
            return 0.0;
        }
        return (n % 2 == 0 ? 1 : x) * semiPow * semiPow;
    }

    public static void main(String[] args) {
        Test16 test = new Test16();
        System.out.println(test.myPow(2, 4));
    }
}
