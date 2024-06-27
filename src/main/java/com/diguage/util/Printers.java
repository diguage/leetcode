package com.diguage.util;

import java.util.Arrays;
import java.util.List;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2019-10-26 00:56
 */
public class Printers {
    public static void printMatrix(int[][] m) {
      if (m == null || m.length == 0) return;
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < m.length; i++) {
        for (int j = 0; j < m[i].length; j++) {
          max = Math.max(max, m[i][j]);
        }
      }
      System.out.println("\n");
      int length = String.valueOf(max).length() + 3;
      String format = "%" + length + "s";
      for (int i = -1; i < m[0].length; i++) {
        if (i == -1) {
          System.out.print(String.format(format, ""));
        } else {
          System.out.print(String.format(format, i));
        }
      }
      System.out.println("");
      for (int i = 0; i < (length - String.valueOf(m.length).length() - 1); i++) {
        System.out.print(" ");
      }
      for (int i = 0; i < length * m[0].length + String.valueOf(m.length).length() + 1; i++) {
        System.out.print("-");
      }
      for (int i = 0; i < m.length; i++) {
        System.out.println("");
        for (int j = -1; j < m[i].length; j++) {
          if (j == -1) {
            System.out.print(String.format("%" + (length - 1) + "s|", i));
          } else {
            System.out.print(String.format(format, m[i][j]));
          }
        }
      }

      System.out.println("\n");
    }

    public static <T> void printMatrix(List<List<T>> matrix) {
        for (List<T> list : matrix) {
            for (T t : list) {
                System.out.println(t);
            }
            System.out.println("--------------------");
        }
    }

    public static void printMatrix(char[][] array) {
        System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
        Arrays.stream(Arrays.deepToString(array).substring(1).split("], "))
                .forEach(System.out::println);
        System.out.println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
    }
}
