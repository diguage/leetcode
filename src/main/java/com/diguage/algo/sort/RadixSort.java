package com.diguage.algo.sort;

import java.util.Arrays;

public class RadixSort {
  // tag::answer[]
  /**
   * 基数排序
   *
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-06-29 15:45:01
   */
  public void radixSort(int[] array) {
    if (null == array || array.length < 2) {
      return;
    }
    int max = Arrays.stream(array).max().orElse(0);
    int length = array.length;
    for (int exp = 1; exp < max; exp *= 10) {
      int[] counter = new int[10];
      for (int num : array) {
        // 获取指定位的值
        int digit = (num / exp) % 10;
        counter[digit]++;
      }
      // 将数量从小向大汇总，
      // 稍作处理即可映射出每个数字应该存储的坐标
      for (int i = 1; i < 10; i++) {
        counter[i] += counter[i - 1];
      }
      // 存储临时结果
      int[] temp = new int[length];
      for (int i = length - 1; i >= 0; i--) {
        int digit = (array[i] / exp) % 10;
        // counter[digit] 是一个数量统计，-1 是指向应该存储的坐标
        int index = counter[digit] - 1;
        temp[index] = array[i];
        counter[digit]--;
      }
      for (int i = 0; i < length; i++) {
        array[i] = temp[i];
      }
    }
  }

  // end::answer[]
  public static void main(String[] args) {
    new RadixSort().radixSort(new int[]{3, 6, 9, 1});
  }
}
