package com.diguage.algo.sort;

public class QuickSort {
  // tag::answer[]

  /**
   * 快速排序，参考《算法·第4版》
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-10-16 11:27:33
   */
  public void quickSort(Comparable[] array) {
    sort(array, 0, array.length - 1);
  }

  private void sort(Comparable[] array, int lo, int hi) {
    if (lo >= hi) {
      return;
    }
    int j = partition(array, lo, hi);
    sort(array, lo, j - 1);
    sort(array, j + 1, hi);
  }

  private int partition(Comparable[] array, int lo, int hi) {
    int i = lo, j = hi + 1;
    Comparable v = array[lo];
    while (true) {
      while (array[++i].compareTo(v) < 0) {
        if (i == hi) {
          break;
        }
      }
      while (v.compareTo(array[--j]) < 0) {
        if (j == lo) {
          break;
        }
      }
      if (i >= j) {
        break;
      }
      swap(array, i, j);
    }
    swap(array, lo, j);
    return j;
  }

  private void swap(Comparable[] array, int i, int j) {
    Comparable temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  // end::answer[]
  static void main() {
    new QuickSort().quickSort(new Integer[]{5, 9, 6, 2, 8, 3, 7, 1, 4});
  }
}
