package com.diguage.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0347_TopKFrequentElements_5 {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-09-20 23:10:30
   *
   * TODO 这个代码还有问题！！！
   */
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    int[] array = new int[map.size()];
    int i = 0;
    for (Integer num : map.keySet()) {
      array[i++] = num;
    }
    quickselect(map, array, k, 0, map.size() - 1);
    int[] result = new int[k];
    System.arraycopy(array, 0, result, 0, k);
    return result;
  }

  private void quickselect(Map<Integer, Integer> map,
                           int[] array, int k, int left, int right) {
    if (left >= right || k - 1 <= left) {
      return;
    }
    int l = left - 1, r = right + 1;
    int pivot = map.get(array[left]);
    while (l < r) {
      do {
        l++;
      } while (l < r && map.get(array[l]) > pivot);
      do {
        r--;
      } while (l < r && map.get(array[r]) < pivot);
      if (l < r) {
        swap(array, l, r);
      }
    }

    if (k - 1 < r) {
      quickselect(map, array, k, left, r);
    } else {
      quickselect(map, array, k, r + 1, right);
    }
  }

  private void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }

  // end::answer[]

  static void main() {
    new _0347_TopKFrequentElements_5()
//      .topKFrequent(new int[]{5, 2, 5, 3, 5, 3, 1, 1, 3}, 2);
      .topKFrequent(new int[]{1, 2, 1, 2, 1, 2, 3, 1, 3, 2}, 2);
  }
}
