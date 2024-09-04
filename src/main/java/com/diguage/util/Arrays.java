package com.diguage.util;

public class Arrays {
  public static void reverse(int[] array) {
    if (array == null || array.length == 0) {
      return;
    }
    for (int l = 0, r = array.length - 1; l < r; l++, r--) {
      int temp = array[l];
      array[l] = array[r];
      array[r] = temp;
    }
  }
}
