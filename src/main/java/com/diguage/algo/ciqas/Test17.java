package com.diguage.algo.ciqas;

import java.util.Arrays;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2020-04-26 18:41
 */
public class Test17 {
    public int[] printNumbers(int n) {
        if (n <= 0) {
            return new int[0];
        }
        int num = 0;
        while (n > 0) {
            num = num * 10 + 9;
            n--;
        }
        int[] result = new int[num];
        for (int i = 0; i < num; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Test17 test = new Test17();
        System.out.println(Arrays.toString(test.printNumbers(3)));
    }
}
