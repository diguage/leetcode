package com.diguage.algo.sort;

public class MergeSort {
  // tag::answer[]

  /**
   * 数组：归并排序
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-11-03 20:51:11
   */
  public void mergeSort(Comparable[] array) {
    sort(array, 0, array.length - 1);
  }

  private void sort(Comparable[] array, int low, int high) {
    if (low >= high) {
      return;
    }
    int mid = low + (high - low) / 2;
    sort(array, low, mid);
    sort(array, mid + 1, high);
    merge(array, low, mid, high);
  }

  private void merge(Comparable[] array, int low, int mid, int high) {
    Comparable[] temp = new Comparable[high - low + 1];
    int i = low, j = mid + 1, k = 0;
    for (; k < temp.length && i <= mid && j <= high; k++) {
      if (array[i].compareTo(array[j]) <= 0) {
        temp[k] = array[i++];
      } else {
        temp[k] = array[j++];
      }
    }
    // 只需要拷贝前半截剩余部分
    if (i <= mid) {
      int length = temp.length - k;
      System.arraycopy(array, i, temp, k, length);
      k += length;
    }
    // 后半截剩余部分不需要拷贝
    System.arraycopy(temp, 0, array, low, k);
  }
  // end::answer[]
  static void main() {
    new MergeSort().mergeSort(new Integer[]{6, 5, 3, 1, 8, 7, 2, 4});
  }
}
