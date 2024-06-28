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
    printCutLine(length, m.length);
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
    int rows = matrix.size();
    if (matrix == null || rows == 0) {
      return;
    }
    int length = Integer.MIN_VALUE;
    for (List<T> ts : matrix) {
      for (T t : ts) {
        length = Math.max(length, String.valueOf(t).length());
      }
    }
    int maxCols = Integer.MIN_VALUE;
    for (List<T> ts : matrix) {
      maxCols = Math.max(maxCols, ts.size());
    }
    System.out.println("\n");
    length = length + 3;
    String format = "%" + length + "s";
    for (int i = -1; i < maxCols; i++) {
      if (i == -1) {
        System.out.print(String.format(format, ""));
      } else {
        System.out.print(String.format(format, i));
      }
    }
    System.out.println("");
    printCutLine(length, rows);
    for (int i = 0; i < rows; i++) {
      System.out.println("");
      List<T> row = matrix.get(i);
      if (i % 3 == 0 && i != 0) {
        printCutLine(length, rows);
        System.out.println("");
      }
      for (int j = -1; j < row.size(); j++) {
        if (j == -1) {
          System.out.print(String.format("%" + (length - 1) + "s|", i));
        } else {
          System.out.print(String.format(format, row.get(j)));
        }
      }
    }
    System.out.println("\n");
  }

  private static void printCutLine(int length, int rows) {
    for (int i = 0; i < (length - String.valueOf(rows).length() - 1); i++) {
      System.out.print(" ");
    }
    for (int i = 0; i < length * rows + String.valueOf(rows).length() + 1; i++) {
      System.out.print("-");
    }
  }

  public static void printMatrix(char[][] array) {
    System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
    Arrays.stream(Arrays.deepToString(array).substring(1).split("], "))
      .forEach(System.out::println);
    System.out.println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
  }
}
