package com.diguage.algorithm.util;

import java.util.Arrays;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2019-10-26 00:56
 */
public class PrintUtils {
    public static void printMatrix(int[][] array) {
        System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
        Arrays.stream(Arrays.deepToString(array).substring(1).split("], "))
                .forEach(System.out::println);
        System.out.println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
    }
}
