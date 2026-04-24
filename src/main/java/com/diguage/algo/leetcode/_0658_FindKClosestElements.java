package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _0658_FindKClosestElements {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-04-24 22:17:44
   */
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    if (x <= arr[0]) {
      return subarray(arr, 0, k - 1);
    } else if (arr[arr.length - 1] <= x) {
      return subarray(arr, arr.length - k, arr.length - 1);
    } else {
      int index = search(arr, x);
      List<Integer> result = new LinkedList<>();
      if (arr[index] != x) {
        index = closer(arr, x, index - 1, index);
      }
      result.add(arr[index]);
      int start = index - 1;
      int end = index + 1;
      while (result.size() < k) {
        if (start < 0) {
          result.addLast(arr[end]);
          end++;
        } else if (arr.length <= end) {
          result.addFirst(arr[start]);
          start--;
        } else {
          int closer = closer(arr, x, start, end);
          if (closer == start) {
            result.addFirst(arr[start]);
            start--;
          } else {
            result.addLast(arr[end]);
            end++;
          }
        }
      }
      return result;
    }
  }

  private int closer(int[] arr, int x, int a, int b) {
    int an = arr[a];
    int bn = arr[b];
    return Math.abs(x - an) < Math.abs(x - bn)
      || (Math.abs(x - an) == Math.abs(x - bn) && an < bn) ? a : b;
  }

  private int search(int[] arr, int x) {
    int left = 0, right = arr.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] < x) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

  private List<Integer> subarray(int[] arr, int start, int end) {
    List<Integer> result = new ArrayList<>();
    for (int i = start; i <= end; i++) {
      result.add(arr[i]);
    }
    return result;
  }
  // end::answer[]

  static void main() {
    new _0658_FindKClosestElements()
      .findClosestElements(new int[]{1, 2, 4, 4, 5}, 4, 3);
  }
}
