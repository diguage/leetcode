package com.diguage.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _1442_CountTripletsThatCanFormTwoArraysOfEqualXor {
  // tag::answer[]
  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2025-05-28 21:33:59
   */
  int result = 0;

  public int countTriplets(int[] arr) {
    backtrack(arr, new ArrayList<>());
    return result;
  }

  private void backtrack(int[] arr, List<Integer> path) {
    if (path.size() == 3) {
      Integer i = path.getFirst();
      Integer j = path.get(1);
      Integer k = path.getLast();
      int a = arr[i];
      for (int l = i + 1; l < j; l++) {
        a ^= arr[l];
      }
      int b = arr[j];
      for (int m = j + 1; m <= k; m++) {
        b ^= arr[m];
      }
      if (a == b) {
        result++;
      }
      return;
    }
    int idx = path.isEmpty() ? 0 : (path.size() == 1 ? path.getLast() + 1 : path.getLast());
    for (int i = idx; i < arr.length; i++) {
      path.add(i);
      backtrack(arr, path);
      path.removeLast();
    }
  }
  // end::answer[]
  public static void main(String[] args) {
    new _1442_CountTripletsThatCanFormTwoArraysOfEqualXor()
      .countTriplets(new int[]{218, 218});
  }
}
